/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
    $('#business').hide();
    $('#homeRadio').click(function(){
        $('#home').show();
        $('#business').hide();
    });
    $('#businessRadio').click(function(){
        $('#business').show();
        $('#home').hide();
    });
})
