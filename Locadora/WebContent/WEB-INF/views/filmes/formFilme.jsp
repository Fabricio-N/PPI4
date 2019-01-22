<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserir filme</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>

	<h1>Adicionar Filme</h1>

	<div>
		<form action="/Locadora/filmes" method="post">
			Titulo: <input type="text" name="titulo">
			
			Genero: <input type="text" name="genero">
			
			Ano de Lançamnto: <input type="text" name="anoLancamento">
			
			Preço: <input type="text" name="preco">
			
		    <input type="submit" value="Submit">
		</form>
	</div>

</body>
</html>
