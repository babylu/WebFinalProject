<%-- 
    Document   : adminStock
    Created on : Dec 11, 2016, 7:26:38 AM
    Author     : babylu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Stock</title>
<script src="../js/jquery-2.1.4.js" type="text/javascript"></script>
<link rel="stylesheet" href="../css/common.css" type="text/css">
<link href="../css/admin.css" rel="stylesheet" type="text/css"/>
<script src="../js/admin.js" type="text/javascript"></script>
</head>
<body>
    <div class="mainPart">
        <div class="header">
            <img class="title" alt="title" src="../img/title.jpg">
            <div class="option">
                <div id="username" class="username"><a href="./login.jap">Log Out</a></div>
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
                <div id="navHead" class="navHead" style="display:block">
                    <div id="navHead" class="navHead" style="display:block">
                    <input type="radio" name="StoreOption" id="view" value="view" checked="">View
                    <input type="radio" name="StoreOption" id="add" value="add">Add
                    <input type="radio" name="StoreOption" id="modify" value="modify">Modify
                </div>
                </div>
<!--        show view inventory part     -->
                <div id="viewOption">
                    <div class="showForm">
                        <center>
                            <table class="viewTable">
                                <thead>
                                    <tr>
                                        <th >ID</th>
                                        <th >Name</th>
                                        <th >Amount</th>
                                        <th >Price</th>
                                        <th >Category</th>   
                                    </tr>
                                </thead>
                                <tr>
                                </tr>
                            </table>
                        </center>
                    </div>
                </div>
<!--            show add inventory part-->
            <div id="addOption">
                <div class="showTable">                     
                    <center>
                        <form name="addInventory" action="../php/addproduct.php" method="POST">
                            <div class="addform">
                                <label>Category:</label>
                                <select name="product_kind" style="width:80px;">
                                    <option value="cake">cakes</option>
                                    <option value="cookie">cookies</option>
                                    <option value="chocolate">chocolates</option>
                                    <option value="icecream">icecream</option>
                                </select></br>
                            </div>
                            <div class="addform">
                                <label>Product Name:</label>
                                <input type="text" name="InventoryName" value=""></br>
                            </div>
                            <div class="addform">
                                <label>Product Price:</label>
                                <input type="text" name="price" value=""></br>
                            </div>
                            <div class="addform>"
                                <label>Add Amount:</label>
                                <input type="text" name="amount" value="" style="width: 30px;height: 20px;"></br>
                            </div>       
                            </br>               
                            <div class="addform">               
                                <input type="submit" value="Add Inventory" class="buttonStyle">
                            </div>           
                        </form>
                    </center>
                </div>
            </div>

<!--                show modify inventory part-->
                <div id="modifyOption">
                    <div class="showForm">
                        <center>
                            <table class="viewTable">
                                <thead>
                                    <tr>
                                        <th >ID</th>
                                        <th >Name</th>
                                        <th >Amount</th>
                                        <th >Price</th>
                                        <th >Category</th>
                                        <th >Modify</th>
                                    </tr>
                                </thead>
                            </table>
                        </center>     
                    </div>    
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


