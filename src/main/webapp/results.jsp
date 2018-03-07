<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>


<html>
<body>

<div class="container-fluid">
    <h2>Search Results: </h2>

    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Name</th>
                <th>User Name</th>
                <th>Password</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.firstName}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>