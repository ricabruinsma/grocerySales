<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="GrocerySales - Shopper" />
<c:set var="role" value="shopper" />

<!DOCTYPE html>
<html lang="en">

<%@include file="content/admin_head.jsp"%>

<body id="top" class="page-2">

<%@include file="content/loggedIn_navbar.jsp"%>

<div class="container-fluid">

    <%@include file="content/shopper_banner.jsp"%>

    <%@include file="content/index_findGrocerySales.jsp"%>

    <%@include file="content/index_searchDealsResults.jsp"%>
    
    <%@include file="content/shopper_showShoppingListToggle.jsp"%>

    <%@include file="content/shopper_shoppingListDisplay.jsp"%>

    <%@include file="content/shopper_editUserInfoToggle.jsp"%>

    <%@include file="content/shopper_editUserForm.jsp"%>

    <%@include file="templates/footer.jsp"%>

</div> <!-- .container -->

<%@include file="content/admin_scripts.jsp"%>

</body>
</html>