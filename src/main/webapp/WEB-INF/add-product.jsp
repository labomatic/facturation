<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add product</title>
  <link href="<c:url value="/assets/list.css"/>" rel="stylesheet" type="text/css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>Add product</h1>
<form method="post" action="/products/add">
  <label for="productName">Name :</label>
  <input id="productName" type="text" name="productName">

  <label for="productDesc">Description :</label>
  <input id="productDesc" type="text" name="productDesc">

  <label for="productPrice">Price :</label>
  <input id="productPrice" type="number" step="0.01" min="0" name="productPrice">

  <label for="productVat">VAT :</label>
  <input id="productVat" type="number" step="0.01" min="0" name="productVat">

  <button>Add</button>
</form>

</body>
</html>


