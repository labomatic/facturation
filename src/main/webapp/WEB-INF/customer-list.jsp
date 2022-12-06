
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Customers</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>


<h1>Customers</h1>

<c:forEach items="${customers}" var="customer">
    <ul>
        <li>${customer.name}</li>
        <li>${customer.address}</li>
        <li>${customer.postcode}</li>
        <li>${customer.city}</li>
        <li>${customer.phoneNumber}</li>
        <li>${customer.email}</li>
    </ul>
    <form method="get" action="${pageContext.request.contextPath}/customers/update">
        <input type="hidden" value="${customer.customerId}" name="id">
        <button class="btn btn-primary">Edit</button>
    </form>
    <form method="post" action="${pageContext.request.contextPath}/customers/delete">
        <input type="hidden" value="${customer.customerId}" name="customerId">
        <button class="btn btn-danger">Delete</button>
    </form>
</c:forEach>

<a class="btn btn-primary" href="${pageContext.request.contextPath}/customers/add">Add a customer</a>

</body>
</html>
