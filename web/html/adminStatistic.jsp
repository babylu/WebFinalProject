<%-- 
    Document   : adminStatistic
    Created on : Dec 11, 2016, 7:29:39 AM
    Author     : babylu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Statistic</title>
<link rel="stylesheet" href="../css/common.css" type="text/css">
<link href="../css/admin.css" rel="stylesheet" type="text/css"/>
<script src="../chart/Chart.js" type="text/javascript"></script>
</head>
<body>
    <div class="mainPart">
        <div class="header">
            <img class="title" alt="title" src="../img/title.jpg">
            <div class="option">
                <div id="username" class="username"><a href="./logIn.php">Log Out</a></div>
            </div>            
        </div>
        <div class="body">
            <div class="left">
            <div class="menuAdmin">
            <ul>
                <li><a href="adminStock.jsp">Inventory</a></li>
                <li><a href="adminStatistic.jsp">Statistic</a></li>
            </ul>
            </div>
                
        </div>
        <div class="right">
            <div id="navHead" class="navHead" style="display:block">Statistic</div> 
            <div>
                <center>
                <canvas id="gender" width="300" height="300" style="margin-top: 20px; width: 300px; height: 300px;"></canvas>
                <center>
                <span>Radio of gender in our customers</span>
                <center>
                <canvas id="region" width="300" height="300" style="margin-top: 20px; width: 300px; height: 300px;"></canvas>
                <center>
                <span>Region sale situation</span>
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




