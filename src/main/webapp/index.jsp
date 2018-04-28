<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Home" />
<c:set var="isLoggedIn" value="false" />
<%@include file="templates/head.jsp"%>

    <body id="top" class="home">
       
        <div class="container-fluid">

            <%@include file="templates/notLoggedIn_navbar.jsp"%>

           <div class="row">
                <div class="tm-intro">

                    <section id="tm-section-1">                        
                        <div class="tm-container text-xs-center tm-section-1-inner">
                            <img src="img/groceryCart_grey.png" alt="Logo" class="tm-logo">
                            <h1 class="tm-site-name">grocerySales</h1>
                            <p class="tm-intro-text">Find Local Deals</p>
                            <a href="#tm-section-2" class="tm-intro-link">Begin</a>    
                        </div>                                               
                   </section>

                </div>
            </div>

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
									<form action="loginServlet.java" method="get" class="tm-contact-form">                                
										<div class="form-group">
											<input type="text" id="userName" name="userName" class="form-control" placeholder="username"  required/>
										</div>
										
										<div class="form-group">
											<input type="password" id="password" name="password" class="form-control" placeholder="password"  required/>
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

            <div class="row gray-bg">

                <section id="tm-section-3" class="tm-section">
                    <div class="tm-container text-xs-center">

						<h2 class="blue-text tm-title" id="signUpSection">Sign-Up</h2>
						<p class="margin-b-5">Your information will not be shared with anyone, period.</p>
						<br />
							

						<div class="col-md-1 margin-bottom-sm-2"></div>	
						
						<div class="col-md-10">
                            <form action="newUserSignUpServlet.java" method="post" class="tm-contact-form"  id="signUpForm">     
                                
                                <div class="tm-3-col-box col-lg-6">                          
                                    <div class="row">
                                        <div class="form-group">
                                            <input type="email" id="email" name="email" class="form-control" placeholder="email"  required/>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="form-group">
                                            <input type="text" id="newUserName" name="newUserName" class="form-control" placeholder="username"  required/>
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
					


                </section>

            </div> <!-- row -->

            <div class="row gray-bg">

                <section id="tm-section-4" class="tm-section">
                    <div class="tm-container">

                        <h2 class="blue-text tm-title text-xs-center">Find Local Grocery Sales</h2>
                      
                        <div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 col-xl-8">
                            <form action="index.jsp" method="post" class="tm-contact-form">
                                <div class="form-group col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 tm-form-group-left">
                                    <input type="text" id="contact_name" name="contact_name" class="form-control" placeholder="Name"  required/>
                                </div>
                                <div class="form-group col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 tm-form-group-right">
                                    <input type="email" id="contact_email" name="contact_email" class="form-control" placeholder="Email"  required/>
                                </div>
                                <div class="form-group">
                                    <input type="text" id="contact_subject" name="contact_subject" class="form-control" placeholder="Subject"  required/>
                                </div>
                                <div class="form-group">
                                    <textarea id="contact_message" name="contact_message" class="form-control" rows="6" placeholder="Message" required></textarea>
                                </div>
                            
                                <button type="submit" class="btn tm-light-blue-bordered-btn pull-xs-right">Submit</button>                          
                            </form>   
                        </div> <!-- col -->
                        
                        <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 col-xl-4 margin-top-xs-50">
                            <h3 class="light-blue-text tm-subtitle">Etiam at rhoncus nisl</h3>
                            <p>Nunc rutrum ac ante euismod cursus. Suspendisse imperdiet feugiat massa nec iaculis</p>
                            <p>
                                Tel: <a href="tel:0100200340">010-020-0340</a><br>
                                Email: <a href="mailto:info@company.com">info@company.com</a>
                            </p>
                        </div>
                    </div>                    
                </section>

                <!-- footer -->
                <footer class="tm-footer">                
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                        <p class="text-xs-center tm-footer-text">Copyright &copy; 2018 grocerySales</p>                    
                    </div>                
                </footer>  

            </div> <!-- row -->
           
        </div> <!-- container-fluid -->
        
        <!-- load JS files -->
        
        <script src="js/jquery-1.11.3.min.js"></script>             <!-- jQuery (https://jquery.com/download/) -->
        <script src="https://www.atlasestateagents.co.uk/javascript/tether.min.js"></script> <!-- Tether for Bootstrap, http://stackoverflow.com/questions/34567939/how-to-fix-the-error-error-bootstrap-tooltips-require-tether-http-github-h --> 
        <script src="js/bootstrap.min.js"></script>                 <!-- Bootstrap (http://v4-alpha.getbootstrap.com/) -->
        <script src="js/jquery.singlePageNav.min.js"></script>      <!-- Single Page Nav (https://github.com/ChrisWojcik/single-page-nav) -->
        <script src="js/jquery.magnific-popup.min.js"></script>     <!-- Magnific pop-up (http://dimsemenov.com/plugins/magnific-popup/) -->
		<script src="js/index.js"></script>							<!-- grocerySales specific js -->
		<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>  <!-- datatables -->
        
        <!-- Templatemo scripts -->
        <script>     
       
            $(document).ready(function(){
			
				$("#newPasswordConfirm").on("focusout", function() {
					isPasswordMatch();
				});

                var mobileTopOffset = 54;
                var desktopTopOffset = 80;
                var topOffset = desktopTopOffset;

                if($(window).width() <= 767) {
                    topOffset = mobileTopOffset;
                }
                
                /* Single page nav
                -----------------------------------------*/
                $('#tmNavbar').singlePageNav({
                   'currentClass' : "active",
                    offset : topOffset,
                    'filter': ':not(.external)'
                }); 

                /* Handle nav offset upon window resize
                -----------------------------------------*/
                $(window).resize(function(){
                    if($(window).width() <= 767) {
                        topOffset = mobileTopOffset;
                    } 
                    else {
                        topOffset = desktopTopOffset;
                    }

                    $('#tmNavbar').singlePageNav({
                        'currentClass' : "active",
                        offset : topOffset,
                        'filter': ':not(.external)'
                    });
                });
                

                /* Collapse menu after click 
                -----------------------------------------*/
                $('#tmNavbar a').click(function(){
                    $('#tmNavbar').collapse('hide');
                });

                /* Turn navbar background to solid color starting at section 2
                ---------------------------------------------------------------*/
                var target = $("#tm-section-2").offset().top - topOffset;

                if($(window).scrollTop() >= target) {
                    $(".tm-navbar-container").addClass("bg-inverse");
                }
                else {
                    $(".tm-navbar-container").removeClass("bg-inverse");
                }

                $(window).scroll(function(){
                   
                    if($(this).scrollTop() >= target) {
                        $(".tm-navbar-container").addClass("bg-inverse");
                    }
                    else {
                        $(".tm-navbar-container").removeClass("bg-inverse");
                    }
                });


                /* Smooth Scrolling
                 * https://css-tricks.com/snippets/jquery/smooth-scrolling/
                --------------------------------------------------------------*/
                $('a[href*="#"]:not([href="#"])').click(function() {
                    if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') 
                        && location.hostname == this.hostname) {
                        
                        var target = $(this.hash);
                        target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
                        
                        if (target.length) {
                            
                            $('html, body').animate({
                                scrollTop: target.offset().top - topOffset
                            }, 1000);
                            return false;
                        }
                    }
                }); 

              
                /* Magnific pop up
                ------------------------- */
                $('.tm-img-grid').magnificPopup({
                    delegate: 'a', // child items selector, by clicking on it popup will open
                    type: 'image',
                    gallery: {enabled:true}            
                });            
            });

        </script>             

</body>
</html>