<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Shopper" />
<c:set var="isLoggedIn" value="true" />
<%@include file="templates/head.jsp"%>

    <body id="top" class="page-2">

    <%@include file="content/notAdmin_navbar.jsp"%>
    
        <div class="container-fluid">

            <div class="row">
              <div id="tm-section-1" class="tm-section">
                <div class="col-md-12">
                    <h1 class="text-xs-center blue-text tm-page-2-title">Welcome, ${username} !</h1>
                    <!--<p class="text-xs-center tm-page-2-p tm-page-2-subtitle">
                        Etiam at rhoncus nisl. Nunc rutrum ac ante euismod cursus. <br>
                        Suspendisse imperdiet feugiat massa nec iaculis.
                    </p>-->
                    <img src="img/notHomePage.jpg" class="img-fluid tm-banner-img" alt="Image">            
                </div>
              </div>                
            </div>
            
            <div class="row">
                <div class="tm-section" id="tm-section-2">
                    <div class="col-md-12">
                        <p class="text-left tm-description">
                            Lumino theme is a Bootstrap 4.0 mobile compatible layout for your website.
                            Cras dolor neque, mollis et tortor eget, ornare hendrerit lectus. Donec
                            condimentum leo ut elementum consequat. Sed condimentum sagittis neque
                            in iaculis. Duis quis libero nec mauris porta luctus et sit amet turpis.
                            Proin auctor tortor quis ipsum dignissim, quis congue tortor.
                        </p>
                        <p class="text-left tm-description">
                            Aliquam non vestibulum mi, sed volutpat ipsum. Nunc ultricies quam id
                            mi semper, vitae mattis mi iaculis. Nullam tincidunt vehicula turpis at
                            porttitor. Sed bibendum odio non maximus suscipit. Pellentesque consectetur
                            orci id rutrum lacinia.
                        </p>
                        <div class="tm-flex-center">
                          <a href="#" class="btn btn-default btn-lg tm-gray-btn">Large</a>
                          <a href="#" class="btn btn-default btn-lg tm-gray-bordered-btn">Large</a>
                        </div>
                    </div>
                </div>
            </div>
      
            <div class="row">
                <div class="tm-section" id="tm-section-3">
                    
                    <div class="col-md-6 margin-bottom-sm-8">  
                        <div class="tm-2-col-box-left">
                            <img src="img/tm-700x350-01.jpg" alt="Image" class="img-fluid tm-img-2-col">
                        
                            <p class="text-left tm-description">
                                Proin auctor tortor quis ipsum dignissim, quis congue tortor scelerisque.
                                Etiam malesuada efficitur elit, ut pellentesque mi pellentesque ut.
                            </p>
                            <p class="text-left tm-description">
                                Nullam tincidunt vehicula turpis at porttitor. Sed bibendum odio non maximus
                                suscipit. Pellentesque consectetur orci id rutrum lacinia.
                            </p>   
                        </div> 
                    </div>  

                    <div class="col-md-6">
                        <div>
                            <img src="img/tm-700x350-02.jpg" alt="Image" class="img-fluid tm-img-2-col">
                   
                            <table class="table table-striped">
                                <tbody>
                                    <tr>
                                        <td>Aliquam in nibh elementum</td>
                                        <td>$100</td>
                                    </tr>
                                    <tr>
                                        <td>Donec porta augue vitae egestas</td>
                                        <td>$200</td>
                                    </tr>
                                    <tr>
                                        <td>Nunc lacinia vehicula ipsum</td>
                                        <td>$300</td>
                                    </tr>
                                    <tr>
                                        <td>Porttitor rhoncus vel vitae libero</td>
                                        <td>$400</td>
                                    </tr>
                                    <tr>
                                        <td>Nulla neque ligula, bibendum vitae</td>
                                        <td>$500</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>                
            </div>
      
            <div class="row">
                <div class="tm-section" id="tm-section-4">
                    <div class="col-md-4 margin-bottom-sm-3">
                        <div class="tm-3-col-box">
                            <img src="img/tm-500x250-01.jpg" alt="Image" class="img-fluid">
                        
                            <div class="tm-description-box">
                                <p class="tm-description-text">
                                    Proin auctor tortor quis ipsum dignissim, quis congue tortor scelerisque.
                                    Etiam malesuada efficitur elit, ut pellentesque mi pellentesque ut.
                                </p>
                                
                                <div class="tm-flex-center">
                                    <a href="#" class="btn btn-default tm-normal-btn tm-blue-btn">Read</a>
                                    <a href="#" class="btn btn-default tm-normal-btn tm-blue-bordered-btn">Read</a>    
                                </div>
                                    
                            </div>
                        </div>
                    </div>
                
                    <div class="col-md-4 margin-bottom-sm-3">

                        <div class="tm-3-col-box">
                            <img src="img/tm-500x250-02.jpg" alt="Image" class="img-fluid">
                        
                            <div class="tm-description-box">
                                <p class="tm-description-text">
                                    Proin auctor tortor quis ipsum dignissim, quis congue tortor scelerisque.
                                    Etiam malesuada efficitur elit, ut pellentesque mi pellentesque ut.
                                </p>
                                
                                <div class="tm-flex-center">
                                    <a href="#" class="btn btn-default tm-normal-btn tm-gray-btn">Read</a>
                                    <a href="#" class="btn btn-default tm-normal-btn tm-gray-bordered-btn">Read</a>    
                                </div>
                                    
                            </div>
                        </div>                                                
                    </div>
                
                    <div class="col-md-4">
                        <div class="tm-3-col-box">
                            <img src="img/tm-500x250-03.jpg" alt="Image" class="img-fluid">
                        
                            <div class="tm-description-box">
                                <p class="tm-description-text">
                                    Proin auctor tortor quis ipsum dignissim, quis congue tortor scelerisque.
                                    Etiam malesuada efficitur elit, ut pellentesque mi pellentesque ut.
                                </p>
                                
                                <div class="tm-flex-center">
                                    <a href="#" class="btn btn-default tm-normal-btn tm-green-btn">Read</a>
                                    <a href="#" class="btn btn-default tm-normal-btn tm-green-bordered-btn">Read</a>    
                                </div>
                                    
                            </div>
                        </div>                        
                        
                    </div>
                </div>        
            </div>
        
            <div class="row">
                <div class="tm-section" id="tm-section-5">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                        <h3 class="blue-text">Full-width large table</h3>
              
                        <table class="table table-striped tm-full-width-large-table" id="datatable">
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
								<tr>
                                    <td>Row 8</td>
                                    <td>Nulla neque ligula, bibendum vitae</td>
                                    <td>Third</td>
                                    <td>$4,000</td>
                                </tr>
								<tr>
                                    <td>Row 9</td>
                                    <td>Nulla neque ligula, bibendum vitae</td>
                                    <td>Third</td>
                                    <td>$4,000</td>
                                </tr>
								<tr>
                                    <td>Row 10</td>
                                    <td>Nulla neque ligula, bibendum vitae</td>
                                    <td>Third</td>
                                    <td>$4,000</td>
                                </tr>
								<tr>
                                    <td>Row 11</td>
                                    <td>Nulla neque ligula, bibendum vitae</td>
                                    <td>Third</td>
                                    <td>$4,000</td>
                                </tr>
								<tr>
                                    <td>Row 12</td>
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
				$('#datatable').DataTable();
				
				
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