<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : index
    Created on : 05/11/2014, 09:15:48 AM
    Author     : docente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Librer&iacute;a Atlantida</title>
    </head>
    <sql:setDataSource var="libreria" driver="com.mysql.jdbc.Driver"                       
                       url="jdbc:mysql://localhost:3306/libreria"
                       user="root" password="mysql"/>
    <body>
        <h1>Selección de Libros</h1>
        <hr>
        Seleccione el libro de su preferencia
    <sql:query var="libros" dataSource="${libreria}">
        SELECT LIB_TITULO,LIB_ISBN FROM libro
    </sql:query>
        <form action="ControlSeleccion" method="get">
            <select name="libro">
                <option value="seleccion">Seleccione un libro</option>
                <c:forEach var="libro" items="${libros.rows}">
                    <option value="${libro.LIB_ISBN}"><c:out value="${libro.LIB_TITULO}"/></option>
                </c:forEach>
                
                
            </select>
            Aca esta el driver:<c:out value="${applicationScope.driver}"/>
        </form>
    </body>
</html>
