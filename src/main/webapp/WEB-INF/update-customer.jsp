
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Update Customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="<c:url value="/assets/list.css"/>" rel="stylesheet" type="text/css">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>Edit customer</h1>


<c:choose>
    <c:when test="${customerNotFound}">
        <div class="alert alert-danger w-25 p-3" role="alert">
            Game not found !
        </div>
    </c:when>


    <c:otherwise>
        <form method="post" action="/customers/update">  <%--ou ajout dans url de l'id--%>
            <input type="hidden" value="${customer.customerId}" name="id">

            <label for="customerName">Name :</label>
            <input id="customerName" type="text" name="customerName" value="${customer.name}">

            <label for="customerAddress">Address :</label>
            <input id="customerAddress" type="text" name="customerAddress" value="${customer.address}">

            <label for="customerPostcode">Postcode :</label>
            <input id="customerPostcode" type="number" name="customerPostcode" value="${customer.postcode}">

            <label for="customerCity">City :</label>
            <input id="customerCity" type="text" name="customerCity" value="${customer.city}">

            <label for="customerPhoneNumber">Phone number :</label>
            <input id="customerPhoneNumber" type="text" name="customerPhoneNumber" value="${customer.phoneNumber}">

            <label for="customerEmail">Email :</label>
            <input id="customerEmail" type="text" name="customerEmail" value="${customer.email}">

            <button>Edit</button>
        </form>
    </c:otherwise>
</c:choose>

</body>
</html>
