<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">

    <div class="tm-navbar-container">

        <!-- navbar   -->
        <nav class="navbar navbar-full navbar-fixed-top">

            <button class="navbar-toggler hidden-md-up" type="button" data-toggle="collapse" data-target="#tmNavbar">
                &#9776;
            </button>

            <div class="collapse navbar-toggleable-sm" id="tmNavbar">

                <c:if test="${isLoggedIn == true}">
                    <%@include file="shopper_navbar_items.jsp"%>
                </c:if>

                <c:if test="${isLoggedIn == false}">
                    <%@include file="index_navbar_items.jsp"%>
                </c:if>

            </div>

        </nav>
    </div>

</div> <!--row -->
