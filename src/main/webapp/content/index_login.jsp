<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row gray-bg">

    <div id="tm-section-2" class="tm-section">
        <div class="tm-container tm-container-wide">
            <div class="tm-news-item">

                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-news-item-img-container">
                    <img src="img/login.jpg" alt="Login" class="img-fluid tm-news-item-img">
                </div>

                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-news-container">
                    <h1 class="text-xs-center blue-text tm-page-2-title">Login</h1>

                    <div>
                        <form action="j_security_check" method="POST" class="tm-contact-form">
                            <div class="form-group">
                                <input type="TEXT" id="userName" name="j_username" class="form-control" placeholder="username"  required/>
                            </div>

                            <div class="form-group">
                                <input type="PASSWORD" id="password" name="j_password" class="form-control" placeholder="password"  required/>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 col-xl-8">
                                <button type="submit" class="btn tm-light-blue-bordered-btn pull-xs-right">Login</button>

                            </div>
                        </form>
                    </div> <!-- col -->
                </div>
            </div>
        </div>
    </div> <!-- end section 2 -->

</div> <!-- row -->