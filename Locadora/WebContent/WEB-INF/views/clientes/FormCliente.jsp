<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserir cliente</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>
	<h1>Adicionar cliente</h1>
	
	<div>
		<form action="/Locadora/clientes" method="post">
			Nome: <input type="text" name="nome">
		
			Email: <input type="text" name="email">
			
			RG: <input type="text" name="rg">
		
			Endereço: <input type="text" name="endereco">
		
			Data de Nascimento: <input type="text" name="dataNascimento">
			<button type="submit">Adicionar</button>
		
		</form>
	</div>
</body>
</html>