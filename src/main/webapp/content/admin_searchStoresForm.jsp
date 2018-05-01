<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <section id="tm-section-3" class="tm-section">
        <div class="tm-container text-xs-center">
            <div class="tm-news-item">

                <div class="col-lg-6 tm-news-container">
                    <h1 class="text-xs-center blue-text tm-page-2-title">Search for Stores</h1>

                    <div>
                        <form action="/grocerySales/searchStores" method="GET" class="tm-contact-form"  id="searchStoresForm">
                            <div class="row">
                                <h4>Options:</h4>

                                <select class="form-control" name="searchBy" required>
                                    <option value="">search by</option>
                                    <option value="name">store name</option>
                                    <option value="address1">store address</option>
                                    <option value="city">store city</option>
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