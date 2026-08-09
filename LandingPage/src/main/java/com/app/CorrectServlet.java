package com.app;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple servlet that sends text to the public LanguageTool API for grammar
 * and spelling checking, then builds a corrected version of the sentence by
 * applying the first suggested replacement for each detected issue.
 *
 * Public API docs: https://languagetool.org/http-api/
 * (You can also self-host LanguageTool and point LANGUAGETOOL_URL at it.)
 */
@WebServlet("/CorrectServlet")
public class CorrectServlet extends HttpServlet {

    private static final String LANGUAGETOOL_URL = "https://api.languagetool.org/v2/check";

    private final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String text = request.getParameter("text");

        JSONObject result = new JSONObject();

        if (text == null || text.trim().isEmpty()) {
            result.put("error", "Please enter some text to check.");
            writeJson(response, result, HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        try {
            // LanguageTool's /check endpoint expects application/x-www-form-urlencoded
            String formBody = "text=" + URLEncoder.encode(text, StandardCharsets.UTF_8)
                    + "&language=" + URLEncoder.encode("en-US", StandardCharsets.UTF_8);

            HttpRequest apiRequest = HttpRequest.newBuilder()
                    .uri(URI.create(LANGUAGETOOL_URL))
                    .timeout(Duration.ofSeconds(15))
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .POST(HttpRequest.BodyPublishers.ofString(formBody))
                    .build();

            HttpResponse<String> apiResponse = httpClient.send(apiRequest, HttpResponse.BodyHandlers.ofString());

            if (apiResponse.statusCode() == 200) {
                JSONObject apiJson = new JSONObject(apiResponse.body());
                JSONArray matches = apiJson.optJSONArray("matches");

                String correctedText = applyCorrections(text, matches);

                result.put("originalText", text);
                result.put("correctedText", correctedText);
                result.put("issueCount", matches == null ? 0 : matches.length());
                writeJson(response, result, HttpServletResponse.SC_OK);
            } else {
                result.put("error", "LanguageTool API returned status " + apiResponse.statusCode());
                writeJson(response, result, HttpServletResponse.SC_BAD_GATEWAY);
            }

        } catch (Exception e) {
            result.put("error", "Failed to reach correction service: " + e.getMessage());
            writeJson(response, result, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Applies the first suggested replacement for each LanguageTool "match"
     * to build a corrected version of the original text.
     *
     * Matches are applied from the END of the string backwards so that
     * earlier offsets stay valid as we edit the string.
     */
    private String applyCorrections(String originalText, JSONArray matches) {
        if (matches == null || matches.length() == 0) {
            return originalText;
        }

        // Collect (offset, length, replacement) triples
        List<int[]> positions = new ArrayList<>();
        List<String> replacements = new ArrayList<>();

        for (int i = 0; i < matches.length(); i++) {
            JSONObject match = matches.getJSONObject(i);
            int offset = match.getInt("offset");
            int length = match.getInt("length");
            JSONArray repArray = match.optJSONArray("replacements");

            if (repArray != null && repArray.length() > 0) {
                String replacement = repArray.getJSONObject(0).optString("value", "");
                positions.add(new int[]{offset, length});
                replacements.add(replacement);
            }
        }

        // Sort by offset descending so we can safely replace without shifting earlier indices
        for (int i = 0; i < positions.size() - 1; i++) {
            for (int j = 0; j < positions.size() - i - 1; j++) {
                if (positions.get(j)[0] < positions.get(j + 1)[0]) {
                    int[] tmpPos = positions.get(j);
                    positions.set(j, positions.get(j + 1));
                    positions.set(j + 1, tmpPos);

                    String tmpRep = replacements.get(j);
                    replacements.set(j, replacements.get(j + 1));
                    replacements.set(j + 1, tmpRep);
                }
            }
        }

        StringBuilder corrected = new StringBuilder(originalText);
        for (int i = 0; i < positions.size(); i++) {
            int offset = positions.get(i)[0];
            int length = positions.get(i)[1];
            String replacement = replacements.get(i);
            corrected.replace(offset, offset + length, replacement);
        }

        return corrected.toString();
    }

    private void writeJson(HttpServletResponse response, JSONObject json, int status) throws IOException {
        response.setStatus(status);
        try (PrintWriter out = response.getWriter()) {
            out.print(json.toString());
        }
    }
}
