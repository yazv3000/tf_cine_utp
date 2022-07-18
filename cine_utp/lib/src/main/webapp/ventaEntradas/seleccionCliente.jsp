<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
<h1 align="center">CLIENTE</h1>
<input type="text" name="cadena"/>
<button type="submit"  name="accion" value="buscar_cliente">Buscar</button>
</form>
<br/>
<div class="row">
<div class="col-1"></div>
<table class="table col-10" border=1>
	<thead class="table-dark">
        <tr> 
            <th>ID</th>
            <th>Nombre Completo</th>
            <th>DNI</th>
            <th>Email</th>
            <th>Accion</th>
        </tr>
    </thead>
    <tbody class="table-light">
        <c:forEach items="${lstDtoClientes}" var="c">
                <tr>
                    <td><c:out value="${c.getIdCliente()}"></c:out></td>
                    <td><c:out value="${c.getNombreCompleto()}"></c:out></td>
                    <td><c:out value="${c.getDni()}"></c:out></td>
                    <td><c:out value="${c.getEmail()}"></c:out></td>
                    <td>
						<form action="<%=request.getContextPath() %>/ServletRegistroBoleta" method="post">
	                    	<input type="hidden" name="cliente" value="${c}" />
	                    	<button type="submit" name="accion" value="seleccionar_cliente">Seleccionar</button>
	                	</form>
					</td>
                </tr>
        </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>