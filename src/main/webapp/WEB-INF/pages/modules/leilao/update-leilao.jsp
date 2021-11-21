<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aletração de leilão</title>
</head>
<body>
	
	<div name="header">
	<button style="cursor: pointer; color: blue;"
		onclick="window.location.href='/daw-ii-leilao/path?act=home'">HOME</button>
		>
	<button style="cursor: pointer; color: blue;"
		onclick="window.location.href='/daw-ii-leilao/path?act=leiloes'">LISTA DE LEILÕES</button>
		>
		Alteração de leilão
	</div>	
		
	<br>
	<h1>Ateração de leilão (id: ${idLeilao})</h1>
	<form action="/daw-ii-leilao/path?act=alt-leilao&idLeilao=${idLeilao}" method="post"><br>
		<input type=text name="alt-item" placeholder="item"
		value=<%=request.getAttribute("alt-item")%>><br>
		<input type=text name="alt-lanceMinimo" placeholder="lanceMinimo"
		value=<%=request.getAttribute("alt-lanceMinimo")%>><br>
		<input type=text name="alt-dataExpiracao" placeholder="dataExpiracao"
		value=<%=request.getAttribute("alt-dataExpiracao")%>><br>
		
		<label>Status: </label>	
			<select name="alt-status" class="frmCmb1">
			    <c:forEach var="row" items="${possiblesStatus}">
			        <option value="${row.index}">
			            ${row.context}
			        </option>
			     </c:forEach>
			</select>
		<br>
		<br><input type="submit" name="btn-submit" value="alterar"><br>
	</form>

</body>
</html>