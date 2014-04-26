<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ellison
  Date: 24/04/14
  Time: 00:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>

<h3>Adicionar tarefas</h3>

<a href="list">Listar tarefas adicionadas</a>
<br />

<form:errors path="tarefa.descricao" cssStyle="color:red;" />

<form action="add" method="post">
    <label for="txtDescricao">Descricao: </label>
    <br />
    <textarea id="txtDescricao" name="descricao" rows="5" cols="100"></textarea>
    <br />
    <input type="submit" value="Adicionar" />
</form>

</body>
</html>
