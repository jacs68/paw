<%-- 
    Document   : confirmacion
    Created on : 27-nov-2014, 8:42:25
    Author     : Upao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmaci&oacute;n</title>
    </head>
    <c:if test="${sessionScope.usuario==null}">
        <c:redirect url="index.html"/>
    </c:if>
    <body>
        <h1>Confirmaci&oacute;n de Compra</h1>
        Su orden fue procesada satisfactoriamente, Gracias por su preferencia<br/><br/>
        Haga click <a href="seleccionLibro.jsp">aqu&iacute;</a> para seguir comprando<br/>
        Haga click <a href="salir.jsp">aqu&iacute;</a> para cerrar sesión
    </body>
</html>
