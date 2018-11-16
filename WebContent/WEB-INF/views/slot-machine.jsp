<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>SlotMachine</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="slotMachine">Slot Machine</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="slotMachine">Home</a></li>
				<li><a href="#">Instructions</a></li>
				<li><a href="#">Credits</a></li>
			</ul>
		</div>
	</nav>

	<h1>Welcome ${player.name } your coins are : ${player.coins }</h1>

	<form action="play">
		<input type="radio" name="bet" value="5" checked> 5<br> <input
			type="radio" name="bet" value="10"> 10<br> <input
			type="radio" name="bet" value="20"> 20 <input type="submit"
			value="Submit">
	</form>

	<div>
		<img src="resources/${game.firstNumber }.png"> <img
			src="resources/${ game.secondNumber }.png"> <img
			src="resources/${game.thirdNumber }.png">
	</div>

	<c:if test="${not empty win }">
		<div class="alert alert-success" role="alert">
			<strong>Complimenti!</strong> Hai vinto!
		</div>
	</c:if>

	<c:if test="${ not empty lose }">
		<div class="alert alert-danger" role="alert">
			<strong>Hai perso!</strong> Ritenta, sarai più fortunato!
		</div>
	</c:if>

	<c:if test="${ not empty cantPlay}">
		<div class="alert alert-warning" role="alert">
			<strong>Attenzione!</strong> Credito insufficiente per poter giocare!
		</div>
	</c:if>




	<form action="logout">
		<input type="submit" value="Esci">
	</form>

</body>
</html>