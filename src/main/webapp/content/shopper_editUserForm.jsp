<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="row"> <a name="userEditResults"></a>
    <div class="tm-section" id="tm-section-5">
        <div class="col-xs-12">
            <c:if test="${searchPage.equals('shopperEdit')}">
                <c:if test="${users.size() > 0}">
                    <c:forEach var="user" items="${users}">
                        <h3 class="blue-text text-xs-center">Change Password: ${user.password}</h3>
                        <form action="editShopperInfo" method="POST" class="tm-contact-form">
                            <div class="row">
                                <input type="hidden" name="id" value="${user.id}" />

                                <div class="col-md-1"></div>

                                <div class="col-md-4">
                                    <h4>New Password:</h4>
                                    <input type="password" id="newPassword" name="newPassword" class="form-control"  required/>

                                </div>
                                <div class="col-md-2"></div>
                                <div class="col-md-4">
                                    <h4>Confirm Password:</h4>
                                    <input type="password" id="newPasswordConfirm" name="newPasswordConfirm" class="form-control" placeholder="retype password"  required/>
                                </div>

                                <div id="divCheckPassword"></div>

                                <br /><br />
                                <input type="hidden" name="searchPage" value="user" />
                                <div style="text-align:center;">
                                    <button type="submit" class="btn tm-light-blue-bordered-btn" style="text-align: center;">Update</button>
                                    <br/><br />
                                    <a href="toShopperPage" class="btn btn-default tm-normal-btn tm-blue-btn">Go Back</a>
                                </div>
                            </div>
                        </form>
                    </c:forEach>
                </c:if>
                <div class="row">
                    <div class="text-xs-center">

                    </div>
                </div>

            </c:if>
        </div>
    </div> <!-- tm-section -->
</div>