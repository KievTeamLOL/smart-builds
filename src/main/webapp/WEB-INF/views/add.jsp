<%-- 
    Document   : add_build
    Created on : Aug 19, 2015, 6:47:45 PM
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
        <style>
            img{
                float:left;
            }
        </style>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table border="1" width="90%">
            <tr>
                <th>Tag</th>
                <th>Items</th>
            </tr>
            <c:forEach items="${tags}" var="tag">
                <tr>
                    <th>${tag.name}</th>
                    <td>
                        <c:forEach items="${tag.items}" var="item">
                            <img src="http://ddragon.leagueoflegends.com/cdn/5.2.1/img/item/${item.id}.png" title="${item.name}: ${item.plaintext}">
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
