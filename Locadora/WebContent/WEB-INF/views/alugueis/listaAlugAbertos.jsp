<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar aluguel abertos</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>

	<h1>Alugueis Abertos:</h1>

	<table border="10" align="center">
		<thead>
			<tr>
				<th>Filme</th>
				<th>Cliente</th>
				<th>RG</th>
				<th>Data do Aluguel</th>
				<th>Devolução</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="aluguel" items="${alugueis}">
				<tr>
					<td>${aluguel.filme.titulo}</td>
					<td>${aluguel.cliente.nome}</td>
					<td>${aluguel.cliente.rg}</td>
					<td><fmt:formatDate value="${aluguel.dataAluguel.time}" pattern="dd/MM/yyyy" /></td>
					<td><a
						href="/Locadora/alugueis/devolucao?id=${aluguel.id}">devolver</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>