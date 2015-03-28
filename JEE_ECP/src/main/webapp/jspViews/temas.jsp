<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<title>Temas</title>
</head>
<body>
<h2>Temas</h2>
<c:set var="tView" scope="request" value="${temas}" />
<div>${tView.update()}</div>
<table border="2">
<c:forEach var="tema" items="${tView.temas}">
	<tr>
		<td><a href="/JEE_ECP/jsp/votos?id=${tema.id}">Detalles</a></td>
		<td>${tema.name}</td>
		<td>${tema.question}</td>
		<td><form action="/JEE_ECP/jsp/votarTema" method="get">
				<p><input type="submit" value="Votar tema" />
				<input type="hidden" name="id" value="${tema.id}" /></p>
			</form></td>
		<td><form action="/JEE_ECP/jsp/deleteTema" method="get">
				<p><input type="submit" value="Eliminar tema" />
				<input type="hidden" name="id" value="${tema.id}" /></p>
			</form></td>
			
	</tr>
</c:forEach>
</table>
<form action="/JEE_ECP/jsp/addTema" method="get">
	<p><input type="submit" value="Añadir Tema" /></p>
</form>
<p>
	<a href="/JEE_ECP/jsp/home"> Volver al inicio</a>
	</p>
</body>
</html>