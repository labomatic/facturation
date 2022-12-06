<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add invoice</title>
</head>
<body>

<h1>Add invoice</h1>
<form method="post" action="/invoices/add">
  <label for="invoiceDate">Date :</label>
  <input id="invoiceDate" type="date" name="invoiceDate">

  <label for="invoiceTotal">Total :</label>
  <input id="invoiceTotal" type="number" name="invoiceTotal">

  <label for="invoiceCustomer">Customer :</label>
  <select id="invoiceCustomer" name="customerList">
    <option value="">--Please choose a customer--</option>
<c:forEach items="${customers}" var="customer">
    <option value="${customer.customerId}">${customer.name}</option>
</c:forEach>
  </select>

  <button>Add</button>
</form>

</body>
</html>

