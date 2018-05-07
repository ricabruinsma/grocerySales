<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Search Results" />
<%@include file="content/index_head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
    } );
</script>

<html>
<body>

<div class="container-fluid">
    <h2>Search Results: </h2>

    <table id="userTable" class="table table-bordered">
        <thead>
            <tr>
                <!--<th>Name</th> -->
                <th>User Name</th>
                <th>Password</th>
                <th>Roles</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>
                        <c:forEach var="role" items="${user.roles}">
                            ${role.name} <br/>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
