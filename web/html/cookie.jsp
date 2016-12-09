<%-- 
    Document   : cookie
    Created on : Nov 28, 2016, 3:52:58 AM
    Author     : babylu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Cookies</title>
        <script type="text/javascript" src="../js/jquery-2.1.4.js"></script>
        <script type="text/javascript" src="../js/main.js"></script>
        <script type="text/javascript" src="../js/searchItem.js"></script>
        <link rel="stylesheet" href="../css/common.css" type="text/css">
        <link rel="stylesheet" href="../css/pageIndex.css" type="text/css">
    </head>
    <body>
        <div class="mainPart">
            <div class="header">
                <img class="title" alt="title" src="../img/title.jpg">
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
                    <input id="searchInput" type="text" placeholder=" search"style='font-size:13px;'>
                    <img id="searchIcon" alt="searchIcon" src="../img/searchIcon20.jpeg">
                </div>
                <ul id="menu" class="menu">
                    <li><a href="../index.jsp">Home</a></li>
                    <li><a href="iceCream.jsp">Ice Creams</a></li>
                    <li><a href="cake.jsp">Cakes</a></li>
                    <li><a href="chocolate.jsp">Chocolates</a></li>
                    <li><a href="cookie.jsp">Cookies</a></li>
                </ul>
            </div>
            <div class="body">
                <center>
                    <fieldset form="iceCreamList">
                        <legend>Cookie</legend>
                        <table class="itemShowTable">
                            <tr>
                                <th>Item Name</th>
                                <th>Stock</th>
                                <th>Price</th>
                                <th>Buy Number</th>
                            </tr>
                            <tbody>
                                <jsp:useBean id="searchItem" class="customer.SearchItem" scope="page" />
                                <%
                                    out.print(searchItem.searchItemByType("cookie")); 
                                %>
                            </tbody>
                        </table>
                    </fieldset>
                </center>
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
