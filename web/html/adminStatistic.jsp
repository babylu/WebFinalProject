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
</head>
<body>
    <div class="mainPart">
        <div class="header">
            <img class="title" alt="title" src="../img/title.jpg">
            <div class="option">
                <div id="logout">Logout</div>
            </div>            
        </div>
        <div class="body">
            <div class="left">
                <ul>
                    <li><a href="adminStock.jsp">Inventory</a></li>
                    <li><a href="adminStatistic.jsp">Statistic</a></li>
                </ul>
            </div>
            <div class="right">
                <div id="navHead" class="navHead" style="display:block">Statistic</div> 
                <div id="figure">
                    <center>
                        <canvas id="gender"></canvas>
                        <span>Radio of gender in our customers</span>
                        <canvas id="product"></canvas>
                        <span>Different kinds of product sale situation</span>
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
        <jsp:useBean id="statistic" class="admin.PrepareStatisticData" scope="page" />
        <jsp:useBean id="data" class="entity.StatisticData" scope="page" />
        <%  
            if(session.getAttribute("type") == null){
                out.println("<script>alert('Please login admin account first!')</script>");
                out.println("<script>window.location.href = 'http://localhost:8080/WebFinalProject/html/login.jsp';</script>");
            }else{
                if(!session.getAttribute("type").toString().equals("admin")){
                    out.println("<script>alert('Please login admin account first!')</script>");
                    out.println("<script>window.location.href = 'http://localhost:8080/WebFinalProject/html/login.jsp';</script>");
                }else{
                    data = statistic.prepareStatisticData();
                }
            }
        %>
        <script>
            var genderData = [{
                    value: <%out.print(data.getFemale());%>,
                    color:"#F7464A",
                    highlight: "#FF5A5E",
                    label: "Female"
                },{
                    value: <%out.print(data.getMale());%>,
                    color: "#46BFBD",
                    highlight: "#5AD3D1",
                    label: "Male"
                }];

            var productData = [{
                    value: <%out.print(data.getCake());%>,
                    color:"#F7464A",
                    highlight: "#FF5A5E",
                    label: "Cake($)"
                },{
                    value: <%out.print(data.getChocolate());%>,
                    color: "gray",
                    highlight: "lightgray",
                    label: "Chocolate($)"
                },{
                    value: <%out.print(data.getCookie());%>,
                    color: "green",
                    highlight: "lightgreen",
                    label: "Cookie($)"
                },{
                    value: <%out.print(data.getIcecream());%>,
                    color: "#46BFBD",
                    highlight: "#5AD3D1",
                    label: "Ice Cream($)"
                }];

            window.onload = function(){
                var ctx1 = document.getElementById("gender").getContext("2d");
                window.myPie = new Chart(ctx1).Pie(genderData);
                var ctx2 = document.getElementById("product").getContext("2d");
                window.myPie = new Chart(ctx2).Pie(productData);
            };  
	</script>
    </div>
                    
<script src="../js/jquery-2.1.4.js" type="text/javascript"></script>
<script src="../chart/Chart.js" type="text/javascript"></script>
<script src="../js/staristicPage.js" type="text/javascript"></script>
</body>
</html>




