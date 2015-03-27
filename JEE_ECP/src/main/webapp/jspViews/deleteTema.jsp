<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eliminar tema</title>
</head>
<body>
	<h2>
		Eliminar tema
	</h2>
	<c:set var="dView" scope="request" value="${deleteTema}" />
	<form action="/JEE_ECP/jsp/deleteTema" method="post">
		<p>
			¿Desea borrar el tema ${deleteTema.tema.name}?</p>
		<p>
		<input type="hidden" name="id" value="${deleteTema.tema.id}" />
		<p>
			Identificador de autorización: <input name="perm" type="text" /></p>
		<p>
			<input type="submit" value="Borrar tema" />
		</p>
	</form>
	<p>
	<a href="/JEE_ECP/jsp/home"> Volver al inicio</a>
	</p>
</body>
</html>