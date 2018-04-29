<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Home" />
<c:set var="isLoggedIn" value="false" />
<%@include file="templates/head.jsp"%>

    <body id="top" class="home">
       
        <div class="container-fluid">

            <%@include file="content/notAdmin_navbar.jsp"%>

            <%@include file="content/index_banner.jsp"%>

            <%@include file="content/index_login.jsp"%>

            <%@include file="content/index_signUp.jsp"%>

            <%@include file="content/index_findGrocerySales.jsp"%>
           
        </div> <!-- container-fluid -->

        <%@include file="content/index_scripts.jsp"%>

</body>
</html>