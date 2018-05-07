<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="pageTitle" value="Failed Login" />
<c:set var="isLoggedIn" value="false" />

<%@include file="content/index_head.jsp"%>

<body id="top" class="home">
    <div class="container-fluid">

        <c:import url="content/failedLogin_banner.jsp" />

    </div> <!-- container-fluid -->

    <c:import url="content/index_scripts.jsp" />
</body>

<c:import url="templates/footer.jsp" />

</html>


