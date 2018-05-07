<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row"> <a name="userEditResults"></a>
    <div class="tm-section" id="tm-section-5">
        <div class="col-xs-12">
            <c:if test="${searchPage.equals('userEdit')}">
                <c:if test="${users.size() > 0}">
                    <c:forEach var="user" items="${users}">
                        <h3 class="blue-text text-xs-center">Edit User with ID: ${user.id}</h3>
                        <form action="editUsers" method="POST" class="tm-contact-form">
                            <div class="row">
                                <input type="hidden" name="id" value="${user.id}" />

                                <div class="col-md-1"></div>

                                <div class="col-md-4">
                                    <h4>Role:</h4>
                                    <c:forEach var="role" items="${user.roles}">
                                        <input type="text" name="role" class="form-control col-md-4" value="${role.name}" />
                                    </c:forEach>
                                </div>
                                <div class="col-md-2"></div>
                                <div class="col-md-4">
                                    <h4>Password:</h4>
                                    <input type="text" name="password" class="form-control col-md-4" value="${user.password}" /> <br/>
                                </div>

                                <br /><br />
                                <input type="hidden" name="searchPage" value="user" />
                                <div style="text-align:center;">
                                    <button type="submit" class="btn tm-light-blue-bordered-btn" style="text-align: center;">Update</button>
                                </div>
                            </div>
                        </form>
                    </c:forEach>
                </c:if>
            </c:if>
        </div>
    </div> <!-- tm-section -->
</div>
