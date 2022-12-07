<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Products</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <link href="<c:url value="/assets/list.css"/>" rel="stylesheet" type="text/css">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<h1>Products</h1>

<c:forEach items="${products}" var="product">
  <ul>
    <li>${product.productId}</li>
    <li>${product.name}</li>
    <li>${product.description}</li>
    <li>${product.price}</li>
    <li>${product.vat}</li>
  </ul>

</c:forEach>

<a class="btn btn-primary" href="${pageContext.request.contextPath}/products/add">Add a product</a>


</body>
</html>
