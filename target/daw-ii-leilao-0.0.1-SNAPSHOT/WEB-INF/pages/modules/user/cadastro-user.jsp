<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de usuários</title>
</head>
<body>

	<button style="cursor: pointer; color: dark-yellow;"
		onclick="window.location.href='/daw-ii-leilao/login'">Retornar</button>
	<br>
	<h1>Cadastro de usuário</h1>
	<form action="/daw-ii-leilao/cadastra-user" method="post"><br>
		<input type=text name="cad-cpf" placeholder="cpf"><br>
		<input type=text name="cad-nome" placeholder="nome"><br>
		<input type=text name="cad-email" placeholder="email"><br>
		<input type=text name="cad-telefone" placeholder="telefone"><br>
		<input type=text name="cad-user" placeholder="user name"><br>
		<input type=text name="cad-password" placeholder="password"><br><br>
		<input type="submit" name="btn-submit" value="cadastrar"><br>
	</form>
	

</body>
</html>