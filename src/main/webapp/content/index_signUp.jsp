<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row gray-bg">

    <section id="tm-section-3" class="tm-section">
        <div class="tm-container text-xs-center">

            <h2 class="blue-text tm-title" id="signUpSection">Sign-Up</h2>
            <p class="margin-b-5">Your information will not be shared with anyone, period.</p>
            <br />


            <div class="col-md-1 margin-bottom-sm-2"></div>

            <div class="col-md-10">
                <form action="/grocerySales/userSignUp" method="POST" class="tm-contact-form"  id="signUpForm">

                    <div class="tm-3-col-box col-lg-6">
                        <div class="row">
                            <div class="form-group">
                                <input type="email" id="email" name="email" class="form-control" placeholder="email"  required/>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group">
                                <input type="text" id="userName" name="newUserName" class="form-control" placeholder="username"  required/>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group">
                                <input type="password" id="newPassword" name="newPassword" class="form-control" placeholder="password"  required/>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group">
                                <input type="password" id="newPasswordConfirm" name="newPasswordConfirm" class="form-control" placeholder="retype password"  required/>
                            </div>
                        </div>

                        <div id="divCheckPassword"></div>
                    </div>

                    <div class="tm-3-col-box col-lg-1"></div>

                    <div class="tm-3-col-box col-lg-6">
                        <div class="row">
                            <div class="form-group">
                                <input type="text" id="userAddress" name="userAddress" class="form-control" placeholder="address"  required/>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group">
                                <input type="text" id="userCity" name="userCity" class="form-control" placeholder="city"  required/>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group">
                                <input type="text" id="userState" name="userState" class="form-control" placeholder="state"  required/>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group">
                                <input type="text" id="userZip" name="userZip" class="form-control" placeholder="postal code"  required/>
                            </div>
                        </div>
                    </div>

                    <button type="submit" class="btn tm-light-blue-bordered-btn">Submit</button>
                </form>

            </div> <!-- col -->

            <div class="col-md-1 margin-bottom-sm-3"></div>
        </div>
        <a name="signup"></a>
        <c:if test="${success}">
            <h3 style="color: green;">Successful sign-up of new user.</h3>
        </c:if>

    </section>

</div> <!-- row -->