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
<form method="post" action="<%=request.getContextPath() %>/ServletRegistroBoleta" class="justify-content-center needs-validation">
<h1 align="center">FUNCION</h1>
<input type="number" name="codigo"/>
<button type="submit"  name="accion" value="buscar_funcion">Buscar</button>
</form>
<br/>

<table class="table col-10" border=1>
	<thead class="table-dark">
        <tr> 
            <th>FUNCION</th>
            <th>Película</th>
            <th>Sala</th>
            <th>Fecha</th>
            <th>Hora</th>
            <th>Precio</th>
        </tr>
    </thead>
    <tbody class="table-light">
        <c:forEach items="${lstDtoFunciones}" var="f">
                <tr>
                    <td><c:out value="${f.getCodFuncion()}"></c:out></td>
					<td><c:out value="${f.getNomPeli()}"></c:out></td>
					<td><c:out value="${f.getSala()}"></c:out></td>
					<td><c:out value="${f.getFecha()}"></c:out></td>
					<td><c:out value="${f.getHoraInicio()}"></c:out></td>
					<td><c:out value="${f.getPrecio()}"></c:out></td>
					
                    <td>
						<form action="<%=request.getContextPath() %>/ServletRegistroBoleta" method="post" class="justify-content-center needs-validation">
	                    	<input class="form-control" type="hidden" name="funcion" value="${f}" />
	                    	<button class="boton" type="submit" name="accion" value="seleccionar_funcion">Seleccionar</button>
	                	</form>
					</td>
                </tr>
        </c:forEach>
    </tbody>
</table>

	<script src="${context}/js/validForm.js"></script>
</body>
</html>