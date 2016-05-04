/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function getContextPath() {
    return window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
}
var contextPath = getContextPath();
//customer order book
$(document).ready(function () {

    $("#test").submit(function (e) {
        alert(1);
        $.ajax({
            type: "GET",
            url: contextPath + "/book/get20newbooks",
            header: {
                Accept: "application/json; charset=utf-8",
                "Content-Type": "application/json; charset=utf-8"
            },
            data: $("#test").serialize(),
            success: function (response) {
                alert(response);
                $('#result').val(response);
            }
        });
        e.preventDefault();
    });
});