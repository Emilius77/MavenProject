<%-- 
    Document   : elencoClienti
    Created on : 13-feb-2017, 12.24.52
    Author     : tss
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Elenco Clienti</title>
    </head>
    <body>
        <h1>Hello Mondooo!</h1>
        <table style="margin: 0 auto;">
            <th>ID</th>
            <th>RAGIONE SOCIALE</th>
            <th>INDIRIZZO</th>
            <c:forEach items="${clientiSrv.findAll()}" var="cli">
                <tr>
                    <td><c:out value="${cli.id}"/></td>
                    <td><c:out value="${cli.ragioneSociale}"/></td>
                    <td><c:out value="${cli.indirizzo}"/></td>
                </tr>
            </c:forEach>
        </table>
        <a href="index.html">HOME</a>        
    </body>
</html>
