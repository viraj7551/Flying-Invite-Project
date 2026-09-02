<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta property="og:title" content="FlyingInvite | Home Page">
<meta property="og:description" content="India's Interative Invitation">
<meta property="og:url" content="https://flyinginvite.in/">
<meta property="og:type" content="website">
<meta property="og:site_name" content="FlyingInvite">
<meta property="og:image" content="https://red-katalin-50.tiiny.site/">
<meta property="og:image:type" content="image/jpeg">
<meta property="og:image:width" content="1200">
<meta property="og:image:height" content="630">
<link rel="icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href=" ./assets/images/loggo.png" type="image/png">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <!-- Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
<title>FlyingInvite | Hero Invite</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="./assets/css/fontawesome.css">
    <link rel="stylesheet" href="./assets/css/app.css">
    <link rel="stylesheet" href="./assets/css/animated.css">
    <link rel="stylesheet" href="./assets/css/owl.css">
    <link rel="stylesheet" href="./assets/css/style.css">
     <link rel="stylesheet" href="./assets/css/spelling_correct.css">
    <script async src="https://www.googletagmanager.com/gtag/js?id=G-DZ4MP44ET9"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'G-DZ4MP44ET9');
</script>

</head>


<body>

<%
if(session.getAttribute("session_id") == null){
	session.invalidate();
    response.sendRedirect("login.jsp");
} else{

%>

 <!-- ***** Preloader Start ***** -->
  <div id="js-preloader" class="js-preloader">
    <div class="preloader-inner">
      <span class="dot"></span>
      <div class="dots">
        <span></span>
        <span></span>
        <span></span>
      </div>
    </div>
  </div>
  <!-- ***** Preloader End ***** -->

  <!-- Pre-header Starts -->

  <%@ include file="/WEB-INF/jsp/common/preheader.jsp" %>

  <!-- Pre-header End -->

  <!-- ***** Header Area Start ***** -->
  

  <!-- ***** Header Area Start ***** -->
       <%@ include file="/WEB-INF/jsp/common/header02.jsp" %>
  
  <!-- ***** Header Area End ***** -->
  
  

<div class="container py-5">

    <h3 class="mb-4 text-center"> <a href="index.jsp#services"> <i class="bi bi-arrow-left fs-4"></i> </a>AI - CORRECT THE</h4>
    <p class="text-center text-muted mb-4">Credit: LibreTranslate API   &amp;  LanguageTool API</p>

    <!-- Nav tabs -->
    <ul class="nav nav-tabs" id="mainTab" role="tablist">
        <li class="nav-item" role="presentation">
            <button class="nav-link active" id="translate-tab" data-bs-toggle="tab"
                    data-bs-target="#translate-pane" type="button" role="tab">
                Language Translation
            </button>
        </li>
        <li class="nav-item" role="presentation">
            <button class="nav-link" id="correct-tab" data-bs-toggle="tab"
                    data-bs-target="#correct-pane" type="button" role="tab">
                Sentence Correction
            </button>
        </li>
    </ul>

    <div class=" border-danger tab-content border border-top-1 p-4 shadow-sm" id="mainTabContent">

        <!-- ===================== TRANSLATION TAB ===================== -->
        <div class="tab-pane fade show active" id="translate-pane" role="tabpanel">

            <form id="translateForm">
                <div class="row g-3 mb-3">
                    <div class="col-md-6">
                        <label class="form-label" for="sourceLang">Translate from</label>
                        <select class="form-select" id="sourceLang" name="sourceLang">
                            <option value="auto" selected>Auto Detect</option>
                            <option value="en">English</option>
                            <option value="fr">French</option>
                            <option value="es">Spanish</option>
                            <option value="de">German</option>
                            <option value="ar">Arabic</option>
                        </select>
                    </div>
                    <div class="col-md-6">
                        <label class="form-label" for="targetLang">Translate to</label>
                        <select class="form-select" id="targetLang" name="targetLang">
                            <option value="en">English</option>
                            <option value="fr">French</option>
                            <option value="es" selected>Spanish</option>
                            <option value="de">German</option>
                            <option value="ar">Arabic</option>
                        </select>
                    </div>
                </div>

                <div class="mb-3">
                    <label class="form-label" for="sourceText">Text to translate</label>
                    <textarea class="form-control" id="sourceText" name="sourceText" rows="4"
                              placeholder="Type a sentence here..."></textarea>
                </div>

                <button type="submit" class="btn btn-outline-danger">Translate Me</button>
                <span id="translateSpinner" class="spinner-border spinner-border-sm ms-2 d-none" role="status"></span>
            </form>

            <div id="translateError" class="alert alert-danger mt-3 d-none"></div>

            <div class="mt-4 d-none" id="translateResultBlock">
                <label class="form-label fw-bold">Translated Text</label>
                <div class="p-3 bg-light border rounded" id="translatedTextOutput"></div>
            </div>
        </div>

        <!-- ===================== CORRECTION TAB ===================== -->
        <div class="tab-pane fade" id="correct-pane" role="tabpanel">

            <form id="correctForm">
                <div class="mb-3">
                    <label class="form-label" for="inputText">Enter text</label>
                    <textarea class="form-control" id="inputText" name="text" rows="4"
                              placeholder="Type a sentence here to check..."></textarea>
                </div>

                <button type="submit" class="btn btn-outline-danger">Correct Me</button>
                <span id="correctSpinner" class="spinner-border spinner-border-sm ms-2 d-none" role="status"></span>
            </form>

            <div id="correctError" class="alert alert-danger mt-3 d-none"></div>

            <div class="mt-4 d-none" id="correctResultBlock">
                <label class="form-label fw-bold">Corrected Text</label>
                <div class="p-3 bg-light border rounded mb-4" id="correctedTextOutput"></div>

                <label class="form-label fw-bold">Difference (original vs corrected)</label>
                <div class="p-3 bg-light border rounded" id="diffOutput"></div>
                <small class="text-muted d-block mt-2">
                    <span class="diff-removed">Strikethrough red</span> = removed from original,
                    <span class="diff-added">green</span> = added/corrected text.
                </small>
            </div>
        </div>

    </div>
</div>



  <!-- ------------Footer starts here ------------------------------->

    <%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
   
 <!-- ------------Footer ends here-------------------------------->  
   

  <!-- Scripts -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
  <script src="./vendor/jquery/jquery.min.js"></script>
  <script src="./vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="./assets/js/owl-carousel.js"></script>
  <script src="./assets/js/animation.js"></script>
  <script src="./assets/js/imagesloaded.js"></script>
  <script src="./assets/js/custom.js"></script>
  <script src="./assets/js/app.js"></script>
  <script src="./assets/js/script.js"></script>
  <script src="./assets/js/dropdown.js"></script>
  <script src="./assets/js/greeting_drop_down.js"></script>
  <script src="./assets/js/invite_drop_down.js"></script>

<%}%>


<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="./assets/js/spelling_correct.js"></script>
</body>
</html>