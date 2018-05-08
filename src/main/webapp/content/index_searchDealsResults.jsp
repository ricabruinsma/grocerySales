<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="tm-section" id="tm-section-5">
        <div class="col-xs-12">
            <c:if test="${searchPage.equals('index')}">
            <h3 class="blue-text">Search Results:</h3>
            <c:if test="${deals.isEmpty()}">
                <h3 style="color: red;">No Results were found for your search.</h3>
            </c:if>

            <c:if test="${deals.size() > 0}">
                <table class="table table-striped tm-full-width-large-table dealSearchResults">
                    <thead>
                    <tr>
                        <th>brand</th>
                        <th>category</th>
                        <th>product</th>
                        <th>size</th>
                        <th>sale price</th>
                        <th>savings amount</th>
                        <th>sale ends</th>
                        <th>store</th>
                        <c:if test="${pageTitle.equals('GrocerySales - Shopper')}">
                            <th>Add to Shopping List</th>
                        </c:if>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="deal" items="${deals}">
                        <tr>
                            <td>${deal.brand}</td>
                            <td>${deal.category}</td>
                            <td>${deal.product}</td>
                            <td>${deal.size}</td>
                            <td>${deal.salePrice}</td>
                            <td>${deal.savingsAmount}</td>
                            <td>${deal.saleEndDate}</td>
                            <td>${deal.storeName}</td>
                            <c:if test="${pageTitle.equals('GrocerySales - Shopper')}">
                                <td><form action="addItem" method="POST">
                                        <input type="hidden" name="routeDealsTo" value="Shopper" />
                                        <input type="hidden" name="searchType" value="getAll" />
                                        <input type="hidden" name="brand" value="${deal.brand}" />
                                        <input type="hidden" name="category" value="${deal.category}" />
                                        <input type="hidden" name="product" value="${deal.product}" />
                                        <input type="hidden" name="size" value="${deal.size}" />
                                        <input type="hidden" name="salePrice" value="${deal.salePrice}" />
                                        <input type="hidden" name="savingsAmount" value="${deal.savingsAmount}" />
                                        <input type="hidden" name="saleEndDate" value="${deal.saleEndDate}" />
                                        <input type="hidden" name="storeName" value="${deal.storeName}" />
                                        <input type="hidden" name="username" value="${username}" />

                                        <button class="addItem" type="submit"><img style="max-width: 2em;" src="img/add.png" alt="add"></button>
                                    </form>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            </c:if>
        </div>
    </div> <!-- tm-section -->
</div>