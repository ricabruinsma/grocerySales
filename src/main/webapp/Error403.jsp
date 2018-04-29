<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="pageTitle" value="Error 403" />
<c:set var="isLoggedIn" value="false" />

<%@include file="templates/head.jsp"%>

<body>
<div class="row">
    <div class="tm-intro">

        <section>
            <div class="tm-container text-xs-center tm-section-1-inner">
                <img src="img/groceryCart_grey.png" alt="Logo" class="tm-logo">
                <h1 class="tm-site-name">Error 403</h1>
                <p class="tm-intro-text">Login to view this page</p>
                <a href="index.jsp #tm-section-2" class="tm-intro-link">Login</a>
            </div>
        </section>

    </div>
</div>
</body>

<%@include file="templates/footer.jsp"%>

</html>
