<%-- 
    Document   : build
    Created on : Sep 1, 2015, 3:53:21 PM
    Author     : Tanya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Build</title>
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

                    <div class="center additional_stuff_s"><span style="font-size: 22px;">${build.name}</span></div>

                    <div class="buld_info_blk">
                        <div class="buld_info_blk_img" style="background-image: url(http://ddragon.leagueoflegends.com/cdn/5.2.1/img/champion/${champion}.png); "></div>
                        <div class="buld_info_blk_container">

                            <div class="buld_info_blk_auth">Build was created by <a href="">${author.summonerName}</a> ( ${build.season}, Patch: ${build.patch})</div>
                            <div class="buld_info_blk_about">who is <img src="res/img/tier/${author.tier}.png" height="40" height="40" style="vertical-align: middle;" title="${author.tier}">, playing on server ${author.region} </div>
                        </div>
                        <div class="clr"></div>
                    </div>
                    <div class="build_blocks_bp">

                        <c:forEach items="${blocks}" var="block">
                            <div class="build_block_bp">
                                <div class="bld_bk_name_p">${block.name}</div>
                                <div class="bld_bk_comment_p"><p>${block.comment}</p></div>
                                <div class="clr"></div>
                                <div class="bld_bk_item_p">
                                    <c:forEach items="${block.items}" var="item">
                                        <div class="bld_bk_item_container"><div class="bld_bk_item_img" style="background-image: url(http://ddragon.leagueoflegends.com/cdn/5.2.1/img/item/${item.id}.png);"></div><div class="bld_bk_item_name">${item.name}</div></div>
                                            </c:forEach>
                                    <div class="clr"></div>
                                </div>
                            </div>
                        </c:forEach>


                        <div class="center download">
                            <a href="${download}">DOWNLOAD BUILD</a>
                        </div>

                        <div class="howto">
                            <div>
                                <div class="howto_name">How to install this permanently in game <span style="color: #fff;">guide</span></div>
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