<%-- 
    Document   : searchResult
    Created on : Nov 28, 2016, 3:09:25 AM
    Author     : babylu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Search Result</title>
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
                    <input id="searchInput" type="text" placeholder="search" style='font-size:13px;'>
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
                        <legend>Search Result</legend>
                        <table class="itemShowTable">
                            <tr>
                                <th>Item Name</th>
                                <th>Category</th>
                                <th>Stock</th>
                                <th>Price</th>
                                <th>Buy Number</th>
                            </tr>
    <!--                        <?php

                                $con = mysql_connect("localhost","root","root");
                                if (!$con){
                                    die('Could not connect: ' . mysql_error());
                                }
                                mysql_select_db("e-commerce", $con);
                                $searchInputTotal = $_SERVER["QUERY_STRING"];
                                $strarr = explode("%20",$searchInputTotal);
                                foreach($strarr as $searchInput){
                                    $result = mysql_query("select * from product where name like '%" . $searchInput . "%' or kind like '%" . $searchInput . "%';");                           
                                    while($row = mysql_fetch_array($result)){
                                        echo"<tr><td>" . htmlentities($row["name"]) . "</td>";
                                        echo"<td>" . htmlentities($row["kind"]) . "</td>";
                                        echo"<td>" . htmlentities($row["amount"]) . "</td>";
                                        echo"<td>" . htmlentities($row["price"]) . "</td>";
                                        echo"<td>"
                                            . "<form action='../php/buyProduct.php' method='post'>"
                                                    . "<input type='text' name='number'><input type='hidden' name='product_id' value='".htmlentities($row["product_id"])."'><button type='submit'>Buy</button>"
                                            . "</form></td>";
                                        echo "</tr>";
                                    }

                                }
                                mysql_close($con);
                            ?>-->
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
