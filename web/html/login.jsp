<%-- 
    Document   : login
    Created on : Nov 25, 2016, 5:40:26 PM
    Author     : babylu
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>LOG IN</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="../css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body style="height:100%;">
        <div id="content">
            <div class="container">
                <div class="row">
                    <div id="login_block" class="col-sm-4 col-sm-offset-4"  style="background-color: #ffffff;opacity:0.9;">  
                        <h3 align="center" style='margin-bottom: 2%; padding-bottom: 5px;border-bottom: dotted 1px gray;'>Login</h3>
                        <form method="post" action="login" class="form-horizontal"  role="form">
                            <div class="form-group">
                                <label class="col-sm-4 control-label">Username</label>
                                <div class="col-sm-6">
                                    <input type="text" id="username" name="username" class="form-control" placeholder="Username" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">Password</label>
                                <div class="col-sm-6">
                                    <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
                                </div>
                            </div>
                            <div class="form-group" style='margin-left: 1%;'>
                                <label class="col-sm-4 col-sm-offset-2 radio-inline" >
                                    <input type="radio" value="customer" name="type" id="customer" checked="checked"> Customer
                                </label>
                                
                                <label class="col-sm-4 radio-inline">
                                    <input type="radio" value="admin" name="type" id="admin"> Admin
                                </label>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-4">
                                    <button class="btn btn-primary btn-block" type="submit">Log In</button>
                                </div>
                                <div class="col-sm-4">
                                    <button class="btn btn-primary btn-block" type="button" onclick="window.location.href='register.jsp'">Register</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>


