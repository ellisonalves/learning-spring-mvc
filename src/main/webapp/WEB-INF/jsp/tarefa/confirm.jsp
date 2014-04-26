<%--
  Created by IntelliJ IDEA.
  User: ellison
  Date: 25/04/14
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<h1><fmt:message key="tarefa.adicionada"/></h1>

<p>A tarefa <strong>${tarefa.descricao}</strong> foi adicionada com sucesso!</p>

<a href="${pageContext.request.contextPath}/tarefa/new">+1</a>

</body>
</html>
