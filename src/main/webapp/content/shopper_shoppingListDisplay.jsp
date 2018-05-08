<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="tm-section" id="tm-section-5">
        <div class="col-xs-12">
            <c:if test="${showList}">
                <h3 class="blue-text">My Shopping List:</h3>
            <c:choose>
                <c:when test="${shoppingList.equals(null)}">
                    <h3 style="color: red;">Your shopping list is empty.</h3>
                </c:when>

                <c:otherwise>
                    <table class="table table-striped tm-full-width-large-table" id="shoppingListItems">
                        <thead>
                        <tr>
                            <th>quantity</th>
                            <th>brand</th>
                            <th>product</th>
                            <th>category</th>
                            <th>size</th>
                            <th>sale price</th>
                            <th>sale end date</th>
                            <th>store</th>
                            <th>Add/Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="listLine" items="${shoppingList.listlines}">
                            <tr>
                                <td>${listLine.quantity}</td>
                                <td>${listLine.item.brand}</td>
                                <td>${listLine.item.product}</td>
                                <td>${listLine.item.category}</td>
                                <td>${listLine.item.size}</td>
                                <td>${listLine.item.salePrice}</td>
                                <td>${listLine.item.saleEndDate}</td>
                                <td>${listLine.item.store.name}</td>
                                <td><form action="updateItemFromList" method="POST">
                                        <input type="hidden" name="listLineIdToUpdate" value="${listLine.id}" />
                                        <input type="hidden" name="currentQuantity" value="${listLine.quantity}" />
                                        <button class="deleteItem" type="submit"><img style="max-width: 2em;" src="img/trashCan.png" alt="delete"></button>
                                    </form>

                                    <form action="deleteItemFromList" method="POST">
                                        <input type="hidden" name="listLineIdToDelete" value="${listLine.id}" />
                                        <button class="deleteItem" type="submit"><img style="max-width: 2em;" src="img/trashCan.png" alt="delete"></button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
            </c:if>
        </div>
    </div> <!-- tm-section -->
</div>