<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tema nuevo</title>
</head>
<body>
	<h2>
		Datos de nuevo tema
	</h2>
	<form action="/JEE_ECP/jsp/addTema" method="post">
		<p>
			Nombre: <input name="nombre" type="text" /></p>
		<p>
		<p>
			Pregunta: <input name="pregunta" type="text" /></p>
		<p>
			<input type="submit" value="Añadir tema" />
		</p>
	</form>
	<p>
	<a href="/JEE_ECP/jsp/home"> Volver al inicio</a>
	</p>
</body>
</html>