<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="${context}/css/tabla.css">
	<title>CINE UTP</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/ServletPostFuncion" method="post" target="" class="justify-content-center needs-validation pt-4">
		<input type="text" name="nom_peli" placeholder="Pelicula"/>
		<input type="submit" value="buscar" name="accion"/>
	</form>
	<h2 class="titulo" align="center">PELICULAS</h2>
	<div class="row">
	<div class="col-1"></div>
	<table class="table col-10" id="tabla">
		<thead class="table-dark" id="tabla-titulos">
			<tr>
				<th>id</th>
				<th>Nombre</th>
				<th>Duracion</th>
				<th>Accion</th>
			</tr>
		</thead>
		<tbody class="table-light">
			<c:forEach items="${lstPeliculas}" var="peli">
				<tr>
					<td><c:out value="${peli.getCodigo()}"></c:out></td>
					<td><c:out value="${peli.getNombre()}"></c:out></td>
					<td><c:out value="${peli.getDuracion()}"></c:out></td>
					<td>
						<form class="justify-content-center needs-validation" action="${context}/ServletPostFuncion" method="post">
	                    	<input class="form-control" type="hidden" name="codPeli" value="${peli.getCodigo()}" required />
	                    	<input class="form-control" type="hidden" name="nombre" value="${peli.getNombre()}" required />
							<input class="form-control" type="hidden" name="duracion" value="${peli.getDuracion()}" required />
	                    	<button type="submit" name="accion" value="seleccionar">Seleccionar</button>
	                	</form>
					</td>
<%-- 					<input href="<%=request.getContextPath()%>/ServletPostFuncionn?accion=seleccionar&codPeli=${peli.getCodigo()}&nombre=${peli.getNombre()}&duracion=${peli.getDuracion()}" value="Seleccionar"> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<script src="${context}/js/validForm.js"></script>
</body>
</html>