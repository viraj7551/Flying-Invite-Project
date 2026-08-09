package com.app;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Simple servlet that forwards a translation request to the LibreTranslate API.
 *
 * LibreTranslate is open source and can be self-hosted (recommended for learning,
 * since the public instance may rate-limit or require an API key):
 *   https://github.com/LibreTranslate/LibreTranslate
 *
 * If you self-host (e.g. via Docker: `docker run -p 5000:5000 libretranslate/libretranslate`),
 * change LIBRETRANSLATE_URL below to "http://localhost:5000/translate".
 */
@WebServlet("/TranslateServlet")
public class TranslateServlet extends HttpServlet {

	// Change this if you want to switch providers later.
	private static final String MYMEMORY_URL = "https://api.mymemory.translated.net/get";

	private final HttpClient httpClient = HttpClient.newBuilder()
	        .connectTimeout(Duration.ofSeconds(10))
	        .build();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");

	    String sourceText = request.getParameter("sourceText");
	    String sourceLang = request.getParameter("sourceLang"); // e.g. "en"
	    String targetLang = request.getParameter("targetLang"); // e.g. "fr"

	    JSONObject result = new JSONObject();

	    if (sourceText == null || sourceText.trim().isEmpty()) {
	        result.put("error", "Please enter some text to translate.");
	        writeJson(response, result, HttpServletResponse.SC_BAD_REQUEST);
	        return;
	    }
	    if (targetLang == null || targetLang.trim().isEmpty()) {
	        result.put("error", "Please specify a target language.");
	        writeJson(response, result, HttpServletResponse.SC_BAD_REQUEST);
	        return;
	    }

	    // MyMemory doesn't support "auto" — default to "en" if not specified/auto
	    String resolvedSource = (sourceLang == null || sourceLang.isEmpty() || sourceLang.equalsIgnoreCase("auto"))
	            ? "en" : sourceLang;

	    try {
	        String langPair = resolvedSource + "|" + targetLang;
	        String encodedText = URLEncoder.encode(sourceText, StandardCharsets.UTF_8);
	        String encodedLangPair = URLEncoder.encode(langPair, StandardCharsets.UTF_8);

	        String url = MYMEMORY_URL + "?q=" + encodedText + "&langpair=" + encodedLangPair;

	        HttpRequest apiRequest = HttpRequest.newBuilder()
	                .uri(URI.create(url))
	                .timeout(Duration.ofSeconds(15))
	                .GET()
	                .build();

	        HttpResponse<String> apiResponse = httpClient.send(apiRequest, HttpResponse.BodyHandlers.ofString());

	        if (apiResponse.statusCode() == 200) {
	            JSONObject apiJson = new JSONObject(apiResponse.body());
	            String translatedText = apiJson
	                    .getJSONObject("responseData")
	                    .optString("translatedText", "");
	            result.put("translatedText", translatedText);
	            writeJson(response, result, HttpServletResponse.SC_OK);
	        } else {
	            result.put("error", "Translation API returned status " + apiResponse.statusCode()
	                    + ": " + apiResponse.body());
	            writeJson(response, result, HttpServletResponse.SC_BAD_GATEWAY);
	        }
	    } catch (Exception e) {
	        result.put("error", "Failed to reach translation service: " + e.getMessage());
	        writeJson(response, result, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    }
	}

	private void writeJson(HttpServletResponse response, JSONObject json, int status) throws IOException {
	    response.setStatus(status);
	    try (PrintWriter out = response.getWriter()) {
	        out.print(json.toString());
	    }
	}
}
