<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:set var="context" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css" href="${context}/css/RegisClien.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<title>CINE UTP</title>
</head>
<body style="background: black;">
	<div class="d-flex justify-content-center">
		<div class="row pt-5">
		<div class="col-3"></div>
		<div class="card col-5" id="formServPrest">
			<div class="card-body">
				<h1 align="center"><b>Registrar Cliente</b></h1>
				<form class="justify-content-center needs-validation" align="center" action="<%=request.getContextPath()%>/ServletCliente" method="post" novalidate>
					<div class="row"> 
						<div class="form-group pt-2 col-6">
							<label class="formuTecTit">PRIMER NOMBRE</label>
						</div>
						<div class="form-group pt-2 col-6">
							<label class="formuTecTit">SEGUNDO NOMBRE</label>
						</div>
					</div>
					<div class="form-group pt-1">
						<div style="float:left; width: 190px;">
						<input type="text" class="form-control estinputs" placeholder="Primer Nombre" name="txtnom1" required>
						</div>
						<div style="float:right; width: 190px;">
						<input type="text" class="form-control estinputs" placeholder="Primer Nombre" name="txtnom2" required>
						</div>
						<div style="clear:both"></div>
					</div>
					<div class="row"> 
						<div class="form-group pt-2 col-6">
							<label class="formuTecTit">APELLLIDO PATERNO</label>
						</div>
						<div class="form-group pt-2 col-6">
							<label class="formuTecTit">APELLIDO MATERNO</label>
						</div>
					</div>
					<div class="form-group pt-1">
						<div style="float:left; width: 190px;">
						<input type="text" class="form-control estinputs" placeholder="Apellido Paterno" name="txtape1" required>
						</div>
						<div style="float:right; width: 190px;">
						<input type="text" class="form-control estinputs" placeholder="Apellido Materno" name="txtape2" required>
						</div>
						<div style="clear:both"></div>
					</div>
					<div class="form-group pt-2">
						<label class="formuTecTit">DNI</label>
						<input type="number" class="form-control estinputs"  placeholder="DNI" name="txtdni" required>
					</div>
					<div class="form-group pt-2">
						<label class="formuTecTit">CORREO</label>
						<input type="email" class="form-control estinputs" placeholder="Correo Electronico" name="txtemail" required>
					</div>
					<div class="form-group pt-2">
						<label class="formuTecTit">DIRECCION</label>
						<input type="text" class="form-control estinputs" placeholder="Direccion" name="txtdireccion" required>
					</div>
					<div class="form-group text-center pt-2">
						<input class="btn btn-warning" type="submit" name="accion" value="Registrar">
					</div>
					<div class="form-group text-center pt-2">
						<a style="color: red; background: blue;" href="${context}/registrarCliente/registrar.xhtml">a</a>
					</div>
				</form>
				
				
			</div>
		</div>
		</div>
	</div>
	
	<!-- SCRIPTS -->
	<script src="${context}/js/validForm.js"></script> 
	
</body>
</html>