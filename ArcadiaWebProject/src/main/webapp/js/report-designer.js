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

/*
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
            success: function(response, status, xhr) {
                // check for a filename
                var filename = "";
                var disposition = xhr.getResponseHeader('Content-Disposition');
                if (disposition && disposition.indexOf('attachment') !== -1) {
                    var filenameRegex = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/;
                    var matches = filenameRegex.exec(disposition);
                    if (matches != null && matches[1]) filename = matches[1].replace(/['"]/g, '');
                }

                var type = xhr.getResponseHeader('Content-Type');
                var blob = new Blob([response], { type: type });

                if (typeof window.navigator.msSaveBlob !== 'undefined') {
                    // IE workaround for "HTML7007: One or more blob URLs were revoked by closing the blob for which they were created. These URLs will no longer resolve as the data backing the URL has been freed."
                    window.navigator.msSaveBlob(blob, filename);
                } else {
                    var URL = window.URL || window.webkitURL;
                    var downloadUrl = URL.createObjectURL(blob);

                    if (filename) {
                        // use HTML5 a[download] attribute to specify filename
                        var a = document.createElement("a");
                        // safari doesn't support this yet
                        if (typeof a.download === 'undefined') {
                            window.location = downloadUrl;
                        } else {
                            a.href = downloadUrl;
                            a.download = filename;
                            document.body.appendChild(a);
                            a.click();
                        }
                    } else {
                        window.location = downloadUrl;
                    }

                    setTimeout(function () { URL.revokeObjectURL(downloadUrl); }, 100); // cleanup
                }
            },
            error: function(e) {
                console.log(e)
            }
        });
    });
});

*/