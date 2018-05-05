<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <h1 id="itemsSection" class="text-xs-center blue-text tm-page-2-title">Items</h1>
</div>

<div class="row">
    <div class="col-lg-3"></div>
    <div class="col-lg-8">
        <a href="searchItems?searchBy=all" class="btn btn-default tm-normal-btn tm-blue-btn">View All</a>
        <a href="addItem" class="btn btn-default tm-normal-btn tm-blue-btn">Add New</a>
        <a href="#searchItemsForm" class="btn btn-default tm-normal-btn tm-blue-btn">Edit/Delete</a>
    </div>
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
                        <form action="/grocerySales/searchItems" method="GET" class="tm-contact-form"  id="searchItemsForm">
                            <div class="row">
                                <h4>Options:</h4>

                                <select class="form-control" name="searchBy" required>
                                    <option value="">search by</option>
                                    <option value="brand">item brand</option>
                                    <option value="product">item name</option>
                                    <option value="category">category</option>
                                    <option value="store">store name</option>
                                </select>

                                <br />
                                <h4>Enter Search Term:</h4>
                                <input type="text" id="searchItemsTerm" name="searchTerm" class="form-control" required/>
                                <br />

                                <button type="submit" class="btn tm-light-blue-bordered-btn">Submit</button>
                            </div>
                        </form>
                    </div> <!-- col -->
                </div>
            </div>
        </div>
    </section>
</div>