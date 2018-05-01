<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Admin" />
<c:set var="isLoggedIn" value="true" />

<!DOCTYPE html>
<html lang="en">

<%@include file="templates/head.jsp"%>

<body id="top" class="page-2">

    <%@include file="content/admin_navbar.jsp"%>

    <div class="container-fluid">

        <%@include file="content/admin_banner.jsp"%>

        <%@include file="content/admin_UsersSection.jsp"%>

        <%@include file="content/admin_searchUsersResults.jsp"%>

        <%@include file="content/admin_searchStoresForm.jsp"%>

        <%@include file="content/admin_searchStoresResults.jsp"%>

        <%@include file="content/admin_searchItemsForm.jsp"%>

        <%@include file="content/admin_searchItemsResults.jsp"%>

        <%@include file="templates/footer.jsp"%>

    </div> <!-- .container -->

    <%@include file="content/admin_scripts.jsp"%>

</body>
</html>