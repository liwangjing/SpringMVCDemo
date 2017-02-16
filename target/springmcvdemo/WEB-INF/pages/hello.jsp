<%--
  Created by IntelliJ IDEA.
  User: jing
  Date: 2017/2/16
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include.jsp"%>  <!--include the include.jsp file into this file-->
<html>
<head>
    <title>Spring MVC hello page</title>
</head>
<body>
<h1>This is the hello page</h1>
<p>Greetings, it is now <c:out value="${now}"/></p>

</body>
</html>
