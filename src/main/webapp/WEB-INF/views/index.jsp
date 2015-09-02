<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Smart Builds</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="../res/styles/style.css">
        <script type="text/javascript" src="../res/js/jquery-2.1.1.min.js"></script>
    </head>
    <body>
        <div class="middleblock">
            <!-- HEADER -->
            <div class="header">
                <div style="display: table-row;">
                    <div class="inheader">
                        <div class="sitename_block">
                            <a href="./" style="text-decoration: none; color: #fff;"><img src="../res/img/genius1.png" style="width: 186px; height: 128px; text-align:left; float: left;"><div style="padding-top: 35px; margin-left: 138px; font-size: 40px;" class="sitename"><b>Smart-builds</b></div></a>
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
                                        <li><a href="../">Main Page</a></li>
                                            ${createbuild}
                                        <li><a href="../builds">Builds</a></li>
                                        <li><a href="../contacts">Contacts</a></li>
                                        <li><a href="../about">About</a></li>
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

                    <div class="center additional_stuff_s"><span style="font-size: 22px;">Greetings summoner</span></div>

                    <div class="champions">
                        <c:forEach items="${champions}" var="champion">
                            <a href="./builds?champion=${champion.keyChamp}" class="un_cmp" style="background-image: url(http://ddragon.leagueoflegends.com/cdn/5.15.1/img/champion/${champion.keyChamp}.png );"></a>
                        </c:forEach>

                    </div>
                    <!--
                    <div class="popular">
                        <div class="popular_name">popular builds</div>

                        <div class="popular_cont">

                            <table class="popular_build">
                                <tr>
                                    <td class="pop_bld_img" style="background-image: url(http://www.mobafire.com/images/champion/icon/talon.png);"></td>
                                    <td class="pop_bld_name" style="background-color: rgba(60,200,60,0.2);"><div class="pop_bld_name_n"><a href="">SUPER RUSH MUZAFAKAAAA</a></div><div class="pop_bld_name_a">Build was created by <a href="">nice_boy</a> 29/8/15 at 11:16</div></td>
                                </tr>
                            </table>

                            <table class="popular_build">
                                <tr>
                                    <td class="pop_bld_img" style="background-image: url(http://www.mobafire.com/images/champion/icon/talon.png);"></td>
                                    <td class="pop_bld_name" style="background-color: rgba(200,200,60,0.2);"><div class="pop_bld_name_n"><a href="">SUPER RUSH MUZAFAKAAAA</a></div><div class="pop_bld_name_a">Build was created by <a href="">nice_boy</a> 29/8/15 at 11:16</div></td>
                                </tr>
                            </table>

                            <table class="popular_build">
                                <tr>
                                    <td class="pop_bld_img" style="background-image: url(http://www.mobafire.com/images/champion/icon/talon.png);"></td>
                                    <td class="pop_bld_name" style="background-color: rgba(200,60,60,0.2);"><div class="pop_bld_name_n"><a href="">SUPER RUSH MUZAFAKAAAA</a></div><div class="pop_bld_name_a">Build was created by <a href="">nice_boy</a> 29/8/15 at 11:16</div></td>
                                </tr>
                            </table>

                        </div>
                    </div>
                    -->
                    <div class="popular">
                        <div class="popular_name">recent builds</div>

                        <div class="popular_cont">

                            <c:forEach items="${recent}" var="build">
                                <table class="popular_build">
                                    <tr>
                                        <td class="pop_bld_img" style="background-image: url(http://ddragon.leagueoflegends.com/cdn/5.15.1/img/champion/${build.champion.keyChamp}.png);"></td>
                                        <td class="pop_bld_name" style="background-color: rgba(60,200,60,0.2);"><div class="pop_bld_name_n"><a href="./build?id=${build.id}">${build.name}</a></div><div class="pop_bld_name_a">Build was created by <a href="">${build.user.summonerName}</a> </div></td>
                                    </tr>
                                </table>
                            </c:forEach>


                        </div>
                    </div>

                    <div class="clr"></div>

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
                <div style="display: block; width: 222px; text-align: center;"><img src="../res/img/riot.png" style="width: 100px; height: 65px;"><div style="text-align: center;">Riot Games inc.</div><div class="clr"></div></div>
                <div style="display: block;"><a class="logo" href="./">Smart-builds <i>&copy; 2015</i></a></div>
            </li>
            <li>
                <p class="services">Menu</p>
                <ul>
                    <li><a href="../">Main Page</a></li>
                    <li><a href="../builds">Builds</a></li>
                    <li><a href="../contacts">Contacts</a></li>
                    <li><a href="../about">About</a></li>
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

    <script type="text/javascript" src="../res/js/main.js"></script>
    <script>
        $(".finnish").click(function () {
            $(".finnish").css({display: "none"});
            $(".all_champions")
                    .css({display: "block"})
                    .stop(true).animate({opacity: "1"}, 300)
        });
    </script>
</body>
</html>
