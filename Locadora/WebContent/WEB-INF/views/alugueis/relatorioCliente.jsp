<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>

h1 {
	text-shadow: 0 0 0.5em black;
	text-align: center;
	color: white;
	font-size: 50px;
	background-color: #3B0B0B;
 }

#div1 {-webkit-animation-timing-function: O cliente atingiu o limite de filmes alugados;}

#div1 {
	width: 525px;
    height: 70px;
    background-color: black;
    font-weight: bold;
    position: relative;
    -webkit-animation: mymove 8s infinite;
    animation: mymove 8s infinite;
    color: white;
   text-align: center;
   font-size: 30px;
}
@-webkit-keyframes mymove {
    from {left: 0px;}
    to {left: 550px;}
}

@keyframes mymove {
    from {left: 0px;}
    to {left: 550px;}
}

</style>

<body>
	<c:import url="../menu.jsp"></c:import>
	<h1>Aviso:</h1>
	<div id="div1">O cliente atingiu o limite de filmes alugados</div>
</body>
</html>