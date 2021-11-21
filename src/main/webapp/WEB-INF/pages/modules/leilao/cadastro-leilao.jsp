<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de leilões</title>
</head>
<body>
	


	<button style="cursor: pointer; color: blue;"
		onclick="window.location.href='/daw-ii-leilao/path?act=home'">HOME</button>
	<br>
	<h1>Cadastro de leilões</h1>
	<form action="/daw-ii-leilao/path?act=cad-leilao" method="post"><br>
		<input type=text name="cad-item" placeholder="item"><br>
		<input type=text name="cad-lanceMinimo" placeholder="lanceMinimo"><br>
		<input type=text name="cad-dataExpiracao" placeholder="dataExpiracao"><br>
		
		<label>Status: </label>	
			<select name="cad-status" class="frmCmb1">
			    <c:forEach var="row" items="${possiblesStatus}">
			        <option value="${row.index}">
			            ${row.context}
			        </option>
			     </c:forEach>
			</select>
		<br>
		<br><input type="submit" name="btn-submit" value="cadastrar"><br>
	</form>

</body>
</html>