<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<title>Votos</title>
</head>
<body>
<c:set var="vsView" scope="request" value="${votos}" />
	<h2>Información del tema ${vsView.tema.name}</h2>
	<p>Nombre: <b>${vsView.tema.name}</b></p>
	<p>Pregunta: <b>${vsView.tema.question}</b></p>
	<p>Votos totales: <b>${vsView.total}</b></p>
	<p>Media de votos: <b>${vsView.media}</b></p>
	<c:if test="${vsView.mediaPorEstudios != null}">
		<p>Media de votos del nivel de estudios ${vsView.studies}: <b>${vsView.mediaPorEstudios}</b></p>
	</c:if>
	<p>Elija nivel de estudios para ver la media según el mismo:</p>
	<form action="/JEE_ECP/jsp/votos?id=${vsView.tema.id}" method="post">
		<p><select name="studies">
				<c:forEach var="studies" items="${vsView.studiesOptions}">
					<option value="${studies.name()}">${studies.name()}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<input type="hidden" name="id" value="${vsView.tema.id}" />
			<input type="submit" value="Ver votos" />
		</p>	
	</form>
<p>
	<a href="/JEE_ECP/jsp/home"> Volver al inicio</a>
	</p>
</body>
</html>