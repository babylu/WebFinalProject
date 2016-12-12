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
                <div id="navHead" class="navHead" style="">
                    <input type="radio" name="StoreOption" id="add" value="add" checked="">Add
                    <input type="radio" name="StoreOption" id="modify" value="modify">Modify
                </div>
<!--            show add inventory part-->
                <div id="addOption">
                    <div class="showTable">                     
                        <center>
                            <form name="addInventory" action="addInventory" method="POST">
                                <div class="addform">
                                    <label>Category:</label>
                                    <select name="kind">
                                        <option value="cake">cake</option>
                                        <option value="cookie">cookie</option>
                                        <option value="chocolate">chocolate</option>
                                        <option value="icecream">ice cream</option>
                                    </select></br>
                                </div>
                                <div class="addform">
                                    <label>Product Name:</label>
                                    <input type="text" name="name" value="">
                                </div>
                                <div class="addform">
                                    <label>Product Price:</label>
                                    <input type="text" name="price" value="">
                                </div>
                                <div class="addform">
                                    <label>Add Amount:</label>
                                    <input type="text" name="amount" value="">
                                </div>            
                                <button type="submit" class="buttonStyle">Add Inventory</button>          
                            </form>
                        </center>
                    </div>
                </div>

<!--            show modify inventory part-->
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
                                    <jsp:useBean id="searchProduct" class="admin.SearchProduct" scope="page" />
                                    <%
                                        String userType;
                                        if(session.getAttribute("type") == null){
                                            userType="";
                                        }else{
                                            userType = session.getAttribute("type").toString();
                                        }
                                        out.print(searchProduct.searchProduct(userType));
                                    %>
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


