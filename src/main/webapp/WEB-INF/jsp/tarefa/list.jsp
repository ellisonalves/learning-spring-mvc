<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ellison
  Date: 24/04/14
  Time: 01:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>

<h2>Listagem de tarefas </h2>
<a href="${pageContext.request.contextPath}/tarefa/new">+1</a>
<br />

<table>
    <tr>
        <th>ID</th>
        <th>Descrição</th>
        <th>Finalizado?</th>
        <th>Data de Finalização</th>
    </tr>
    <c:forEach var="tarefa" items="${tarefas}">
        <tr>
            <td>${tarefa.id}</td>
            <td>${tarefa.descricao}</td>
            <td>${tarefa.finalizado? 'Finalizado' : 'Não finalizado'}</td>
            <td>
            <fmt:formatDate value="${tarefa.dataFinalizacao.time}"
                            pattern="dd/MM/yyyy" /> </td>
            <td>
               <a href="show?id=${tarefa.id}">Update</a> | <a href="remover?id=${tarefa.id}">Remover</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
