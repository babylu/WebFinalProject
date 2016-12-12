$(function(){
    var username = $('#username').html();
    if(username !== 'Login/Register'){
        var now = $('#link').html();
        now = now+'<div id="logout">Logout</div>';
        $('#link').html(now);
            
    }
    $('#username').click(function(){
        if(username === 'Login/Register'){
            window.location.href = 'http://localhost:8080/WebFinalProject/html/login.jsp';
        }else{
            window.location.href = 'http://localhost:8080/WebFinalProject/html/personalPage.jsp';
        }
    });
    $('#logout').click(function(){
        $.post("logout",function(){
            alert('log out success!');
            window.location.href = 'http://localhost:8080/WebFinalProject/html/login.jsp';
        });
    });
});


