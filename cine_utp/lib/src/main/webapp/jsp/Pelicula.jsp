<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="context" value="${pageContext.request.contextPath}" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css"> 
<link rel="stylesheet" type="text/css" href="../css/style.css">
<title>Insert title here</title>
</head>
<body style="background: none;">
<%@ page import="pe.edu.universidad.dao.*"%>
<%@ page import="pe.edu.universidad.entidades.*"%>
<%@ page import="java.util.List"%>

<header class="header">
	<nav class="nav">
		<a class="logo nav-link">CineUTP</a>
		<ul class="nav-menu">
			<li class="nav-menu-item"><a href="${context}/index.jsp" class="nav-menu-link nav-link">Inicio</a></li>
			<li class="nav-menu-item"><a href="${context}/jsp/Pelicula.jsp" class="nav-menu-link nav-link">pelicula</a></li>
			<li class="nav-menu-item"><a href="${context}/jsp/Empleado.jsp" class="nav-menu-link nav-link">empleado</a></li>
			<li class="nav-menu-item"><a href="<%=request.getContextPath()%>/ServletCliente?accion=listar" class="nav-menu-link nav-link">cliente</a></li>
			<li class="nav-menu-item"><a href="${context}/registrarCliente/registroCliente.jsp" class="nav-menu-link nav-link">Registrese</a></li>
		</ul>
	</nav>
</header>

<div style="margin: 100px 100px; border: gray 5px solid; border-radius: 10px; padding: 20px">
<% 
	DaoPelicula daoPelicula = new DaoPelicula();	
	List<Pelicula> lst = daoPelicula.consultarPeliculas();
%>
	
<table id="miTabla" class="display" style="font-family: sans-serif">
    <thead>
        <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Correo</th>
            <th>Direcci?n</th>
        </tr>
    </thead>
    <tbody>
        <%
					for (Pelicula p : lst){
				%>
				<tr>
					<th><%= p.getCod_pelicula()%></th>
					<th><%= p.getNom_peli() %></th>
					<th><%= p.getTipo() %></th>
					<th><%= p.getCalificacion() %></th>
					<th><%=p.getDuracion()%></th>
					
				</tr>	
				<%
				}
				%>
    </tbody>
    
    
</table>
</div>

<table>
<c:forEach items="${lst}" var="l">
	<tr>
		<td><c:out value="${l.getNom_peli()}"></c:out></td>
	</tr>
</c:forEach>
	
</table>

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
    
    <script>
        $(document).ready(function () {
            $('#miTabla').DataTable();
        });
    </script>
</body>
</html>