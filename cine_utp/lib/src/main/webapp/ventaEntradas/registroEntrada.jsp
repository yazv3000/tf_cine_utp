<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="cli" value="${sessionScope.cliente_entrada}" />
<c:set var="fun" value="${sessionScope.funcion_entrada}" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>CINE UTP</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script></hea d>
	<link rel="stylesheet" type="text/css" href="${context}/css/RegisClien.css">
</head>
<body>
es<c:out value="${sessionScope.cliente_entrada}" ></c:out></label><br/> 
	<div class="d-flex justify-content-center">	
	<form action="<%=request.getContextPath()%>/ServletRegistroBoleta" method="post" target="" class="justify-content-center">
		<div class="card col-12" id="formServPrest">
			<div class="card-body">
				<h1 align="center"><b>CLIENTE</b></h1>
				<div align="center" style="color:white;">
					<label>Código de Cliente: </label><label><c:out value="${cli.getIdCliente()}"></c:out></label><br/> 
					<label>Nombre completo: </label><label><c:out value="${cli.getNombreCompleto()}"></c:out></label><br/> 
					<label>DNI: </label><label><c:out value="${cli.getDni()}"></c:out></label><br/> 
					<label>Email: </label><label><c:out value="${cli.getEmail()}"></c:out></label><br/>
				</div>
			</div>
		</div>
		<div class="row"></div>
		<div class="card col-12 pt-2" id="formServPrest">
			<div class="card-body">
				<h1 align="center"><b>FUNCION</b></h1>
				<div align="center" style="color:white;">
					<label>Código de Función </label><label><c:out value="${fun.getCodFuncion()}"></c:out></label><br/> 
					<label>Título de la Película: </label><label><c:out value="${fun.getNomPeli()}"></c:out></label><br/> 
					<label>Sala</label><label><c:out value="${fun.getSala()}"></c:out></label><br/> 
					<label>Fecha </label><label><c:out value="${fun.getFecha()}"></c:out></label><br/> 
					<label>Hora de inicio </label><label><c:out value="${fun.getHoraInicio()}"></c:out></label><br/> 
					<label>Precio</label><label><c:out value="${fun.getPrecio()}"></c:out></label><br/> 
				</div>
			</div>
			<input style="background: black; color: white;" type="submit" name="accion" value="confirmar" required/>
		</div>
	</form>
	</div>
</body>
</html>