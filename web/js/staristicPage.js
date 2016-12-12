$("#logout").click(function(){
    $.post("logout",function(){
        alert('log out success!');
        window.location.href = 'http://localhost:8080/WebFinalProject/html/login.jsp';
    });
});


