<%--
  Created by IntelliJ IDEA.
  User: jing
  Date: 2017/2/16
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include.jsp" %>
<html>
<head>
    <title><fmt:message key="title"/></title>
</head>
<body>
<h1><fmt:message key="heading"/></h1>
<p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
<h3>Products</h3>

<c:forEach items="${model.products}" var="prod">
    <c:out value="${prod.description}"/> <i>$<c:out value="${prod.price}"/> </i><br><br>
</c:forEach>

</body>
</html>
