<%-- 
    Document   : contacts
    Created on : Sep 1, 2015, 12:19:48 PM
    Author     : Tanya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Guides</title>
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
                                        ${createbuild}
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

                    <div class="center additional_stuff_s"><span style="font-size: 22px;">contacts</span></div>

                    <div class="contacts">
                        <div class="cnt">
                            <span>Alexander</span>
                            <ul>
                                <li><a class="hidden_data" hid="alexander0007@ukr.net">Click to show E-mail</a></li>
                                <li><a class="hidden_data" hid="https://www.facebook.com/levelleor.coshe">Click to show FaceBook</a></li>
                            </ul>
                        </div>
                        <div class="cnt">
                            <span>Tatiana</span>
                            <ul>
                                <li><a class="hidden_data" hid="tanya.doroshenko91@gmail.com">Click to show E-mail</a></li>
                                <li><a class="hidden_data" hid="https://www.facebook.com/profile.php?id=100000777868772">Click to show FaceBook</a></li>
                            </ul>
                        </div>
                        <div class="clr"></div>
                    </div>

                    <div class="center additional_stuff_s" style="margin-bottom: 15px;"><span style="font-size: 22px;">We are from Ukraine, Kiev</span></div>

                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d325516.3770455823!2d30.532690549999998!3d50.402035500000004!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40d4cf4ee15a4505%3A0x764931d2170146fe!2z0JrQuNC10LI!5e0!3m2!1sru!2sua!4v1441033569152" width="100%" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>

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
                <div style="display: block;"><a class="logo" href="./">Smart-builds <i>&copy; 2015</i></a></div>
            </li>
            <li>
                <p class="services">Menu</p>
                <ul>
                    <li><a href="./">Main Page</a></li>
                    <li><a href="./builds">Builds</a></li>
                    <li><a href="./contacts">Contacts</a></li>
                    <li><a href="./about">About</a></li>
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
        <script>
            $(".hidden_data").click(function () {
                $(this).html($(this).attr("hid"));
            });
        </script>
    </body>
</html>
