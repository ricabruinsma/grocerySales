<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <h1 id="usersSection" class="text-xs-center blue-text tm-page-2-title">Users</h1>
</div>
<div class="row">
    <div class="col-lg-3"></div>
    <div class="col-lg-8">
        <a href="/grocerySales/searchUsers?searchBy=all" class="btn btn-default tm-normal-btn tm-blue-btn">View All</a>
        <a href="index.jsp#signUpSection" class="btn btn-default tm-normal-btn tm-blue-btn">Add New</a>
        <a href="#searchUsersForm" class="btn btn-default tm-normal-btn tm-blue-btn">Edit/Delete</a>
    </div>
</div>
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
                        <form action="/grocerySales/searchUsers" method="GET" class="tm-contact-form"  id="searchUsersForm">
                            <div class="row">
                                <h4>Options:</h4>

                                <select class="form-control" name="searchBy" required>
                                    <option value="">search by</option>
                                    <option value="id">user ID</option>
                                    <option value="username">username</option>
                                    <option value="role">user role</option>
                                </select>

                                <br />
                                <h4>Enter Search Term:</h4>
                                <input type="text" id="userSearchTerm" name="searchTerm" class="form-control" required/> <br />

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