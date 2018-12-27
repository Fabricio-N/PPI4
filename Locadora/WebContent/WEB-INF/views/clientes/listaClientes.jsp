<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem dos clientes</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>

	<h1>Lista de clientes:</h1>

	<table border="10" align="center">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>RG</th>
				<th>Endereço</th>
				<th>Data de Nascimento</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cliente" items="${clientes }">
				<tr>
					<td>${cliente.nome }</td>
					<td>${cliente.email }</td>
					<td>${cliente.rg }</td>
					<td>${cliente.endereco }</td>
					<td><fmt:formatDate value="${cliente.dataNascimento.time}"
							pattern="dd/MM/yyyy" /></td>
					<td><a href="/Locadora/clientes/remover?id=${cliente.id}">Remover</a></td>
					<td><a
						href="/Locadora/clientes/selecionar?id=${cliente.id}">Alterar</a></td>
				</tr>
			</c:forEach>

		</tbody>

	</table>


</body>
</html>




