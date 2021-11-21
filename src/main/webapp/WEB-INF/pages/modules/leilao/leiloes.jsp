<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="Stylesheet" href="/WEB-INF/css/table.css">

<title>Lista de leilões</title>
</head>
<body>
<c:set var = "adminAccess" scope = "session" value = "ADMIN"/>
<c:set var = "leiloreioAccess" scope = "session" value = "LEILOEIRO"/>
	<button style="cursor: pointer; color: blue;"
		onclick="window.location.href='/daw-ii-leilao/path?act=home'">HOME</button>
	<h1>Leilões</h1>
	
	<table class="styled-table">
		
		<thead>
			<tr>
				<th>Item  </th>
				<th> Lance mínimo  </th>
				<th> Status  </th>
				<th> Data de expiração  </th>			
			</tr>
		</thead>
		
		<tbody>
	
			<c:forEach items="${leiloes}" var="l" >
							
				
				<tr id="trLeilas" style="cursor: pointer;"
				<c:if test="${userAccess == adminAccess or userAccess == leiloeiroAccess}">
				ondblclick="window.location.href='path?act=updateLeilao&idLeilao=${l.idLeilao}'"
				</c:if>>
				
					<td>${l.item}</td>
					<td>${l.lanceMinimo}</td>
					<td>${l.status}</td>
					<td>${l.dataExpiracao}</td>
					<c:if test="${userAccess == adminAccess}">
					<td><a href="path?act=deletaLeilao&idLeilao=${l.idLeilao}">excluir</a></td>
					</c:if>
				</tr>
				
			</c:forEach>
		
		</tbody>
	
	</table>


</body>
</html>