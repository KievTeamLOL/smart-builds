<%-- 
    Document   : add_build
    Created on : Aug 31, 2015, 10:28:57 AM
    Author     : Tanya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Create build</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value='res/styles/style.css'/>">
        <script type="text/javascript" src="res/js/jquery-2.1.1.min.js"></script>
    </head>
    <body>
        <div class="middleblock">
            <!-- HEADER -->
            <div class="header">
                <div style="display: table-row;">
                    <div class="inheader">
                        <div class="sitename_block">
                            <a href="/" style="text-decoration: none; color: #fff;"><img src="img/genius.png" style="width: 128px; height: 128px; text-align:left; float: left;"><div style="padding-top: 35px; margin-left: 138px; font-size: 40px;" class="sitename">Name</div></a>
                        </div>
                        <div class="statusbar">
                            <div class="notifbar">
                                <div class="nbar">
                                    <div class="account_log"><a href="">Profile</a><a href="">Authorisation</a></div>
                                    <div class="account_reg"><a href="">Registration</a></div>
                                    <div style="height: 20px;"><form class="search_form"><input id="search_input" type="text" name="search_request" class="search_input"><input id="search_button" type="submit" class="search" style="width: 20px; background-color: none;" value=""></form></div>
                                    <div class="clr"></div>
                                </div>
                                <div class="menubar">
                                    <ul>
                                        <li><a href="/">Main Page</a></li>
                                        <li><a href="page/builds.html">Builds</a></li>
                                        <li><a href="page/contacts.html">Contacts</a></li>
                                        <li><a href="page/about.html">About</a></li>
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
                    <form name="f1">
                        <div class="center center_container">
                            <p><input name="guide_name" id="guide_name" class="guide_name" type="text" value="Guide name"></p>
                        </div>
                        <div class="shop">

                            <div class="shop_block">
                                <div class="sort_block">
                                    <ul>
                                        <div>Defence</div>
                                        <li tag="health">Health</li>
                                        <li>Armor</li>
                                        <li>Magic resist</li>
                                        <li>Health regen</li>
                                        <li>Tenacity</li>
                                        <div>Attack</div>
                                        <li>Damage</li>
                                        <li>Critical strike</li>
                                        <li>Attack speed</li>
                                        <li>Life steal</li>
                                        <div>Magic</div>
                                        <li>text</li>
                                        <li>text</li>
                                        <li>text</li>
                                        <div>Movement</div>
                                        <li>text</li>
                                        <li>text</li>
                                        <div>Block1</div>
                                        <li>text</li>
                                        <li>text</li>
                                        <li>text</li>
                                        <div>Block2</div>
                                        <li>text</li>
                                        <li>text</li>
                                        <div>Block1</div>
                                        <li>text</li>
                                        <li>text</li>
                                        <li>text</li>
                                        <div>Block2</div>
                                        <li>text</li>
                                        <li>text</li>
                                        <div>Block1</div>
                                        <li>text</li>
                                        <li>text</li>
                                        <li>text</li>
                                        <div>Block2</div>
                                        <li>text</li>
                                        <li>text</li>
                                    </ul>
                                </div>
                                <div class="item_list_block">
                                    <div id="gameid1" class="gamecmp" style="background-image: url('http://usercontent2.hubimg.com/6182733_f120.jpg');" title="Abyssal scepter"></div>
                                    <div id="gameid2" class="gamecmp" style="background-image: url('http://img1.wikia.nocookie.net/__cb20130319090217/leagueoflegends/images/4/4e/Boots_of_Speed_item.png');" title="Boots of speed"></div>
                                    <div id="gameid1" class="gamecmp" style="background-image: url('http://usercontent2.hubimg.com/6182733_f120.jpg');" title="Abyssal scepter"></div>
                                    <div id="gameid3" class="gamecmp" tag="health" style="background-image: url('http://img2.wikia.nocookie.net/__cb20130515071904/leagueoflegends/images/6/68/Poro-Snax_item.png');" title="Diet Poro-Snax"></div>
                                    <div id="gameid2" class="gamecmp" style="background-image: url('http://img1.wikia.nocookie.net/__cb20130319090217/leagueoflegends/images/4/4e/Boots_of_Speed_item.png');" title="Boots of speed"></div>
                                    <div id="gameid1" class="gamecmp" style="background-image: url('http://usercontent2.hubimg.com/6182733_f120.jpg');" title="Abyssal scepter"></div>
                                    <div id="gameid3" class="gamecmp" tag="health" style="background-image: url('http://img2.wikia.nocookie.net/__cb20130515071904/leagueoflegends/images/6/68/Poro-Snax_item.png');" title="Diet Poro-Snax"></div>
                                    <div id="gameid1" class="gamecmp" style="background-image: url('http://usercontent2.hubimg.com/6182733_f120.jpg');" title="Abyssal scepter"></div>
                                    <div id="gameid2" class="gamecmp" style="background-image: url('http://img1.wikia.nocookie.net/__cb20130319090217/leagueoflegends/images/4/4e/Boots_of_Speed_item.png');" title="Boots of speed"></div>
                                    <div id="gameid1" class="gamecmp" style="background-image: url('http://usercontent2.hubimg.com/6182733_f120.jpg');" title="Abyssal scepter"></div>
                                    <div id="gameid2" class="gamecmp" style="background-image: url('http://img1.wikia.nocookie.net/__cb20130319090217/leagueoflegends/images/4/4e/Boots_of_Speed_item.png');" title="Boots of speed"></div>
                                    <div id="gameid1" class="gamecmp" style="background-image: url('http://usercontent2.hubimg.com/6182733_f120.jpg');" title="Abyssal scepter"></div>
                                    <div id="gameid3" class="gamecmp" tag="health" style="background-image: url('http://img2.wikia.nocookie.net/__cb20130515071904/leagueoflegends/images/6/68/Poro-Snax_item.png');" title="Diet Poro-Snax"></div>
                                    <div id="gameid2" class="gamecmp" style="background-image: url('http://img1.wikia.nocookie.net/__cb20130319090217/leagueoflegends/images/4/4e/Boots_of_Speed_item.png');" title="Boots of speed"></div>
                                    <div id="gameid1" class="gamecmp" style="background-image: url('http://usercontent2.hubimg.com/6182733_f120.jpg');" title="Abyssal scepter"></div>
                                    <div id="gameid3" class="gamecmp" tag="health" style="background-image: url('http://img2.wikia.nocookie.net/__cb20130515071904/leagueoflegends/images/6/68/Poro-Snax_item.png');" title="Diet Poro-Snax"></div>
                                    <div id="gameid1" class="gamecmp" style="background-image: url('http://usercontent2.hubimg.com/6182733_f120.jpg');" title="Abyssal scepter"></div>
                                    <div id="gameid2" class="gamecmp" style="background-image: url('http://img1.wikia.nocookie.net/__cb20130319090217/leagueoflegends/images/4/4e/Boots_of_Speed_item.png');" title="Boots of speed"></div>
                                    <div id="gameid1" class="gamecmp" style="background-image: url('http://usercontent2.hubimg.com/6182733_f120.jpg');" title="Abyssal scepter"></div>
                                    <div id="gameid2" class="gamecmp" style="background-image: url('http://img1.wikia.nocookie.net/__cb20130319090217/leagueoflegends/images/4/4e/Boots_of_Speed_item.png');" title="Boots of speed"></div>
                                    <div id="gameid1" class="gamecmp" style="background-image: url('http://usercontent2.hubimg.com/6182733_f120.jpg');" title="Abyssal scepter"></div>
                                    <div id="gameid3" class="gamecmp" tag="health" style="background-image: url('http://img2.wikia.nocookie.net/__cb20130515071904/leagueoflegends/images/6/68/Poro-Snax_item.png');" title="Diet Poro-Snax"></div>
                                    <div id="gameid2" class="gamecmp" style="background-image: url('http://img1.wikia.nocookie.net/__cb20130319090217/leagueoflegends/images/4/4e/Boots_of_Speed_item.png');" title="Boots of speed"></div>
                                    <div id="gameid1" class="gamecmp" style="background-image: url('http://usercontent2.hubimg.com/6182733_f120.jpg');" title="Abyssal scepter"></div>
                                    <div id="gameid3" class="gamecmp" tag="health" style="background-image: url('http://img2.wikia.nocookie.net/__cb20130515071904/leagueoflegends/images/6/68/Poro-Snax_item.png');" title="Diet Poro-Snax"></div>
                                    <div id="gameid1" class="gamecmp" style="background-image: url('http://usercontent2.hubimg.com/6182733_f120.jpg');" title="Abyssal scepter"></div>
                                    <div id="gameid2" class="gamecmp" style="background-image: url('http://img1.wikia.nocookie.net/__cb20130319090217/leagueoflegends/images/4/4e/Boots_of_Speed_item.png');" title="Boots of speed"></div>
                                    <div class="clr"></div>
                                </div>
                                <div class="clr"></div>
                            </div>
                            <div class="apeend_items">
                                <div class="prop_block">
                                    <div class="prop_title">BLOCKS</div><select id="champion" class="champion" name="champion"><option>Champion</option><option>Akali</option><option>Aatrox</option><option>Allah Akbar</option><option>Ahahaha</option><option>Other</option></select></p><input class="addblock" type="button" value="ADD BLOCK">
                                </div>
                                <div class="items">
                                    <div id="item_block_0" class="item_block"><div class="block_stuff"><button class="del_item_block">[X]</button><p>Block name:<input class="item_block_name" name="item_block_name0" type="text"> Block comment:<input class="item_block_comm"  name="item_block_comm0" type="text"></p></div></div>
                                </div>
                            </div>
                            <div class="clr"></div>
                        </div>
                        <div class="additional_stuff"><span>additional stuff</span></div>
                        <table class="add_stuff">
                            <tr>
                                <td>Lane:</td>
                                <td><select id="lane" name="lane"><option>Lane</option><option>Top</option><option>Jungle</option><option>Mid</option><option>Bot</option><option>Other</option></select></td>
                            </tr>
                            <tr>
                                <td>Role:</td>
                                <td><select id="role" name="role"><option>Role</option><option>Ap</option><option>Adc</option><option>Tank</option><option>Support</option><option>Other</option></select></td>
                            </tr>
                            <tr>
                                <td>Map:</td>
                                <td><select id="map" name="map"><option>Map</option><option>Summoner's Rift</option><option>Twisted Treeline</option><option>Crystal Scar</option><option>Howling Abyss</option></select></td>
                            </tr>
                            <tr>
                                <td>Guide type:</td>
                                <td><select id="type" name="type"><option>Guide type</option><option>All types</option><option>General</option><option>LOLz</option><option>Other</option></select></td>
                            </tr>
                        </table>
                        <input id="subminput" type="hidden" name="blocks" value="">
                        <div class="center center_container">
                            <input id="finnish" class="finnish" name="finnish" type="submit" value="Send">
                        </div>
                    </form>
                </div>
            </div>
            <!-- END OF CONTENT -->
        </div>
        <!-- FOOTER -->
        <div class="footer">
            <ul>
                <li>
                    <p class="home">Home</p>
                    <div style="display: block; width: 222px; text-align: center;"><img src="img/riot.png" style="width: 100px; height: 65px;"><div style="text-align: center;">Riot Games inc.</div><div class="clr"></div></div>
                    <div style="display: block;"><a class="logo" href="#">Site Name <i>&copy; 2015</i></a></div>
                </li>
                <li>
                    <p class="services">Menu</p>
                    <ul>
                        <li><a href="#">Main Page</a></li>
                        <li><a href="/builds.html">Builds</a></li>
                        <li><a href="/contacts.html">Contacts</a></li>
                        <li><a href="/about">About</a></li>
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

        <script type="text/javascript" src="js/main.js"></script>
        <script>
            function checksome() {
                var data = {};

                for (var i = 0; i < $("div.item_block").length; i++) {

                    var arr_block = {};
                    arr_block.name = $("[name = 'item_block_name" + i + "']").val();
                    arr_block.comment = $("[name = 'item_block_comm" + i + "']").val();
                    var arr_items = new Array();
                    $("[block-id=" + i + "]").each(function (index, element) {
                        arr_items[index] = $(element).attr('alt');
                    });
                    arr_block.items = arr_items;
                    eval("data.block" + i + "=" + JSON.stringify(arr_block));
                }
                var json_data = JSON.stringify(data);
                document.getElementById('subminput').value = json_data;
            }
            document.f1.finnish.onclick = checksome;
        </script>
    </body>
</html>
