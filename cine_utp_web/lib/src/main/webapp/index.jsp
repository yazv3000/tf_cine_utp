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
	<link rel="stylesheet" type="text/css" href="${context}/css/index.css">
</head>
<body>
<header class="header">
	<nav class="nav">
		<a class="logo nav-link">CineUTP</a>
		<div id="links">
		<ul class="nav-menu">
			<li class="nav-menu-item margin"><a class="boton" href="${context}/gestionarFuncion/registroFuncion.xhtml" class="nav-menu-link nav-link">Crear Funcion</a></li>
			<li class="nav-menu-item margin"><a class="boton" href="${context}/comprarTicket/registrarCliente.xhtml" class="nav-menu-link nav-link">Comprar de Ticket</a></li>
			<li class="nav-menu-item margin"><a class="boton" href="${context}/comprarProductos/clienteProducto.xhtml" class="nav-menu-link nav-link">Comprar de Productos</a></li>
			<li class="nav-menu-item margin"><a class="boton" href="${context}/alquilarSala/clienteAlquiler.xhtml" class="nav-menu-link nav-link">Alguiler de Sala</a></li>
		</ul>
		</div>
	</nav>
</header>
</body>
</html>