<%-- 
    Document   : register
    Created on : Dec 9, 2016, 5:21:09 PM
    Author     : babylu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" href="../css/common.css" type="text/css">
<link rel="stylesheet" href="../css/register.css" type="text/css">

</head>
<body>
    <div class="mainPart">
        <div class="header">
            <img class="title" style="margin-left: 0" alt="title" src="../img/title.jpg">
        </div>
        <div class="bodyRegister">
            <form action="register" method="post" id="registerInfo" class="registerTable">
                <div>
                    <label>Username </label>
                    <input type="text" name="username" required>
                </div>
                <div>
                    <label>Password: </label>
                    <input type="password" name="password" required>
                </div>
                <div>
                    <label>Name: </label>
                    <input type="text" name="name" required>
                </div>
                <div>
                    <label>Street: </label>
                    <input type="text" name="address_street" required>
                </div>
                <div>
                    <label>City: </label>
                    <input type="text" name="address_city" required>
                </div>
                <div>
                    <label>State: </label>
                    <input type="text" name="address_state" required>
                </div>
                <div>
                    <label>Zip Code: </label>
                    <input type="text" name="address_zipcode" required>
                </div>
                <div>
                    <label>Marriage Statue: </label>
                    <div class="radio" style="margin-top: 0;margin-bottom: 0;">
                        <input type="radio" name="marriageStatue" value="married" checked="checked">Married
                        <input type="radio" name="marriageStatue" value="single">Single
                    </div>
                </div>
                <div>
                    <label>Gender: </label>
                    <div class="radio" style="margin-top: 0;margin-bottom: 0;">
                        <input type="radio" name="gender" value="female" checked="checked">Female
                        <input type="radio" name="gender" value="fale">Male
                    </div>
                </div>
                <div>
                    <label>Age: </label>
                    <input type="text" name="age">
                </div>
                <div>
                    <label>Income: </label>
                    <input type="text" name="income">
                </div>
                <button id="registerSubmit" type="submit">REGISTER</button>
            </form>
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

