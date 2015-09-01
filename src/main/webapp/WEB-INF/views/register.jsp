<%-- 
    Document   : register
    Created on : Sep 1, 2015, 12:37:14 PM
    Author     : Tanya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Register</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="res/styles/style.css">
        <script type="text/javascript" src="res/js/jquery-2.1.1.min.js"></script>
    </head>
    <body>
        <div class="middleblock">
            <!-- HEADER -->
            <div class="header">
                <div style="display: table-row;">
                    <div class="inheader">
                        <div class="sitename_block">
                            <a href="./" style="text-decoration: none; color: #fff;"><img src="res/img/genius1.png" style="width: 186px; height: 128px; text-align:left; float: left;"><div style="padding-top: 35px; margin-left: 138px; font-size: 40px;" class="sitename"><b>Smart-builds</b></div></a>
                        </div>
                        <div class="statusbar">
                            <div class="notifbar">
                                <div class="nbar">
                                    <div class="account_log"><a href="">${authMsg}</a></div>
                                    <div class="account_reg"><a href="">${exitReg}</a></div>
                                    <div class="clr"></div>
                                </div>
                                <div class="menubar">
                                    <ul>
                                        <li><a href="./">Main Page</a></li>
                                        <li><a href="./builds">Builds</a></li>
                                        <li><a href="./contacts">Contacts</a></li>
                                        <li><a href="./about">About</a></li>
                                    </ul>
                                </div> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END OF HEADER -->
            <!-- CONTENT -->
            <div class="content">
                <div class="wrapper">

                    <div class="center additional_stuff_s"><span style="font-size: 22px;">registration</span></div>

                    <form:form method="POST" modelAttribute="user" name="regform" class="reg_form">
                        <p><b>Region:</b><br>
                            <form:select  path="region">
                                <option value='euw'>Europe West</option>
                                <option value='ru'>Russia</option>
                                <option value='eune'>EU Nordic & East</option>
                                <option value='kr'>Korea</option>
                                <option value='lan'>Latin America North</option>
                                <option value='las'>Latin America South</option>
                                <option value='na'>North America</option>
                                <option value='oce'>Oceania</option>
                                <option value='tr'>Turkey</option>
                            </form:select>
                        </p>
                        <p><b>Summoner name:</b><br>
                            <form:input path='summonerName' type='text' size="40" name="name"/>
                        </p>
                        <p><b>E-mail:</b><br>
                            <form:input path='email' type='email' size="40" name="mail"/>
                        </p>
                        <p><b>Password:</b><br>
                            <form:input path='password' type='password' size="40" name="password"/></p>
                        <p><input name="finnish" type="submit" value="Register" class="reg_send_button"></p>
                        </form:form>
                        <p align='center'><b>${result}</b></p>
                        <br><br><p style="text-align: center;">Registration here is made only to deny amount of hate and troll-action. We do not want collect your data and use it against you. E-mail in registration may be used later to recover your password or login, at the same time it can be used as login, because it is easy to remember. Thank you for your understanding.</p>

                </div>

            </div>
            <!-- END OF CONTENT -->
        </div>
        <!-- FOOTER -->
        <div class="footer">
            <ul>
                <li>
                    <p class="home">Home</p>
                    <div style="display: block; width: 222px; text-align: center;"><img src="res/img/riot.png" style="width: 100px; height: 65px;"><div style="text-align: center;">Riot Games inc.</div><div class="clr"></div></div>
                    <div style="display: block;"><a class="logo" href="#">Site Name <i>&copy; 2015</i></a></div>
                </li>
                <li>
                    <p class="services">Menu</p>
                    <ul>
                        <li><a href="/">Main Page</a></li>
                        <li><a href="/pages/builds.html">Builds</a></li>
                        <li><a href="/pages/contacts.html">Contacts</a></li>
                        <li><a href="/pages/about">About</a></li>
                    </ul>
                </li>
                <li>
                    <p class="reachus">Contacts</p>
                    <ul>
                        <li><a class="hideEmail">Click to show E-mail</a></li>
                    </ul>
                </li>
                <li>
                    <p class="clients">Facebook</p>
                    <ul>
                        <li></li>
                    </ul>
                </li>
                <div class="clr"></div>
            </ul>
        </div>
        <!-- END OF FOOTER -->

        <script type="text/javascript" src="res/js/main.js"></script>
    </body>
</html>