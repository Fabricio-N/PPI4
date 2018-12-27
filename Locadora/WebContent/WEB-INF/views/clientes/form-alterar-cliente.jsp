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
	<h1>Alterar Dados do Cliente</h1>
	<form action="/Locadora/clientes/alterar" method="post">
	
		<input type="hidden" readonly="readonly" name="id" value="${cliente.id }">
		
		Nome: <input type="text" name="nome" value="${cliente.nome }">
		
		Email: <input type="text" name="email" value="${cliente.email }">
		
		RG: <input type="text" name="rg" value="${cliente.rg }">
		
		Endereço: <input type="text" name="endereco" value="${cliente.endereco }">
		
		Data de Nascimento: <input type="text" name="dataNascimento" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${cliente.dataNascimento.time }"/>'>
		<button type="submit">Alterar</button>
		
	</form>
</body>
</html>