
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Update invoice</title>
  <link href="<c:url value="/assets/list.css"/>" rel="stylesheet" type="text/css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>Update invoice</h1>

<c:choose>
<c:when test="${customerNotFound}">
  <div class="alert alert-danger w-25 p-3" role="alert">
    Game not found !
  </div>
</c:when>


<c:otherwise>
<form method="post" action="/invoices/update">
  <input type="hidden" value="${invoice.invoiceId}" name="id">

  <label for="invoiceDate">Date :</label>
  <input id="invoiceDate" type="date" name="invoiceDate" value="${invoice.invoiceDate}">

  <label for="invoiceTotal">Total :</label>
  <input id="invoiceTotal" type="number" step="0.01" min="0" name="invoiceTotal" value="${invoice.total}">

  <label for="invoiceCustomer">Customer :</label>
  <select selected="selected" id="invoiceCustomer" name="invoiceCustomer">
    <c:forEach items="${customers}" var="customer">
      <c:choose>
        <c:when test="${invoice.customer.customerId == customer.customerId}">
          <option value="${customer.customerId}" selected>${customer.name}</option>
        </c:when>
        <c:otherwise>
          <option value="${customer.customerId}">${customer.name}</option>
        </c:otherwise>
      </c:choose>

    </c:forEach>
  </select>

  <button>Edit</button>
</form>

</c:otherwise>
</c:choose>

</body>
</html>