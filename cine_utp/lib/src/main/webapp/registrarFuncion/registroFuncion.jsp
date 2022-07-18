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
	<title>CINE UTP</title>
</head>
<body>	
	<h2 align="center">Funcion</h2>
		<form action="<%=request.getContextPath()%>/ServletPostFuncion" method="post" target="" class="justify-content-center needs-validation">
		<div>
		
			<label>Código de Película </label><label><c:out value="${peliculaDto.getCodigo()}"></c:out></label><br/> 
			<label>Título de la Película: </label><label><c:out value="${peliculaDto.getNombre()}"></c:out></label><br/> 
			<label>Duración de la Película: </label><label><c:out value="${peliculaDto.getDuracion()}"></c:out></label><br/> 
		 	
		 	<select class="form-control"name="sala">
				<c:forEach items="${sessionScope.lstSalas}" var="sala">
					<option value="${sala.getCodigo()}">
						Sala <c:out value="${sala.getCodigo()}"></c:out>
					</option>
				</c:forEach>
			</select>
				<input class="form-control" type="date" name="fecha" required/>
				<input class="form-control" type="time" name="hora" required/>
				<input class="form-control" type="number" name="precio" required/>
				<input class="form-control" type="submit" name="accion" value="confirmar" required/>
		</div>
		</form>
	<script src="${context}/js/validForm.js"></script>
</body>
</html>