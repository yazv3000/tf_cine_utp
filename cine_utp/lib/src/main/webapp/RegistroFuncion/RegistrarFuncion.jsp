<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/ServletPostFuncionn" method="post" target="">
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
					<td><a href="<%=request.getContextPath()%>/ServletPostFuncionn?accion=agregar&codPeli=${peli.getCodigo()}&nombre=${peli.getNombre()}&duracion=${peli.getDuracion()}">Agregar</a>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h2>Funcion</h2>
		<form action="<%=request.getContextPath()%>/ServletPostFuncionn" method="post" target="">
		<div>
			<label>id: </label><label><c:out value="${codPeli}"></c:out></label><br/> 
			<label>id: </label><label><c:out value="${nombrePeli}"></c:out></label><br/> 
			<label>id: </label><label><c:out value="${duracion}"></c:out></label><br/> 
		 	<select name="sala">
				<c:forEach items="${lstSalas}" var="sala">
					<option value="${sala.getCodigo()}"><c:out
							value="${sala.getCodigo()}"></c:out></option>
				</c:forEach>
			</select>
				<input type="date" name="fecha"/>
				<input type="time" name="hora"/>
				<input type="number" name="precio"/>
				<input type="submit" name="accion" value="confirmar"/>
		</div>
		</form>

</body>
</html>