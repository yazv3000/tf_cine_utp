<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Matriculas: Estudiante a matricular</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath() %>/ServletRegistroBoleta">
Cliente:
<input type="text" name="cadena"/>
<input type="submit" value="Buscar">
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
        <c:forEach items="${lstClientes}" var="c">
                <tr>
                    <td><c:out value="${c.getIdCliente()}"></c:out></td>
                    <td><c:out value="${c.getNombreCompleto()}"></c:out></td>
                    <td><c:out value="${c.getDni()}"></c:out></td>
                    <td><c:out value="${c.getEmail()}"></c:out></td>
                </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>