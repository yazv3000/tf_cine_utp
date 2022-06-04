<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${context}/css/style.css">
</head>
<body>
<header class="header">
	<nav class="nav">
		<a class="logo nav-link">CineUTP</a>
		<ul class="nav-menu">
			<li class="nav-menu-item"><a href="#" class="nav-menu-link nav-link">Inicio</a></li>
			<li class="nav-menu-item"><a href="jsp/Pelicula.jsp" class="nav-menu-link nav-link">pelicula</a></li>
			<li class="nav-menu-item"><a href="jsp/Empleado.jsp" class="nav-menu-link nav-link">empleado</a></li>
			<li class="nav-menu-item"><a href="<%=request.getContextPath()%>/ServletCliente?accion=listar" class="nav-menu-link nav-link">cliente</a></li>
			<li class="nav-menu-item"><a href="jsp/RegistrarCliente.jsp" class="nav-menu-link nav-link">Registrese</a></li>
		</ul>
	</nav>
</header>
</body>
</html>