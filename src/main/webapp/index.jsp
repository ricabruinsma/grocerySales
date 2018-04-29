<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Home" />
<c:set var="isLoggedIn" value="false" />


<!DOCTYPE html>
<html lang="en">

<%@include file="templates/head.jsp"%>

<body id="top" class="home">

    <div class="container-fluid">

        <%@include file="content/notAdmin_navbar.jsp"%>

        <c:import url="content/index_banner.jsp" />

        <c:import url="content/index_login.jsp" />

        <c:import url="content/index_signUp.jsp" />

        <c:import url="content/index_findGrocerySales.jsp" />

        <c:import url="templates/footer.jsp" />

    </div> <!-- container-fluid -->

    <c:import url="content/index_scripts.jsp" />

</body>
</html>