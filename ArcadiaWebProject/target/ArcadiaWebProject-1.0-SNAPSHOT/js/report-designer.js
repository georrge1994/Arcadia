/**
 * Created by Георгий on 27.03.2017.
 */
// logging
var select_report;      // name selected reposrt

$(function () {
    DisableUnnecessary();
});

$('#design_form input').on('change', function() {
    DisableUnnecessary();
});

function DisableUnnecessary(){
    select_report = $('input[name=select-report]:checked', '#design_form').val(); // get class name checked report

    $('#design_form :input').prop('disabled', true);    // disable all

    $('.' + select_report).prop('disabled', false);        // enable a needed report
    $('.special-radio').prop('disabled', false);        // enable radio-buttons
    $('.sendsubmit').prop('disabled',false);            // enable send-button
}

function createPostData(){
    var index_report = select_report.replace('report','');
    var str = 'type_report=' + index_report + '&'+ $('.' + select_report).serialize();
    return str;
}


$(document).ready(function() {
    var form = $('#design_form');       // contact form
    var submit = $('#submit_xml');      // submit button

    // form submit event
    form.on('submit', function(e) {
        e.preventDefault(createPostData());
        console.log(createPostData());
        $.ajax({
            url: 'controller',
            type: 'POST',
            dataType: 'html',
            data: createPostData(),
            beforeSend: function() {
                console.log("wait..");
            },
            success: function(data) {
                console.log("success");
            },
            error: function(e) {
                console.log(e)
            }
        });
    });
});

