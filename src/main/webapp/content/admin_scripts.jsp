<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="js/jquery-1.11.3.min.js"></script>             <!-- jQuery (https://jquery.com/download/) -->
<script src="https://www.atlasestateagents.co.uk/javascript/tether.min.js"></script> <!-- Tether for Bootstrap, http://stackoverflow.com/questions/34567939/how-to-fix-the-error-error-bootstrap-tooltips-require-tether-http-github-h -->
<script src="js/bootstrap.min.js"></script>                 <!-- Bootstrap (http://v4-alpha.getbootstrap.com/) -->
<script src="js/jquery.singlePageNav.min.js"></script>      <!-- Single Page Nav (https://github.com/ChrisWojcik/single-page-nav) -->
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>  <!-- datatables -->

<!-- Templatemo scripts -->
<script>

    $(document).ready(function(){

        $("#userSearchResults").on(click, $(".editUser"), function() {
            $("#usersSearchHiddenToggle").css("display", "none");
            $("#usersEditHiddenToggle").css("display", "inline");
        });

        $(".showUsersSearch").on(click, function() {
            $("#usersSearchHiddenToggle").css("display", "inline");
            $("#usersEditHiddenToggle").css("display", "none");
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

        /* data table plugin */
        $('#itemSearchResults').DataTable();
        $('#userSearchResults').DataTable();
        $('#storeSearchResults').DataTable();
        $('.dealSearchResults').DataTable();


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