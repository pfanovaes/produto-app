<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.letscode.produtoapp.modelo.Produto" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    // scriplets
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Lista de produtos</title>
</head>
<body>
<h2>Listagem de produtos</h2>

<table width="500" border="1px">
    <tr>
        <th>NOME</th>
        <th>DESCRIÇÃO</th>
        <th>VALOR</th>
    </tr>

    <c:forEach var="produto" items="${ produtos }">
        <tr>
            <td><c:out value="${produto.nome}" /></td>
            <td><c:out value="${produto.descricao}" /></td>
            <td><c:out value="${produto.valor}" /></td>
        </tr>
    </c:forEach>


</table>
<button onclick="window.location.href='/produto-app/controladora?acao=produto-form'">
    CADASTRAR NOVO
</button>
</body>
</html>