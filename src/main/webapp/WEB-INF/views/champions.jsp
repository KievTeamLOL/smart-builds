<%-- 
    Document   : champions
    Created on : Aug 21, 2015, 3:36:34 PM
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
        <select>
            <c:forEach items="${champions}" var="champion">
                <option value="${champion.id}">${champion.name}</option>
            </c:forEach>
        </select>
    </body>
</html>
