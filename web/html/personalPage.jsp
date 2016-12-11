<%-- 
    Document   : personalPage
    Created on : Dec 7, 2016, 1:49:33 PM
    Author     : babylu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Personal Page</title>
<script type="text/javascript" src="../js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="../js/personalPage.js"></script>
<script type="text/javascript" src="../js/main.js"></script>
<link rel="stylesheet" href="../css/common.css" type="text/css">
<link rel="stylesheet" href="../css/personalPage.css" type="text/css">

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
                <input id="searchInput" type="text" placeholder=" search">
                <img id="searchIcon" alt="searchIcon" src="../img/searchIcon20.jpeg"  onclick="window.location.href='searchResult.php'">
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
            <div class="left">
                <div class="menuPersonal">
                    <ul>
                        <li id="personalInfoNavi">Personal Info</li>
                        <li id="purchaseHistoryNavi">Purchase History</li>
                    </ul>
                </div>
            </div>
            <div class="right">
                <div id="personalInfoPage">
                    <center>
                    <fieldset>
                        <legend>Basic Info</legend>
                        <center>
                        <form id="personalInfo" class="PersonalInfo" action="" method="post">
                            <div>
                                <label>Name: </label>
                                <input type="text" name="name" value="" required>
                            </div>
                            <div>
                                <label>Street: </label>
                                <input type="text" name="address_street" value="" required>
                            </div>
                            <div>
                                <label>City: </label>
                                <input type="text" name="address_city" value="" required>
                            </div>
                            <div>
                                <label>State: </label>
                                <input type="text" name="address_state" value="" required>
                            </div>
                            <div>
                                <label>Zipcode: </label>
                                <input type="text" name="address_zipcode" value="" required>
                            </div>
                            <div>
                                <label>Marriage Statue: </label>
                                <div class="radio" style="margin-top: 0;margin-bottom: 0;"></div>
                            </div>
                            <div>
                                <label>Gender: </label>
                                <div class="radio" style="margin-top: 0;margin-bottom: 0;"></div>
                            </div>
                            <div>
                                <label>Age: </label>
                                <input type="text" name="age" value="">
                            </div>
                            <div>
                                <label>Income: </label>
                                <input type="text" name="income" value="">
                            </div>
                            <button id="updatePersonalInfo">Update</button>
                        </form>
                        </center>
                    </fieldset>
                    </center>
                </div>
                <div id="purchaseHistoryPage" hidden="hidden">
                    <center>
                    <fieldset form="purchaseHistory">
                        <legend>Your History</legend>
                        <table class="itemShowTable">
                            <tr>
                                <th>Order Number</th>
                                <th>Date</th>
                                <th>Salesperson</th>
                                <th>Product Name</th>
                                <th>Quantity</th>
                                <th>Price</th>
                            </tr>
                        </table>
                    </fieldset>
                    </center>
                </div>
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
