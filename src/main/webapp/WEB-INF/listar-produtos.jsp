<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.letscode.produtoapp.modelo.Produto" %>
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

<% List<Produto> produtos = (List<Produto>) request.getAttribute("produtos"); %>

<table width="500" border="1px">
    <tr>
        <th>NOME</th>
        <th>DESCRIÇÃO</th>
        <th>VALOR</th>
    </tr>
    <%
        for(Produto produto : produtos
        ) {
    %>
    <tr>
        <td><%= produto.getNome() %></td>
        <td><%= produto.getDescricao() %></td>
        <td><%= produto.getValor() %></td>

    </tr>
    <%
        }
    %>
</table>
<button onclick="window.location.href='/produto-app/controladora?acao=produto-form'">
    CADASTRAR NOVO
</button>
</body>
</html>