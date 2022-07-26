<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Cine UTP</title>
	<link rel="stylesheet" type="text/css" href="${context}/css/style.css">
</head>
<body>
<header class="header">
	<nav class="nav">
		<a class="logo nav-link">CineUTP</a>
		<ul class="nav-menu">
			<li class="nav-menu-item"><a href="${context}/index.jsp" class="nav-menu-link nav-link">Inicio</a></li>
			<li class="nav-menu-item"><a href="${context}/jsp/Pelicula.jsp" class="nav-menu-link nav-link">pelicula</a></li>
			<li class="nav-menu-item"><a href="${context}/jsp/Empleado.jsp" class="nav-menu-link nav-link">empleado</a></li>
			<li class="nav-menu-item"><a href="${context}/registrarCliente/registroCliente.jsp" class="nav-menu-link nav-link">Registrese</a></li>
		</ul>
	</nav>
</header>
</body>
</html>