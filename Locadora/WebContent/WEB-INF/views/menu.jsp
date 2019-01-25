<!DOCTYPE html>
<html>
<head>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #3B0B0B;
}

body {
	margin: 0px;
	background-image:
		url("https://assets.nflxext.com/ffe/siteui/vlv3/cf96bcd2-09b3-4fd2-966e-89cfae0019ed/82cec896-1612-432a-b080-80069fe78147/BR-pt-20190121-popsignuptwoweeks-perspective_alpha_website_medium.jpg");
	background-repeat: no-repeat;
	background-size: 1600px 800px;
}

li {
	float: left;
}

li a, .dropbtn {
	display: inline-block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
	background-color: #B40404;
}

li.dropdown {
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #595959;
	min-width: 140px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color:;
}

.dropdown:hover .dropdown-content {
	display: block;
}
</style>
</head>

<ul>

	<li class="dropdown"><a href="javascript:void(0)" class="dropbtn">Home</a>
		<div class="dropdown-content">
			<a href="/Locadora/">Home</a>
		</div></li>



	<li class="dropdown"><a href="javascript:void(1)" class="dropbtn">Cliente</a>
		<div class="dropdown-content">
			<a href="/Locadora/clientes/form">Adicionar Cliente</a> <a
				href="/Locadora/clientes">Listar Clientes</a>
		</div></li>


	<li class="dropdown"><a href="javascript:void(2)" class="dropbtn">Filme</a>
		<div class="dropdown-content">
			<a href="/Locadora/filmes/form">Adicionar Filme</a> <a
				href="/Locadora/filmes">Listar Filmes</a>
				<a href="/Locadora/filmes/MaisAlugados">Listar Filmes Mais Alugados</a>
		</div></li>

	<li class="dropdown"><a href="javascript:void(3)" class="dropbtn">Aluguel</a>
		<div class="dropdown-content">
			<a href="/Locadora/alugueis/form">Adicionar
				Aluguel</a> <a href="/Locadora/alugueis/">Listar
				Alugueis</a> <a href="/Locadora/alugueis/abertos">Alugueis
				Abertos</a> <a href="/Locadora/alugueis/atrasados">Alugueis
				Atrasados</a>
		</div></li>
</ul>


</body>
</html>