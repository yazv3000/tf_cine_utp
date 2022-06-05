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
	<h2>Funcion</h2>
		<form action="<%=request.getContextPath()%>/ServletPostFuncion" method="post" target="">
		<div>
		
			<label>Código de Película </label><label><c:out value="${peliculaDto.getCodigo()}"></c:out></label><br/> 
			<label>Título de la Película: </label><label><c:out value="${peliculaDto.getNombre()}"></c:out></label><br/> 
			<label>Duración de la Película: </label><label><c:out value="${peliculaDto.getDuracion()}"></c:out></label><br/> 
		 	
		 	<select name="sala">
				<c:forEach items="${sessionScope.lstSalas}" var="sala">
					<option value="${sala.getCodigo()}">
						Sala <c:out value="${sala.getCodigo()}"></c:out>
					</option>
				</c:forEach>
			</select>
				<input type="date" name="fecha" required/>
				<input type="time" name="hora" required/>
				<input type="number" name="precio" required/>
				<input type="submit" name="accion" value="confirmar" required/>
		</div>
		</form>

</body>
</html>