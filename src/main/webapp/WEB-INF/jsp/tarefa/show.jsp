<%--
  Created by IntelliJ IDEA.
  User: ellison
  Date: 19/05/14
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title></title>
</head>
<body>

<h1>Alterando tarefa - ${tarefa.id}</h1>

<form action="update" method="POST">

    <input name="id" type="hidden" value="${tarefa.id}"/>

    Descrição:
    <textarea name="descricao" cols="100" rows="5">${tarefa.descricao}</textarea>

    Finalizado?
    <input name="finalizado" type="checkbox" value="true" ${tarefa.finalizado ? 'checked' : ''} />
    <br />

    Data de finalização:
    <input name="dataFinalizacao" type="text" value="<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>" />

    <br />

    <button type="submit">Alterar</button>
</form>

</body>
</html>
