<%-- 
    Document   : items
    Created on : Aug 18, 2015, 1:10:35 PM
    Author     : Tanya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table border="1" width="90%">
            <tr>
                <th>id</th>
                <th>name</th>
                <th>image</th>
                <th>plaintext</th>
                <th>description</th>
                <th>tags</th>
            </tr>
            <c:forEach items="${items}" var="item">
                <tr align="center">
                    <td>${item.id}</td>
                    <th>${item.name}</th>
                    <td><img src="http://ddragon.leagueoflegends.com/cdn/5.2.1/img/item/${item.id}.png"></td>
                    <td>${item.plaintext}</td>
                    <td>${item.description}</td>
                    <td>${item.tags}</td>
                </tr>
            </c:forEach>
        </table>
        ${data}
    </body>
</html>
