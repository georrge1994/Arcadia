function dateVeryfy()
{

    var x1 = document.getElementById("report1_date_begin").value;
    var x2 = document.getElementById("report1_date_end").value;
    if (x1>=x2)
    {
        alert( " Sorry, wrong date entered" );
       /* document.getElementsById("report1_form").onsubmit=false;*/
        document.getElementsById("report1_button_send").onsubmit=false;

    }
    document.getElementsById("report1_button_send").onsubmit=true;
}

function dateVeryfy2()
{
    var x1 = document.getElementById("report2_date_begin").value;
    var x2 = document.getElementById("report2_date_end").value;
    if (x1>=x2)
    {
        alert( " Sorry, wrong date entered" );
    }
}

function dateVeryfy3()
{
    var x1 = document.getElementById("report3_date_begin").value;
    var x2 = document.getElementById("report3_date_end").value;
    if (x1>=x2)
    {
        alert( " Sorry, wrong date entered" );
    }
}

function dateVeryfy4()
{
    var x1 = document.getElementById("report4_date_begin").value;
    var x2 = document.getElementById("report4_date_end").value;
    if (x1>=x2)
    {
        alert( " Sorry, wrong date entered" );
    }
}


function dateVeryfy6()
{
    var x1 = document.getElementById("report6_date_begin").value;
    var x2 = document.getElementById("report6_date_end").value;
    if (x1>=x2)
    {
        alert( " Sorry, wrong date entered" );

    }
}

function dateVeryfy7()
{
    var x1 = document.getElementById("report7_date_begin").value;
    var x2 = document.getElementById("report7_date_end").value;
    if (x1>=x2)
    {
        alert( " Sorry, wrong date entered" );
    }
}

