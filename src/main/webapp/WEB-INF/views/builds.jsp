<%-- 
    Document   : builds
    Created on : Sep 1, 2015, 9:35:25 PM
    Author     : Tanya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Builds</title>
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
                    <form name="f1" method="GET">
                        <div class="additional_stuff_s"><span>Search field</span></div>
                        <div class="center_container">
                            <!-- <p><input name="guide_name" id="guide_name" class="guide_name_s" type="text" value="Search requestres."></p> -->
                            <div class="container_cmp">
                                <select id="champion" class="champion_s" name="champion">
                                    <option>Any</option>
                                    <c:forEach items="${champions}" var="champion">
                                        <option>${champion.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="additional_stuff_s"><span>additional stuff</span></div>
                        <table class="add_stuff search_add_st">
                            <tr>
                                <td>Lane:</td>
                                <td><select id="lane" name="lane">
                                        <option>Any</option>
                                        <option>Top</option>
                                        <option>Jungle</option>
                                        <option>Mid</option>
                                        <option>Bot</option>
                                        <option>Other</option>
                                    </select></td>

                                <td>Role:</td>
                                <td><select id="role" name="role">
                                        <option>Any</option>
                                        <option>Ap</option>
                                        <option>Adc</option>
                                        <option>Assassin</option>
                                        <option>Tank</option>
                                        <option>Support</option>
                                        <option>Other</option>
                                    </select></td>

                                <td>Map:</td>
                                <td><select id="map" name="map">
                                        <option>Summoner's Rift</option>
                                    </select></td>
                            </tr>
                            <tr>
                                <td>Build type:</td>
                                <td><select id="type" name="type">
                                        <option>Any</option>
                                        <option>All types</option>
                                        <option>General</option>
                                        <option>LOLz</option>
                                        <option>Other</option>
                                    </select></td>

                                <td>Season:</td>
                                <td><select id="s" name="s">
                                        <option>Season 5</option>
                                    </select></td>

                                <td>Author:</td>
                                <td><select id="author" name="author">
                                        <option>Any</option>
                                        <option>UNRUNKED</option>
                                        <option>BRONZE</option>
                                        <option>SILVER</option>
                                        <option>GOLD</option>
                                        <option>PLATINUM</option>
                                        <option>DIAMOND</option>
                                        <option>CHALLENGER</option>
                                        <option>MASTER</option>
                                    </select></td>
                            </tr>
                        </table>
                        <input id="subminput" type="hidden" name="blocks" value="">
                        <div class="center_container" align="center">
                            <input id="finnish" class="finnish" name="finnish" type="submit" value="FILTER">
                        </div>
                    </form>
                    <div class="center additional_stuff_s"><span>Recent builds</span></div>
                    <div>

                        <table class="build_block" style="">
                            <c:forEach items="${builds}" var="build">
                                <tr style="background-color: rgba(60,200,60,0.2);">
                                    <td class="build_bk_img" style="background-image: url(http://ddragon.leagueoflegends.com/cdn/5.15.1/img/champion/${build.champion.keyChamp}.png);"></td>
                                    <td class="build_bk_inf_l" style="">
                                        <div class="bld_bk_name"><a href="./build?id=${build.id}">${build.name}</a></div>
                                        <div class="bld_bk_auth" style="">created by <a href="">${build.user.summonerName}</a> ${build.user.tier} <b>Lane:</b> ${build.lane} <b>Role:</b> ${build.role} <b>Build type:</b> ${build.type}</div>
                                    </td>
                                    <td class="build_bk_inf_r" style="">
                                        
                                    </td>
                                    <!-- <td class="bld_bk_sc" id="hs" style="background-color: rgba(60,200,60,0.8);">
                                         5/5
                                     </td>-->
                                </tr>
                            </c:forEach>
                        </table>

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
            $(".bld_bk_sc").hover(function () {
                y = $(this).attr("id");
                pr_value = $(this).html();
                if (y == "hs") {
                    $(this).html("This color means that this build has high scores");
                }
                else if (y == "as") {
                    $(this).html("This color means that this build has average scores");
                }
                else {
                    $(this).html("This color means that this build has low scores");
                }
            }, function () {
                $(this).html(pr_value);
            });
        </script>
    </body>
</html>
