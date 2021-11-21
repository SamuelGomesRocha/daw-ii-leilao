<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>LOGIN</h1>

	<form action="/daw-ii-leilao/login" method="post">
		<input type=text name="input-user" placeholder="user">
		<input type="password" name="input-password"></br></br>
		<input type="submit" name="btn-submit" value="entrar">
	</form>
	<p><a onclick="window.location.href='/daw-ii-leilao/cadastra-user'">Não tem cadastro?</a></p>

</body>
</html>