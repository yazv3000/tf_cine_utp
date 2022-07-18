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
	DaoEmpleado daoPelicula = new DaoEmpleado();	
	List<Empleado> lst = daoPelicula.consultarEmpleados();
%>
	
<table id="miTabla" class="display" style="font-family: sans-serif">
    <thead>
        <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Cargo</th>
            <th>Corroe</th>
            <th>Dirección</th>
            <th>Salario</th>
        </tr>
    </thead>
    <tbody>
        <%
					for (Empleado emp : lst){
				%>
				<tr>
					<th><%= emp.getCod_empleado()%></th>
					<th><%= emp.getNom_emp()%></th>
					<th><%= emp.getApe_emp()%></th>
					<th><%= emp.getCargo()%></th>
					<th><%= emp.getEmail_emp()%></th>
					<th><%= emp.getDireccion_emp()%></th>
					<th>S/.<%= emp.getSalario()%></th>
				</tr>	
				<%
				}
				%>
    </tbody>
</table>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
    
    <script>
        $(document).ready(function () {
            $('#miTabla').DataTable();
        });
    </script>
</body>
</html>