<%-- 
    Document   : about
    Created on : Sep 1, 2015, 12:20:11 PM
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
        <link rel="stylesheet" type="text/css" href="./res/styles/style.css">
        <script type="text/javascript" src="./res/js/jquery-2.1.1.min.js"></script>
    </head>
    <body>
        <div class="middleblock">
            <!-- HEADER -->
            <div class="header">
                <div style="display: table-row;">
                    <div class="inheader">
                        <div class="sitename_block">
                            <a href="./" style="text-decoration: none; color: #fff;"><img src="./res/img/genius1.png" style="width: 186px; height: 128px; text-align:left; float: left;"><div style="padding-top: 35px; margin-left: 138px; font-size: 40px;" class="sitename"><b>Smart-builds</b></div></a>
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

                    <div class="center additional_stuff_s"><span style="font-size: 22px;">about us</span></div>

                    <div class="about">
                        <p>Smart Builds is project for easy creating and installing in-game builds. Under builds we understand complex of items, which you need to buy one by one in game to be succeed. We want to alert you that you might will find some bugs or unfinished parts of this site, but we will try to improve it later, in a free from work/study time, because both of programmers are totally exhausted right now. We believe that in future project will be finished and will be commercially valuable.</p>

                        <p>Everyone can enter the project through <a href="">registration</a> and add new, unique build. Also, everyone can download builds and install them directly into game client to use them in in-game shop without browser in the background.</p>

                        <p>Project Smart Builds was created and supported by two independent developers. It was brainstormed in five days and will be completely finished a bit later, to become competitive with other similar sites. All images or data was taken officionally from Riot Games inc. through Riot API and community arts.</p>

                        <p>Independent developers are:</p>
                        <ul>
                            <li>Java, MySQL - Server side prorammer - Doroshenko Tatiana - EUW - SgrStarr</li>
                            <li>HTML, JavaScript - User side programmer - Petrushevskyi Alexander - RU - Levelleor</li>
                        </ul>
                    </div>
                    <div class="center additional_stuff_s"><span style="font-size: 22px;">Did you know?</span></div>
                    <div class="fact">
                        <div style="padding-bottom: 15px;">
                            <span>

                            </span>
                        </div>
                        <div style="">
                            <a class="else_fact" onclick="fact();">else fact</a>
                        </div>
                    </div>

                    <div class="build_blocks_bp">
                        <div class="howto">
                            <div>
                                <div class="howto_name">How to install build permanently in game <span style="color: #fff;">guide</span></div>
                                <hr class="howtoline" style="width: 85%;">
                                <div class="howto_desc">
                                    <table>
                                        <tr><td>step one:</td><td>go to your League of Legends folder. (usually it is in drive C:\ in "Riot Games" folder)</td></tr>
                                        <tr><td>step two:</td><td>go further to C:\Riot Games\League of Legends\Config\Champions\ folder to find all available champions</td></tr>
                                        <tr><td>step three:</td><td>select one champion and then enter the "Recommended" folder</td></tr>
                                        <tr><td>step four:</td><td>put just downloaded guide right inside this folder. (Path should look close to this: C:\Riot Games\League of Legends\Config\Champions\Ahri\Recommended)</td></tr>
                                        <tr><td>step five:</td><td>???</td></tr>
                                        <tr><td>step six:</td><td>profit!</td></tr>
                                    </table>
                                </div>
                                <hr class="howtoline" style="width: 75%;">
                            </div>
                        </div>
                    </div>

                </div>

            </div>
            <!-- END OF CONTENT -->
        </div>
        <!-- FOOTER -->
<div class="footer">
        <ul>
            <li>
                <p class="home">Home</p>
                <div style="display: block; width: 222px; text-align: center;"><img src="./res/img/riot.png" style="width: 100px; height: 65px;"><div style="text-align: center;">Riot Games inc.</div><div class="clr"></div></div>
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

        <script type="text/javascript" src="./res/js/main.js"></script>
        <script>
                                var arr = ["One of developers is lady and her name is Tanya.", "Tanyas favorite champions are Zyra and Skarner.", "Lady was developing server side of project and man - user side.", "Mans name is Alexander.", "Server side was written on Java.", "Site was created in 5 days.", "We have second site dedicated to first Riot API challenge - <a href='http://urf-stats.esy.es/'>urf-stats.esy.es</a>"];
                                function fact() {
                                    n = Math.floor(Math.random() * 7);
                                    $(".fact>div>span").html(arr[n]);
                                }
                                fact();
        </script>
    </body>
</html>