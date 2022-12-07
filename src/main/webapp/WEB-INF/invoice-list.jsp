
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Invoices</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="<c:url value="/assets/list.css"/>" rel="stylesheet" type="text/css">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<h1>Invoices</h1>

<c:forEach items="${invoices}" var="invoice">
    <ul>
        <li>${invoice.invoiceId}</li>
        <li>${invoice.invoiceDate}</li>
        <li>${invoice.total}€</li>
        <li>${invoice.customer.name}</li>

        <c:forEach items="${invoice.getAssociationList()}" var="obj">
            <li>${obj.getProductQuantity()}x ${obj.getProduct().getName()}</li>

        </c:forEach>

    </ul>
<div class="button">
    <form method="get" action="${pageContext.request.contextPath}/invoices/details">
        <input type="hidden" value="${invoice.invoiceId}" name="id">
        <button class="btn btn-primary">Details</button>
    </form>
    <form method="get" action="${pageContext.request.contextPath}/invoices/update">
        <input type="hidden" value="${invoice.invoiceId}" name="id">
        <button class="btn btn-primary">Edit</button>
    </form>

    <form method="post" action="${pageContext.request.contextPath}/invoices/delete">
        <input type="hidden" value="${invoice.invoiceId}" name="invoiceId">
        <button class="btn btn-danger">Delete</button>
    </form>
</div>
</c:forEach>

<a class="btn btn-primary" href="${pageContext.request.contextPath}/invoices/add">Add an invoice</a>


</body>
</html>