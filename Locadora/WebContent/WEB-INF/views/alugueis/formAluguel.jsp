<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Realizar aluguel</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>
	<h1>Adicionar Aluguel</h1>
	<div>
	<form action="/Locadora/alugueis" method="post">
		<h2>
			Clientes <select name="cliente.id">
				<c:forEach var="cliente" items="${clientes }">
					<option value="${cliente.id }">${cliente.nome }</option>
				</c:forEach>
			</select>
		</h2>

		<h2>
			Filmes <select name="filme.id">
				<c:forEach var="filme" items="${filmes }">
					<option value="${filme.id }">${filme.titulo }</option>
				</c:forEach>
			</select>
		</h2>
		<button type="submit">Adicionar</button>
	</form>
	</div>
</body>
</html>
