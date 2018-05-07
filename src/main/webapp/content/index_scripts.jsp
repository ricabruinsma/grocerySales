<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

        //when login link is clicked, move to login and focus in username input field
        $(".login-link").click(function(){
            $('#userName').focus();
        });

        // loads the category list into the grocery deal search
        loadOptionsForDealSearch("loadingCategories", "#categoryName");

        // loads the category list into the grocery deal search
        loadOptionsForDealSearch("loadingStores", "#storeName");


        // grocery deal search - if select a keyword search, keyword input box displays
        $('#searchType').change(function() {
            if ($(this).val() === "keywordSearch") {
                $("#groceryKeywordSearch").css("display", "inline");
            } else if ($(this).val() === "getAll") {
                $("#groceryKeywordSearch").css("display", "none");
            }
        });

        $("#newPasswordConfirm").on("focusout", function() {
            isPasswordMatch();
        });

        /* data table plugin */
        $('.dealSearchResults').DataTable();


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

    function loadOptionsForDealSearch(actionServlet, selectId) {
        $.get(actionServlet, function(jsonOptions) {
            var $select = $(selectId);
            $select.find("option").remove();
            $.each(jsonOptions, function(key, value) {
                $("<option>").val(key).text(value).appendTo($select);
            });
        });
    }

</script>