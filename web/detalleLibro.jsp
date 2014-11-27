<%-- 
    Document   : detalleLibro
    Created on : 18-nov-2014, 13:06:39
    Author     : Upao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalle de Libro</title>
    </head>
    <c:if test="${sessionScope.usuario==null}">
        <c:redirect url="index.html"/>
    </c:if>
    <jsp:useBean id="carrito" scope="session" class="modelo.CarritoCompra"/>
    <body>
        <h1>Detalle de Libro</h1>
        
        Libro: <c:out value="${carrito.ultimoComprado.titulo}"/><br/>
        Autor: <c:out value="${carrito.ultimoComprado.autor}"/><br/>
        Precio: <c:out value="${carrito.ultimoComprado.precio}"/><br/><br/>
        
        <a href="seleccionLibro.jsp">Haga Click para seguir comprando</a><br/>
        <a href="detalleCompra.jsp">Confirmar Compra</a>
        
    </body>
</html>
