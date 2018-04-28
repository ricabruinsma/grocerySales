<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Admin" />
<c:set var="isLoggedIn" value="true" />

<%@include file="templates/head.jsp"%>

    <body id="top" class="page-2">

        <%@include file="content/admin_navbar.jsp"%>
    
        <div class="container-fluid">

            <div class="row">
              <div id="tm-section-1" class="tm-section">
                <div class="col-md-12">
                    <h1 class="text-xs-center blue-text tm-page-2-title">Administrator's Area</h1>
                    <!--<p class="text-xs-center tm-page-2-p tm-page-2-subtitle">
                        Etiam at rhoncus nisl. Nunc rutrum ac ante euismod cursus. <br>
                        Suspendisse imperdiet feugiat massa nec iaculis.
                    </p>-->
                    <img src="img/admin.jpg" class="img-fluid tm-banner-img" alt="Administrator" />            
                </div>
              </div>                
            </div>
            
			<div class="row"><br /><br /></div>
			
            <div class="row">
                <section id="tm-section-2" class="tm-section">
                    <div class="tm-container text-xs-center">
                            <div class="tm-news-item">
                            
                                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-news-item-img-container">
                                    <img src="img/searchUsers.png" alt="Users" class="img-fluid tm-news-item-img" id="usersImage"/>  
                                </div>
                                 
								
								 
                                <div class="col-lg-6 tm-news-container">
                                    <h1 class="text-xs-center blue-text tm-page-2-title">Search for Users</h1>
                                        
                                    <div>
										<form action="searchUsersServlet.java" method="post" class="tm-contact-form"  id="searchUsersForm">                                
											<div class="row">
												<h4>Options:</h4> 
			
												<select class="form-control" required>
													<option value="">search by</option>
													<option value="searchUserId">user ID</option>
													<option value="searchUserName">username</option>
													<option value="searchUserEmail">email address</option>
												</select>
			
												<br />
												<h4>Enter Search Term:</h4> 
												<input type="text" id="userSearchTerm" name="userSearchTerm" class="form-control" required/> <br />
			
												<button type="submit" class="btn tm-light-blue-bordered-btn">Submit</button> 
											</div>
										</form>	
                                    </div> <!-- col -->
                                </div>
                            </div>
                        
                        <div class="row"></div>
                            <div class="col-md-3 margin-bottom-sm-3"></div>	
						
						<div class="col-md-6">
                            <!-- put output table here -->
  
                        </div> <!-- col -->
						
						<div class="col-md-3 margin-bottom-sm-3"></div>
                        
                    </div>
                </section>
            </div>
			
			<div class="row">
                <section id="tm-section-3" class="tm-section">
                    <div class="tm-container text-xs-center">
                            <div class="tm-news-item">
                             
                                <div class="col-lg-6 tm-news-container">
                                    <h1 class="text-xs-center blue-text tm-page-2-title">Search for Stores</h1>
                                        
                                    <div>
										<form action="searchStoresServlet.java" method="post" class="tm-contact-form"  id="searchStoresForm">                                
											<div class="row">
												<h4>Options:</h4> 
			
												<select class="form-control" required>
													<option value="">search by</option>
													<option value="searchStoreName">store name</option>
													<option value="searchStoreAddress">store address</option>
													<option value="searchStoreCity">store city</option>
												</select>
												
												
			
												<br />
												<h4>Enter Search Term:</h4> 
												<input type="text" id="searchStoresTerm" name="searchTerm" class="form-control" required/> <br />
			
												<button type="submit" class="btn tm-light-blue-bordered-btn">Submit</button> 
											</div>
										</form>	
                                    </div> <!-- col -->
                                </div>
								
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-news-item-img-container">
                                    <img src="img/searchStore.jpg" alt="Cartoon Store" class="img-fluid tm-news-item-img" id="storeImage"/>  
                                </div>
								
                            </div>
                        
							<div class="row"></div>
								<div class="col-md-3 margin-bottom-sm-3"></div>	
								
								<div class="col-md-6">
									<!-- put table output here -->
								</div> <!-- col -->
							
								<div class="col-md-3 margin-bottom-sm-3"></div>
                        
                    </div>
                </section>
            </div>
      
                        <div class="row">
                <section id="tm-section-4" class="tm-section">
                    <div class="tm-container text-xs-center">
                            <div class="tm-news-item">
                            
                                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-news-item-img-container">
                                    <img src="img/items.jpeg" alt="Items" class="img-fluid tm-news-item-img" id="itemsImage"/>  
                                </div>
                                 
								
								 
                                <div class="col-lg-6 tm-news-container">
                                    <h1 class="text-xs-center blue-text tm-page-2-title">Search for Items</h1>
                                        
                                    <div>
										<form action="searchItemsServlet.java" method="post" class="tm-contact-form"  id="searchItemsForm">                                
											<div class="row">
												<h4>Options:</h4> 
			
												<select class="form-control" required>
													<option value="">search by</option>
													<option value="searchItemBrand">item brand</option>
													<option value="searchItemName">item name</option>
													<option value="searchItemStoreName">store name</option>
												</select>
			
												<br />
												<h4>Enter Search Term:</h4> 
												<input type="text" id="searchItemsTerm" name="userSearchTerm" class="form-control" required/> <br />
			
												<button type="submit" class="btn tm-light-blue-bordered-btn">Submit</button> 
											</div>
										</form>	
                                    </div> <!-- col -->
                                </div>
                            </div>
                        
                        <div class="row"></div>
                            <div class="col-md-3 margin-bottom-sm-3"></div>	
						
						<div class="col-md-6">
                            <!-- put output table here -->
  
                        </div> <!-- col -->
						
						<div class="col-md-3 margin-bottom-sm-3"></div>
                        
                    </div>
                </section>
            </div>
        
            <div class="row">
                <div class="tm-section" id="tm-section-5">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                        <h3 class="blue-text">Full-width large table</h3>
              
                        <table class="table table-striped tm-full-width-large-table" id="exampleTable">
                            <thead>
                                <tr>
                                    <th>Title</th>
                                    <th>Description</th>
                                    <th>Category</th>
                                    <th>Price</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Row 1</td>
                                    <td>In consectetur et dolor eget mollis</td>
                                    <td>First</td>
                                    <td>$1,000</td>
                                </tr>
                                <tr>
                                    <td>Row 2</td>
                                    <td>Donec porta augue vitae egestas eleifend</td>
                                    <td>First</td>
                                    <td>$1,500</td>
                                </tr>
                                <tr>
                                    <td>Row 3</td>
                                    <td>Aliquam in nibh elementum</td>
                                    <td>Second</td>
                                    <td>$2,000</td>
                                </tr>
                                <tr>
                                    <td>Row 4</td>
                                    <td>Donec porta augue vitae egestas</td>
                                    <td>Second</td>
                                    <td>$2,500</td>
                                </tr>
                                <tr>
                                    <td>Row 5</td>
                                    <td>Nunc lacinia vehicula upsum</td>
                                    <td>Second</td>
                                    <td>$3,000</td>
                                </tr>
                                <tr>
                                    <td>Row 6</td>
                                    <td>Porttitor rhoncus vel vitae libero</td>
                                    <td>Third</td>
                                    <td>$3,500</td>
                                </tr>
                                <tr>
                                    <td>Row 7</td>
                                    <td>Nulla neque ligula, bibendum vitae</td>
                                    <td>Third</td>
                                    <td>$4,000</td>
                                </tr>
                            </tbody>        
                        </table>
                    </div>
                </div> <!-- tm-section -->        
            </div>
      
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                    <p class="text-xs-center tm-footer-text">Copyright &copy; 2018 grocerySales</p>
                </div>
            </div>
        </div> <!-- .container -->

        <script src="js/jquery-1.11.3.min.js"></script>             <!-- jQuery (https://jquery.com/download/) -->
        <script src="https://www.atlasestateagents.co.uk/javascript/tether.min.js"></script> <!-- Tether for Bootstrap, http://stackoverflow.com/questions/34567939/how-to-fix-the-error-error-bootstrap-tooltips-require-tether-http-github-h --> 
        <script src="js/bootstrap.min.js"></script>                 <!-- Bootstrap (http://v4-alpha.getbootstrap.com/) -->
        <script src="js/jquery.singlePageNav.min.js"></script>      <!-- Single Page Nav (https://github.com/ChrisWojcik/single-page-nav) -->  
		<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>  <!-- datatables -->

        <!-- Templatemo scripts -->
        <script>     
         
            $(document).ready(function(){

				/* data table plugin */
				$('#exampleTable').DataTable();
				
				
                var mobileTopOffset = 54;
                var tabletTopOffset = 74;
                var desktopTopOffset = 79;
                var topOffset = desktopTopOffset;

                if($(window).width() <= 767) {
                    topOffset = mobileTopOffset;
                }
                else if($(window).width() <= 991) {
                    topOffset = tabletTopOffset;
                }
              
                /* Single page nav
                -----------------------------------------*/
                $('#tmNavbar').singlePageNav({
                    'currentClass' : "active",
                    offset : topOffset,
                    'filter': ':not(.external)'
                }); 

                if($(window).width() < 570) {
                    $('.tm-full-width-large-table').addClass('table-responsive');
                }
                else {
                    $('.tm-full-width-large-table').removeClass('table-responsive');   
                }
              

                /* Collapse menu after click 
                -----------------------------------------*/
                $('#tmNavbar a').click(function(){
                    $('#tmNavbar').collapse('hide');
                });

              
                /* Handle nav offset & table responsive upon window resize
                --------------------------------------------------------------*/
                $(window).resize(function(){
                    
                    if($(window).width() < 768) {
                        topOffset = mobileTopOffset;
                    } 
                    else if($(window).width() <= 991) {
                        topOffset = tabletTopOffset;
                    }
                    else {
                        topOffset = desktopTopOffset;
                    }

                    $('#tmNavbar').singlePageNav({
                        'currentClass' : "active",
                        offset : topOffset,
                        'filter': ':not(.external)'
                    });

                    if($(window).width() < 570) {
                        $('.tm-full-width-large-table').addClass('table-responsive');
                    }
                    else {
                        $('.tm-full-width-large-table').removeClass('table-responsive');   
                    }
                });
                          
            });

        </script>    
    </body>
</html>