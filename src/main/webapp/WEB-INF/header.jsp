
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header>
    <div class="header">
    <a class="btn btn-light" href="${pageContext.request.contextPath}/invoices">See invoices</a>
    <a class="btn btn-light" href="${pageContext.request.contextPath}/customers">See customers</a>
    <c:choose>
        <c:when test="${empty sessionScope.username}">
            <a class="btn btn-info" href="${pageContext.request.contextPath}/login">Log in</a>
        </c:when>
        <c:otherwise>
            <form method="post" action="${pageContext.request.contextPath}/logout">
                <input class="btn btn-danger" type="submit" value="Logout">
            </form>
        </c:otherwise>
    </c:choose>
    </div>
</header>
