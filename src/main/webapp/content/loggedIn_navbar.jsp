<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="tm-navbar-container tm-navbar-container-dark">

    <nav class="navbar navbar-full navbar-fixed-top bg-inverse">
        <button class="navbar-toggler hidden-md-up" type="button" data-toggle="collapse" data-target="#tmNavbar">
            &#9776;
        </button>
        <div class="collapse navbar-toggleable-sm" id="tmNavbar">
            <c:choose>
                <c:when test="${role.equals('shopper')}">
                    <%@include file="shopper_navbar_items.jsp"%>
                </c:when>
                <c:otherwise>
                    <%@include file="admin_navbar_items.jsp"%>
                </c:otherwise>
            </c:choose>

        </div>
    </nav>

</div>
