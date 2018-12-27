<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar aluguel</title>
</head>
<body>

<c:import url="../menu.jsp"></c:import>

	<h1>Lista de Alugueis:</h1>

	<table border="10" align="center">
		<thead>
			<tr>
				<th>Nome do Cliente</th>
				<th>Nome do Filme</th>
				<th>Data do Aluguel</th>
				<th>Data de Devolução</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="aluguel" items="${alugueis }">
				<tr>
					<td>${aluguel.cliente.nome }</td>
					<td>${aluguel.filme.titulo }</td>
					<td><fmt:formatDate value="${aluguel.dataAluguel.time}" pattern="dd/MM/yyyy" /></td>
					<td><fmt:formatDate value="${aluguel.dataDevolucao.time}" pattern="dd/MM/yyyy" /></td>
				</tr>
			</c:forEach>

		</tbody>

	</table>

</body>
</html>