<%-- 
    Document   : auth
    Created on : Aug 28, 2015, 10:10:17 PM
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
        <h1>Authorization:</h1>
        <form:form method="POST" modelAttribute="auth">
            Email:<form:input path='email' type='text'/><br>
            Password:<form:input path='password' type='password'/><br>
            <input name='submit' type='submit'>
        </form:form>
        ${result}
    </body>
</html>
