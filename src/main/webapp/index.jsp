<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="GrocerySales - Home" />

<!DOCTYPE html>
<html lang="en">

<%@include file="content/index_head.jsp"%>

<body id="top" class="home" onload="location.href='#${anchorName}'">
    <div class="container-fluid">

        <%@include file="content/index_navbar.jsp"%>

        <%@include file="content/index_banner.jsp"%>

        <%@include file="content/index_login.jsp"%>

        <%@include file="content/index_loginSuccess.jsp"%>

        <%@include file="content/index_signUp.jsp"%>

        <%@include file="content/index_findGrocerySales.jsp"%>

        <%@include file="content/index_searchDealsResults.jsp"%>

        <%@include file="templates/footer.jsp"%>

    </div> <!-- container-fluid -->

    <%@include file="content/index_scripts.jsp"%>

</body>
</html>