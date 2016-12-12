
$(function(){
    $('#addOption').show();
    $('#modifyOption').hide();
    $('#add').click(function(){
        $('#addOption').show();
        $('#modifyOption').hide();
    });
    $('#modify').click(function(){
        $('#modifyOption').show();
        $('#addOption').hide();
    });
    $("#logout").click(function(){
        $.post("logout",function(){
            alert('log out success!');
            window.location.href = 'http://localhost:8080/WebFinalProject/html/login.jsp';
        });
    });
});



