<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row gray-bg">
    <div id="tm-section-4">
        <h1 id="usersSection" class="text-xs-center blue-text tm-page-1-title">Find Local Grocery Deals</h1>
    </div>

    <div class="tm-section">
        <div class="tm-container text-xs-center">
            <div class="tm-news-item">

                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-news-item-img-container">
                    <img src="img/findDeals.jpg" alt="groceryItems" class="img-fluid tm-news-item-img">
                </div>

                <div class="col-lg-6 tm-news-container" id="dealsSearchHiddenToggle">  <!-- form section RHS of image -->
                    <div>
                        <form action="/grocerySales/getDeals" method="GET" class="tm-contact-form"  id="getDealsForm">
                            <div class="row">

                                <h4 style="text-align:center">Pick a store:</h4>
                                <select class="form-control" name="storeName" id="storeName" required>
                                    <option value="">choose</option>
                                </select><br />

                                <h4>Pick a category:</h4>
                                <select class="form-control" name="categoryName" id="categoryName" required>
                                    <option value="">choose</option>
                                </select><br />

                                <h4>Type of search:</h4>
                                <select class="form-control" name="searchType" id="searchType" required>
                                    <option value="getAll">get all</option>
                                    <option value="keywordSearch">search by keyword</option>
                                </select><br />
                                <div id="groceryKeywordSearch" style="display:none">
                                    <h4>Enter Search Term:</h4>
                                    <input type="text" id="keyword" name="keyword" class="form-control" /> <br />
                                </div>
                                    <c:if test="${pageTitle.equals('Shopper')}">
                                        <input type="hidden" name="routeDealsTo" value="Shopper" />
                                    </c:if>
                                <c:if test="${pageTitle.equals('Home')}">
                                    <input type="hidden" name="routeDealsTo" value="Home" />
                                </c:if>
                                <button type="submit" class="btn tm-light-blue-bordered-btn">Submit</button>
                            </div>
                        </form>
                    </div> <!-- col -->
                </div>
            </div>
        </div>
    </div> <!-- end section 2 -->

</div> <!-- row -->