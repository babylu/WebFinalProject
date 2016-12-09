
$(function(){
    $('#viewOption').show();
    $('#addOption').hide();
    $('#modifyOption').hide();
    $('#view').click(function(){
        $('#viewOption').show();
        $('#addOption').hide();
        $('#modifyOption').hide();
    });
    $('#add').click(function(){
        $('#addOption').show();
        $('#modifyOption').hide();
        $('#viewOption').hide();
    });
    $('#modify').click(function(){
        $('#modifyOption').show();
        $('#addOption').hide();
        $('#viewOption').hide();
    });
    
});



