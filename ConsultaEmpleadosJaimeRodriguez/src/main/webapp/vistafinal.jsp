<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/index.css" rel="stylesheet" type="text/css"/>
        <title>Empleados</title>
    </head>
    <body>
        <a href="index.jsp">Volver</a>
        <h1>Listado de empleados que coinciden con: </h1>
        <c:out value="${excepcion}"></c:out>
            <table>
                <tr>
                    <th>Nº Empleado</th>
                    <th>Nombre</th>
                    <th>Primer Apellido</th>
                    <th>Segundo Apellido</th>
                    <th>DNI</th>
                </tr>
                <c:forEach items="${listaEmpleados}" var="empleado">
                    <tr>
                        <td>${empleado.codigo}</td>
                        <td>${empleado.nombre}</td>
                        <td>${empleado.apellido1}</td>
                        <td>${empleado.apellido2}</td>
                        <td>${empleado.nif}</td>
                    </tr>
                </c:forEach>
            </table>
        
    </body>
</html>
