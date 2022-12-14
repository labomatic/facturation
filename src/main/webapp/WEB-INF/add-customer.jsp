<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add customer</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <link href="<c:url value="/assets/list.css"/>" rel="stylesheet" type="text/css">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>Add customer</h1>
<form method="post" action="/customers/add">
  <label for="customerName">Name :</label>
  <input id="customerName" type="text" name="customerName">

  <label for="customerAddress">Address :</label>
  <input id="customerAddress" type="text" name="customerAddress">

  <label for="customerPostcode">Postcode :</label>
  <input id="customerPostcode" type="number" name="customerPostcode">

  <label for="customerCity">City :</label>
  <input id="customerCity" type="text" name="customerCity">

  <label for="customerPhoneNumber">Phone number :</label>
  <input id="customerPhoneNumber" type="text" name="customerPhoneNumber">

  <label for="customerEmail">Email :</label>
  <input id="customerEmail" type="text" name="customerEmail">

  <button>Add</button>
</form>

</body>
</html>
