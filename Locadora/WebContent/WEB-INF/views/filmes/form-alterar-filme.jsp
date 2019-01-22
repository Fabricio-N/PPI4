<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>
	<h1>Alterar Dados do Filme</h1>
	<form action="/Locadora/filmes/alterar" method="post">
	
		<input type="hidden" readonly="readonly" name="id" value="${filme.id }">
		
		Titulo: <input type="text" name="titulo" value="${filme.titulo }">
		
		Genero: <input type="text" name="genero" value="${filme.genero }">
		
		Ano de Lançamento: <input type="text" name="anoLancamento" value="${filme.anoLancamento }">
		
		Preço: <input type="text" name="preco" value="${filme.preco }">
		
		<button type="submit">Alterar</button>
		
	</form>
</body>
</html>