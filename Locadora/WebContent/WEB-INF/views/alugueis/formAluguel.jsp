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
    background-color: #33cc33;
    color: green;
    padding: 15px 10px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

div {
    border-radius: 1px;
    background-color: #f2f2f2;
    padding: 20px;
    width: 290px;
    margin: auto;
}

h1 {
	text-align: center;
	color: #ccffff;
	
}
h1 {text-shadow: 0 0 0.2em #000000}
</style>
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
