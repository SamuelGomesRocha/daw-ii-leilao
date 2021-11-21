<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME</title>
</head>
<body>
 	<c:set var = "adminAccess" scope = "session" value = "ADMIN"/>
 	<c:set var = "leiloeiroAccess" scope = "session" value = "LEILOEIRO"/>
	<h1>Wellcome to Leilões, ${userName}</h1>
	
	
	

	<button style="cursor: pointer; color: blue;"
	onclick="window.location.href='/daw-ii-leilao/path?act=leiloes'">Leilões</button>
	
	<button style="cursor: pointer; color: blue;"
	onclick="window.location.href='/daw-ii-leilao/path?act=perfil'">Perfil</button>
	
	<c:if test="${userAccess == leiloeiroAccess}">
	
	<button style="cursor: pointer; color: blue;"
	onclick="window.location.href='/daw-ii-leilao/path?act=leilao-cad'">Cadastra leilões</button>	
	</c:if>
	
 	<c:if test="${userAccess == adminAccess}">
	<button style="cursor: pointer; color: blue;"
	onclick="window.location.href='/daw-ii-leilao/path?act=users'">Usuários</button>
	
	<button style="cursor: pointer; color: blue;"
	onclick="window.location.href='/daw-ii-leilao/path?act=leilao-cad'">Cadastra leilões</button>	
	</c:if>

	 
	<br><br><br><br>
	<button style="cursor: pointer; color: red;"
		onclick="window.location.href='/daw-ii-leilao/path?act=logout'">Logout</button>
</body>
</html>