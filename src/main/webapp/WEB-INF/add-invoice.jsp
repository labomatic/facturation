<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add invoice</title>
  <link href="<c:url value="/assets/list.css"/>" rel="stylesheet" type="text/css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>Add invoice</h1>
<form method="post" action="/invoices/add">
  <label for="invoiceDate">Date :</label>
  <input id="invoiceDate" type="date" name="invoiceDate">


  <label for="invoiceCustomer">Customer :</label>
  <select id="invoiceCustomer" name="invoiceCustomer">
    <option value="">--Please choose a customer--</option>
<c:forEach items="${customers}" var="customer">
    <option value="${customer.customerId}">${customer.name}</option>
</c:forEach>
  </select>

 <fieldset>
   <legend>Products :</legend>
  <c:forEach items="${products}" var="product">
    <input type="checkbox" id="product" value="${product.productId}" name="product">
    <label for="product">${product.name}</label>
    <label for="productQuantity">-> Quantity</label>
    <input type="number" min="0" step="1" id="productQuantity" name="productQuantity">
  </c:forEach>
 </fieldset>
  <button>Add</button>
</form>

</body>
</html>

