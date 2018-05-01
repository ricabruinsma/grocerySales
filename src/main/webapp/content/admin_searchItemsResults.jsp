<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="tm-section" id="tm-section-5">
        <div class="col-xs-12">
            <c:if test="${searchPage.equals('item')}">
            <h3 class="blue-text">Search Results:</h3>
            <c:if test="${items.isEmpty()}">
                <h3 style="color: red;">No Results were found for your search.</h3>
            </c:if>

            <c:if test="${items.size() > 0}">
                <table class="table table-striped tm-full-width-large-table" id="itemSearchResults">
                    <thead>
                    <tr>
                        <th>brand</th>
                        <th>product</th>
                        <th>category</th>
                        <th>size</th>
                        <th>sale price</th>
                        <th>sale end date</th>
                        <th>store</th>
                        <th>Admin Functions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${items}">
                        <tr>
                            <td>${item.brand}</td>
                            <td>${item.product}</td>
                            <td>${item.category}</td>
                            <td>${item.size}</td>
                            <td>${item.salePrice}</td>
                            <td>${item.saleEndDate}</td>
                            <td>${item.store.name}</td>
                            <td><a href="deleteItem?id=${item.id}"><img style="max-width: 2em;" src="img/trashCan.png" alt="delete"></a>
                                <a href="editItem?id=${item.id}"><img style="max-width: 2em;" src="img/edit.png" alt="edit"></a>
                                <a href="addItem?id=${item.id}"><img style="max-width: 2em;" src="img/add.png" alt="add"></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            </c:if>
        </div>
    </div> <!-- tm-section -->
</div>