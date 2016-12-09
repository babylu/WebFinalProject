/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
    $('#personalInfoNavi').click(function(){
        $('#personalInfoPage').show();
        $('#purchaseHistoryPage').hide();
    });
    $('#purchaseHistoryNavi').click(function(){
        $('#personalInfoPage').hide();
        $('#purchaseHistoryPage').show();
    });
    
    $('#business').hide();
    $('#home').hide();
    
    if(document.getElementById("homeRadio").checked === true){
        $('#home').show();
        $('#business').hide();
    }else if(document.getElementById('businessRadio').checked === true){
        $('#business').show();
        $('#home').hide();
    }
    
    $('#homeRadio').click(function(){
        $('#home').show();
        $('#business').hide();
    });
    $('#businessRadio').click(function(){
        $('#business').show();
        $('#home').hide();
    });
});
