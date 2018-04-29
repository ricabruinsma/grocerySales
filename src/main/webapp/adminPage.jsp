<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Admin" />
<c:set var="isLoggedIn" value="true" />

<%@include file="templates/head.jsp"%>

    <body id="top" class="page-2">

        <%@include file="content/admin_navbar.jsp"%>
    
        <div class="container-fluid">

            <%@include file="content/admin_banner.jsp"%>
			
            <%@include file="content/admin_searchUsersForm.jsp"%>
			
			<%@include file="content/admin_searchStoresForm.jsp"%>
      
            <%@include file="content/admin_searchItemsForm.jsp"%>

            <%@include file="templates/copyright.jsp"%>

        </div> <!-- .container -->

        <%@include file="content/admin_scripts.jsp"%>

    </body>
</html>