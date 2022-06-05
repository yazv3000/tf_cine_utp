<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>CINE UTP</title>
	</head>
<body>
<form method="post" action="<%=request.getContextPath() %>/ServletRegistroBoleta">
Cliente:
<input type="text" name="cadena"/>
<input type="submit"  name="accion" value="Buscar">
</form>
<br/>

<table border=1>
	<thead>
        <tr> 
            <th>ID</th>
            <th>Nombre Completa</th>
            <th>DNI</th>
            <th>Email</th>
            <th>Accion</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${lstDtoClientes}" var="c">
                <tr>
                    <td><c:out value="${c.getIdCliente()}"></c:out></td>
                    <td><c:out value="${c.getNombreCompleto()}"></c:out></td>
                    <td><c:out value="${c.getDni()}"></c:out></td>
                    <td><c:out value="${c.getEmail()}"></c:out></td>
                    <td>
						<form action="${context}/ServletPostFuncion" method="post">
	                    	<input type="hidden" name="cliente" value="${c}" />
	                    	<button type="submit" name="accion" value="seleccionar">Seleccionar</button>
	                	</form>
					</td>
                </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>