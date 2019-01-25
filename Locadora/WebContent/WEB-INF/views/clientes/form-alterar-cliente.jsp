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

h4 {
	color: #B40404;
}

</style>
<head>
<meta charset="UTF-8">
<title>Alterar</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>
	<h1>Alterar Dados do Cliente</h1>
	<form action="/Locadora/clientes/alterar" method="post">
	<div>
	
		<input type="hidden" readonly="readonly" name="id" value="${cliente.id }">
		
		<h4>Nome:</h4> <input type="text" name="nome" value="${cliente.nome }">
		
		<h4>Email:</h4> <input type="text" name="email" value="${cliente.email }">
		
		<h4>RG:</h4> <input type="text" name="rg" value="${cliente.rg }">
		
		<h4>Endereço:</h4> <input type="text" name="endereco" value="${cliente.endereco }">
		
		<h4>Data de Nascimento:</h4> <input type="text" name="dataNascimento" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${cliente.dataNascimento.time }"/>'>
		
		<input type="submit" value="Adicionar">
	</div>
	</form>
</body>
</html>