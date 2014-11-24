<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : detalleCompra
    Created on : Nov 23, 2014, 9:12:15 PM
    Author     : JACS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalle de Compra</title>
    </head>
    <jsp:useBean id="carrito" class="modelo.CarritoCompra" scope="session"/>
    <body>
        <h1>Detalle de Compra</h1>
        <table border="1" width="1">
            <thead>
                <tr>
                    <th>Libro</th>
                    <th>Cantidad</th>
                    <th>Sub Total</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="libro" items="${carrito.libros}">
                    <tr>
                        <td><c:out value="${libro.libro.titulo}"/></td>
                        <td><c:out value="${libro.cantidad}"/></td>
                        <td><fmt:formatNumber type="number"  pattern="#,###,00" value="${libro.libro.precio * libro.cantidad}"/></td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

    </body>
</html>
