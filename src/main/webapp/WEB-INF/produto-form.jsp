<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de produtos</title>
</head>
<body>
<fieldset> <legend>Formulário de cadastro de produtos</legend>
    <form action="/produto-app/controladora?acao=cadastrar-produto" method="post">
        <label>Nome</label> <input type="nome" name="nome"/>
        <label>Descricao</label> <input type="descricao" name="descricao"/>
        <label>Valor</label> <input type="number" name="valor"/>

        <button>Cadastrar</button>
    </form>
</fieldset>
</body>
</html>
