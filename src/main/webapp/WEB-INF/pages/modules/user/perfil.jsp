<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Perfil</title>
</head>
<body>
<button style="cursor: pointer; color: blue;"
	onclick="window.location.href='/daw-ii-leilao/path?act=home'">HOME</button>
	<h1>${userName}</h1>
	
	<h2>Access lvl: ${userAccess}</h2><br>
	
	<form action="/daw-ii-leilao/path?act=perfil-alt" method="post"><br>
		<input type=text name="alt-cpf" placeholder="cpf" 
		value=<%=request.getAttribute("val-cpf")%>><br>
		<input type=text name="alt-nome" placeholder="nome" 
		value=<%=request.getAttribute("alt-nome")%>><br>
		<input type=text name="alt-email" placeholder="email" 
		value=<%=request.getAttribute("alt-email")%>><br>
		<input type=text name="alt-telefone" placeholder="telefone"
		value=<%=request.getAttribute("alt-telefone")%>><br>
		<input type=text name="alt-user" placeholder="user name"
		value=<%=request.getAttribute("alt-user")%>><br>
		<input type=text name="alt-password" placeholder="password"
		value=<%=request.getAttribute("alt-password")%>><br><br>
		<input type="submit" name="btn-submit" value="alterar"><br>
	</form>
	<br>
	

</body>
</html>