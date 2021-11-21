<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de usuários</title>
</head>
<body>

	<button style="cursor: pointer; color: blue;"
		onclick="window.location.href='/daw-ii-leilao/path?act=home'">HOME</button>
	<h1>Usuários</h1>
	
	<table>
		
		<thead>
			<tr>
				<th> CPF</th>
				<th> Nome</th>
				<th> Data de nascimento </th>
				<th> E-mail </th>
				<th> Telefone </th>
				<th> Apelido </th>
				<th> Senha  </th>
				<th> Nvl. de Acesso  </th>				
			</tr>
		</thead>
		
		<tbody>
	
			<c:forEach items="${users}" var="u" >
							
				
				<tr id="trLeilas" 
				ondblclick="window.location.href='port?action=/newLances&idLeilao=${l.idLeilao}'">
				
					<td>${u.cpf}</td>
					<td>${u.nome}</td>
					<td>${u.dataNasc}</td>
					<td>${u.email}</td>
					<td>${u.telefone}</td>
					<td>${u.userName}</td>
					<td>${u.password}</td>
					<td>${u.acesso}</td>
					<td><a href="path?act=deletaUser&idUser=${u.idUser}">excluir</a></td>
				</tr>
				
			</c:forEach>
		
		</tbody>
	
	</table>
</body>
</html>