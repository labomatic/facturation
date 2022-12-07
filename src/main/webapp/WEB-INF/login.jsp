<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="<c:url value="/assets/list.css"/>" rel="stylesheet" type="text/css">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>Login</h1>

<c:if test="${unknownUser}">
    <div class="alert alert-danger w-25 p-3" role="alert">Unknown User !</div>
</c:if>
<c:if test="${loginFail}">
    <div class="alert alert-danger w-25 p-3" role="alert">Bad credentials</div>
</c:if>

<form method="post" action="${pageContext.request.contextPath}/login">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" value="login">
</form>

</body>
</html>
