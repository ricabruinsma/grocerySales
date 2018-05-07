<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row"> <a name="searchUsersResults"></a>
    <div class="tm-section" id="tm-section-5">
        <div class="col-xs-12">
            <c:if test="${searchPage.equals('user')}">
                <h3 class="blue-text">Search Results:</h3>
                <c:if test="${users.isEmpty()}">
                    <h3 class="userResultAlert" style="color: red;">No Results were found for your search.</h3>
                </c:if>
                <c:if test="${deleteMessage.equals('success')}">
                    <h3 class="blue-text">User Successfully deleted.</h3>
                </c:if>
                <c:if test="${users.size() > 0}">
                    <table class="table table-striped tm-full-width-large-table userResultAlert" id="userSearchResults">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>roles</th>
                            <th>user name</th>
                            <th>password</th>
                            <th>email</th>
                            <th>address</th>
                            <th>city</th>
                            <th>state</th>
                            <th>postal code</th>
                            <th>Admin Functions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="user" items="${users}">
                            <tr>
                                <td>${user.id}</td>
                                <td><c:forEach var="role" items="${user.roles}">
                                    ${role.name} <br/>
                                </c:forEach></td>
                                <td>${user.username}</td>
                                <td>${user.password}</td>
                                <td>${user.email}</td>
                                <td>${user.address1}</td>
                                <td>${user.city}</td>
                                <td>${user.state}</td>
                                <td>${user.postalCode}</td>
                                <td><form action="deleteUser" method="POST">
                                        <input type="hidden" name="id" value="${user.id}" />
                                        <input type="hidden" name="searchBy" value="${searchBy}" />
                                        <input type="hidden" name="searchTerm" value="${searchTerm}" />
                                        <button class="deleteUser" type="submit"><img style="max-width: 2em;" src="img/trashCan.png" alt="delete"></button>
                                    </form>
                                    <a href="searchUsers?searchBy=id&searchTerm=${user.id}&searchPage=userEdit"><img style="max-width: 2em;" src="img/edit.png" alt="edit"></a>

                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </c:if>
        </div>
    </div> <!-- tm-section -->
</div>