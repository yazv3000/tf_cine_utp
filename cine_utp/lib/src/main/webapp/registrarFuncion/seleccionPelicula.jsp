<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>CINE UTP</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/ServletPostFuncion" method="post" target="">
		<input type="text" name="nom_peli" placeholder="Pelicula"/>
		<input type="submit" value="buscar" name="accion"/>
	</form>
	<h2>Peliculas</h2>
	<table >
		<thead>
			<tr>
				<th>id</th>
				<th>Nombre</th>
				<th>Duracion</th>
				<th>Accion</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lstPeliculas}" var="peli">
				<tr>
					<td><c:out value="${peli.getCodigo()}"></c:out></td>
					<td><c:out value="${peli.getNombre()}"></c:out></td>
					<td><c:out value="${peli.getDuracion()}"></c:out></td>
					<td>
						<form action="${context}/ServletPostFuncion" method="post">
	                    	<input type="hidden" name="codPeli" value="${peli.getCodigo()}" />
	                    	<input type="hidden" name="nombre" value="${peli.getNombre()}" />
							<input type="hidden" name="duracion" value="${peli.getDuracion()}" />
	                    	<button type="submit" name="accion" value="seleccionar">Seleccionar</button>
	                	</form>
					</td>
<%-- 					<input href="<%=request.getContextPath()%>/ServletPostFuncionn?accion=seleccionar&codPeli=${peli.getCodigo()}&nombre=${peli.getNombre()}&duracion=${peli.getDuracion()}" value="Seleccionar"> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>