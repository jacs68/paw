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
    <%--
    <sql:setDataSource var="libreria" dataSource="${initParam.driver}"
                       url="${initParam.url}" user="${initParam.user}"
                       password="${initParam.password}"/>    
    --%>


    <body>
        <h1>Selección de Libros</h1>
        <hr>
        Seleccione el libro de su preferencia
        <%--
        <sql:query var="libros" dataSource="${libreria}">
            SELECT LIB_TITULO,LIB_ISBN,LIB_STOCK FROM libro
        </sql:query>
        --%>
        <sql:query var="libros" dataSource="jdbc/libreria">
            SELECT LIB_TITULO,LIB_ISBN,LIB_STOCK FROM libro
        </sql:query>
        <form action="ControlSeleccion" method="get">
            <select name="libro">
                <option value="seleccion">Seleccione un libro</option>
                <c:forEach var="libro" items="${libros.rows}">
                    <c:if test="${libro.LIB_STOCK>0}">
                        <option value="${libro.LIB_ISBN}"><c:out value="${libro.LIB_TITULO}"/> (<c:out value="${libro.LIB_STOCK}"/>)</option>
                    </c:if>
                </c:forEach>
            </select>
            Cantidad: <input type="text" name="cantidad" size="3"/><br/>
            <input type="submit" value="Enviar"/>            
        </form>

    </body>
</html>
