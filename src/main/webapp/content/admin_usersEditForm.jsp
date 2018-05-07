<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row"> <a name="userEditResults"></a>
    <div class="tm-section" id="tm-section-5">
        <div class="col-xs-12">
            <c:if test="${searchPage.equals('userEdit')}">
                <c:if test="${users.size() > 0}">
                    <c:forEach var="user" items="${users}">
                        <h3 class="blue-text">Edit User with ID: ${user.id}</h3>
                        <form action="editUsers" method="POST" class="tm-contact-form">
                            <div class="row">
                                <input type="hidden" name="id" value="${user.id}" />

                                <h4>Roles:</h4>
                                <c:forEach var="role" items="${user.roles}">
                                    <input type="text" name="role" value="${role.name}" /> <br/>
                                </c:forEach>

                                <h4>Password:</h4>
                                <input type="text" name="password" value="${user.password}" /> <br/>


                                <br />
                                <input type="hidden" name="searchPage" value="user" />
                                <button type="submit" class="btn tm-light-blue-bordered-btn">Update</button>
                        </form>
                    </c:forEach>
                </c:if>
            </c:if>
        </div>
    </div> <!-- tm-section -->
</div>
