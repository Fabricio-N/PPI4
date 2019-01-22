<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem dos filmes</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>

	<h1>Lista de filmes:</h1>

	<table border="10" align="center">
		<thead>
			<tr>
				<th>Titulo</th>
				<th>Genero</th>
				<th>Ano de Lançamento</th>
				<th>Preço</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="filme" items="${filmes }">
				<tr>
					<td>${filme.titulo }</td>
					<td>${filme.genero }</td>
					<td>${filme.anoLancamento }</td>
					<td>${filme.preco }</td>
					<td><a href="/Locadora/filmes/remover?id=${filme.id}">Remover</a></td>
					<td><a href="/Locadora/filmes/selecionar?id=${filme.id}">Alterar</a></td>
				</tr>
			</c:forEach>

		</tbody>

	</table>

</body>
</html>