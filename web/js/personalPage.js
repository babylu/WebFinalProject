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
});
