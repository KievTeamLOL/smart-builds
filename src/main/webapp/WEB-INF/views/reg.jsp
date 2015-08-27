<%-- 
    Document   : reg
    Created on : Aug 27, 2015, 4:15:28 PM
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
        <h1>Registration</h1>
        <form:form method="POST" modelAttribute="user">
            Region: <br>
            <form:select  path="region">
                <form:option value='euw'>Europe West</form:option>
                <form:option value='ru'>Russia</form:option>
                <form:option value='eune'>EU Nordic & East</form:option>
                <form:option value='kr'>Korea</form:option>
                <form:option value='lan'>Latin America North</form:option>
                <form:option value='las'>Latin America South</form:option>
                <form:option value='na'>North America</form:option>
                <form:option value='oce'>Oceania</form:option>
                <form:option value='tr'>Turkey</form:option>
            </form:select><br>
            Summoner name: <br>
            <form:input path='summonerName' type='text'/><br>
            Email: <br>
            <form:input path='email' type='email'/><br>
            Password:<br>
            <form:input path='password' type='password'/><br>
            <input name='submit' type='submit'>
        </form:form>
        ${result}
    </body>
</html>
