<%@include file="head.jsp"%>
<html>
<body>
<!--
<h2>User Display Exercise - Week 1</h2>
-->

<div class="container">
    <h2>Search for A User</h2>
<!--
    <form class="form-inline" name="searchForm" action="searchUser" method="GET">
        <div class="form-group">
            <label for="lastName">Enter User's Last Name</label>
            <input type="text" class="form-control" id="lastName" placeholder="Enter last name" name="lastName">
        </div>

        <input class="form-control" type="submit" name="" value="Search" />
    </form>
-->
    <form action="searchUser" class="form-inline" method="GET">
        <div class="form-group">
            <label for="searchTerm">Search</label>
            <input type="text" class="form-control" id="searchTerm" name="searchTerm" aria-describedby="searchTermHelp" placeholder="Enter last name">
        </div>
        <button type="submit" name="submit" value="search" class="btn btn-primary">Search</button>
        <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View all users</button>
    </form>
</div>


<a href = "admin.jsp">Go to the Admin Page</a>

</body>
</html>