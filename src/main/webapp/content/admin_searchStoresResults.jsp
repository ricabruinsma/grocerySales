<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="tm-section" id="tm-section-5">
        <div class="col-xs-12">
            <c:if test="${searchPage.equals('store')}">
            <h3 class="blue-text">Search Results:</h3>
            <c:if test="${stores.isEmpty()}">
                <h3 style="color: red;">No Results were found for your search.</h3>
            </c:if>

            <c:if test="${stores.size() > 0}">
                <table class="table table-striped tm-full-width-large-table" id="storeSearchResults">
                    <thead>
                    <tr>
                        <th>name</th>
                        <th>address</th>
                        <th>city</th>
                        <th>state</th>
                        <th>postal code</th>
                        <th>Admin Functions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="store" items="${stores}">
                        <tr>
                            <td>${store.name}</td>
                            <td>${store.address1}</td>
                            <td>${store.city}</td>
                            <td>${store.state}</td>
                            <td>${store.postalCode}</td>
                            <td><a href="deleteStore?id=${store.id}"><img style="max-width: 2em;" src="img/trashCan.png" alt="delete"></a>
                                <a href="editStore?id=${store.id}"><img style="max-width: 2em;" src="img/edit.png" alt="edit"></a>
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