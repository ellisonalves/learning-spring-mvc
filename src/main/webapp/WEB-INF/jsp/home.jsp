<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ellison
  Date: 22/04/14
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>

<body>
    <h1> Olá SpringMVC! </h1>
    <hr />

    <a href="<c:url value="/tarefa/new" />">Adicionar Tarefa</a>

    <script src="${pageContext.request.contextPath}/webresources/test.js"></script>
</body>

</html>
