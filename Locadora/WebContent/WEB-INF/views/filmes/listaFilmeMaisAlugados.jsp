<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem dos Filmes Mais Alugados</title>
<style>
tr {
	color: black;
	background-color: white;
}

h1 {
 	color: black;
 	background-color: white;
 	text-align: center;
}
</style>
</head>
<body>
<c:import url="../menu.jsp"></c:import>

	<h1>Lista de filmes:</h1>

	<table border="10" align="center">
		<thead>
			<tr>
				<th>Titulo</th>
				<th>Genero</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="filme" items="${filmes }">
				<tr>
					<td>${filme.titulo }</td>
					<td>${filme.genero }</td>
				</tr>
			</c:forEach>

		</tbody>

	</table>
</body>
</html>