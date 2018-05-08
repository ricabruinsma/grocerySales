<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Error 403" />
<c:set var="isLoggedIn" value="false" />

<%@include file="content/index_head.jsp"%>

<body>
<div class="row">
    <div class="tm-intro">

        <section id="tm-section-1">
            <div class="tm-container text-xs-center tm-section-1-inner">
                <img src="img/groceryCart_grey.png" alt="Logo" class="tm-logo">
                <h1 class="tm-site-name">Error 503</h1>
                <p class="tm-intro-text">Service Currently Unavailable</p>
                <a href="index.jsp" class="tm-intro-link">Home</a>
            </div>
        </section>

    </div>
</div>
</body>

<%@include file="templates/footer.jsp"%>

</html>
