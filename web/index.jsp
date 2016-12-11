<%-- 
    Document   : index
    Created on : Nov 24, 2016, 1:40:13 AM
    Author     : babylu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
        <title>Delicious INC Home Page</title>
        <script type="text/javascript" src="./js/jquery-2.1.4.js"></script>
        <script type="text/javascript" src="./jquery-ui/jquery-ui.min.js"></script>
        <script type="text/javascript" src="./js/main.js"></script>
        <script type="text/javascript" src="./js/searchItem.js"></script>
        <script type="text/javascript" src="./js/jquery.nivo.slider.js"></script>
        <link rel="stylesheet" href="./css/nivo-slider.css" type="text/css">
        <link rel="stylesheet" href="./css/common.css" type="text/css">
        <link rel="stylesheet" href="./css/pageIndex.css" type="text/css">
        <link rel="stylesheet" href="./themes/default/default.css" type="text/css">
    </head>
    <body>
        <div class="mainPart">
            <div class="header">
                <img class="title" alt="title" src="./img/title.jpg">
                <div class="option">
                    <div id="link">
                        <div id="username" class="username"><% 
                            if(session.getAttribute("username") == null){
                                out.print("Login/Register");
                            }else{
                                out.print(session.getAttribute("username"));
                            }
                        %></div>
                    </div>
                    <input id="searchInput" type="text" placeholder="search">
                    <img id="searchIcon" alt="searchIcon" src="./img/searchIcon20.jpeg">
                </div>
                <ul id="menu" class="menu">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="html/iceCream.jsp">Ice Creams</a></li>
                    <li><a href="html/cake.jsp">Cakes</a></li>
                    <li><a href="html/chocolate.jsp">Chocolates</a></li>
                    <li><a href="html/cookie.jsp">Cookies</a></li>
                </ul>
            </div>
            <div class="body">
                <div class="theme-default"> 
                    <div id="slider" class="nivoSlider" style="width:98%;margin:1% 1% 1% 1%;">
                        <img src="img/cake.jpeg" alt="Img"/>
                        <img src="img/cake1.jpg" alt="Img"/>
                        <img src="img/cake2.jpg" alt="Img"/>                                
                    </div>
                </div>

                <script type="text/javascript">
                    $(window).load(function () {
                        $('#slider').nivoSlider();
                    });
                </script>
                <div class="category">
                    <img src="./img/iceCreamsmall.jpeg" alt="cakesmall" onclick="window.location.href='html/iceCream.jsp'">
                    <img src="./img/cakesmall.jpeg" alt="candysmall" onclick="window.location.href='html/cake.jsp'">
                    <img src="./img/chocolatesmall.jpeg" alt="chocolatesmall" onclick="window.location.href='html/chocolate.jsp'">
                    <img src="./img/cookiesmall.jpeg" alt="cookiesmall" onclick="window.location.href='html/cookie.jsp'">
                </div>
            </div>

            <div class="footer">
                <div>Copyright &copy; Delicious Dessert Inc. All Right Reserved.</div>
                <div>ADDRESS: 4200 Fifth Ave, Pittsburgh, PA 15213</div>
                <div>EMAIL: DeliciousDessertInc@gmail.com</div>
                <div>PHONE: 412-***-****</div>
            </div>
        </div>
    </body>
</html>
