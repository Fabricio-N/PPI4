<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<style>
input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 15px 10px;
	margin: 8px 0px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	
}

input[type=submit]:hover {
	background-color: #45a049;
}

div {
	border-radius: 1px;
	margin: auto;
	background-color: #f2f2f2;
	padding: 20px;
	width: 290px;
	
}

h1 {
	text-align: center;
	color: white;
	background-color: #3B0B0B;
	background-size: 300px 100px;
}

h1 {text-shadow: 0 0 0.2em #000000}

h3 {
	color: #B40404;
}
</style>

<head>
<meta charset="UTF-8">
<title>Inserir filme</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>

	<h1>Adicionar Filme</h1>

	<div>
		<form action="/Locadora/filmes" method="post">
			<h3>Titulo:</h3> <input type="text" name="titulo">
			
			<h3>Genero:</h3> <input type="text" name="genero">
			
			<h3>Ano de Lançamnto:</h3> <input type="text" name="anoLancamento">
			
			<h3>Preço:</h3> <input type="text" name="preco">
			
		    <input type="submit" value="Adicionar">
		</form>
	</div>

</body>
</html>
