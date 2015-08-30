<%-- 
    Document   : facebook
    Created on : Aug 29, 2015, 10:49:01 PM
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
        <div id="fb-root"></div>
        <script>(function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id))
                    return;
                js = d.createElement(s);
                js.id = id;
                js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.4";
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));</script>
        <h1>Hello World!</h1>
        <div class="fb-like" data-href="https://vk.com/id7052545" data-layout="standard" data-action="like" data-show-faces="true" data-share="false"></div>
        <h2>Create file:</h2>
        <form:form method="POST" modelAttribute="file">
            Name:<form:input path='fileName' type='text'/><br>
            Text:<form:input path='fileText' type='text'/><br>
            <input name='submit' type='submit'>
        </form:form>
        ${result}
    </body>
</html>
