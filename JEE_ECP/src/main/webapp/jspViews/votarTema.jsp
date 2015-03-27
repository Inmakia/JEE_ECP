<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Votar tema</title>
</head>
<body>
	<h2>
		Votar tema
	</h2>
	<c:set var="vView" scope="request" value="${votarTema}" />
	<p>
		Va a votar el siguiente tema: 
	</p>
	<p>
		Nombre: <b>${vView.tema.name}</b> 
	</p>
	<p>
		Pregunta: <b>${vView.tema.question}</b> 
	</p>
	<form action="/JEE_ECP/jsp/votarTema" method="post">
		<input type="hidden" name="id" value="${vView.tema.id}" />
		<p>
		Nivel de estudios: <select name="studies">
			<c:forEach var="studies" items="${vView.studiesOptions}">
				<option value="${studies.name()}">${studies.name()}</option>
			</c:forEach>
			</select>
		</p>
		<p>
		Voto (de 1 a 10): <input type="number" name="vote" min="1" max="10" /> 
		</p>
		<p>
			<input type="submit" value="Votar tema" />
		</p>
	</form>
	<p>
	<a href="/JEE_ECP/jsp/home"> Volver al inicio</a>
	</p>
</body>
</html>