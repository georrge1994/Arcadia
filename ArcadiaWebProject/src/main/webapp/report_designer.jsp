
<html>
<head>
    <title>Report Designer</title>
    <link rel="shortcut icon" href="favicons.png">
    <link href="CSS/style.css" rel="stylesheet" type="text/css">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

<div class="tabHeadtext">

    Report Designer

    <div class="rightpic">

        <img src="img/logo.png" width="196" height="53" alt=""/>

    </div>

</div>



<div class="tab">

    <div class="container">


        <div class="btn-group btn-group-justified">
            <a href="#" class="btn btn-primary tablinks" onclick="openCity(event, 'R1')" id="defaultOpen" >Report1</a>
            <a href="#" class="btn btn-primary tablinks"onclick="openCity(event, 'R2')" >Report2</a>
            <a href="#" class="btn btn-primary tablinks"onclick="openCity(event, 'R3')" >Report3</a>
            <a href="#" class="btn btn-primary tablinks"onclick="openCity(event, 'R4')">Report4</a>
            <a href="#" class="btn btn-primary tablinks"onclick="openCity(event, 'R5')">Report5</a>
            <a href="#" class="btn btn-primary tablinks"onclick="openCity(event, 'R6')">Report6</a>
            <a href="#" class="btn btn-primary tablinks"onclick="openCity(event, 'R7')">Report7</a>

        </div>
    </div>



</div>

<div id="R1" class="tabcontent">
 <span class="desbl">

  <h3>Select the report components:</h3>
  <p>Number of students who have registered for a period of time:</p>
	<p> Date Range:</p>
<form name="rep1_form">
<div>
    <label for="date1" name="rep1_label_dade1">Date1</label>
  </div>
<div class="black_betty">
	<input type="date" name="rep1_date_begin" >

</div>

<div>
    <label for="date2" name="rep1_label_dade2">Date2</label>
  </div>

<div class="black_betty">
	<input type="date" name="rep1_date_end">

</div>
<div>
<button class="button" style="vertical-align:middle" name="report1_button_send"><span>SEND</span></button>
	</div>
	</form>
</span>

    <span class="vevblock"  >

	<div class="CentrGeorg" >
	<h3 > Example of report </h3>
	</div>


	<div class="CentrGeorg" > <img src="img/rep_expl.png" width="221" height="315" alt=""/>
	</div>
	<div class="CentrGeorg">

	 <button class="button" style="vertical-align:middle" name="report1_button_PDF"><span>PDF</span></button>
	 <button class="button" style="vertical-align:middle" name="report1_button_XML"><span>XML</span></button>

   </div>

  </span>






</div>




<div id="R2" class="tabcontent">
    <h3>Sorry... =) Page2 in development</h3>
</div>

<div id="R3" class="tabcontent">
    <h3>Sorry... =) Page3 in development</h3>
</div>
<div id="R4" class="tabcontent">
    <h3>Sorry... =) Page4 in development</h3>
</div>

<div id="R5" class="tabcontent">
    <h3>Sorry... =) Page5 in development</h3>
</div>
<div id="R6" class="tabcontent">
    <h3>Sorry... =) Page6 in development</h3>
</div>

<div id="R7" class="tabcontent">
    <h3>A ti ja smotry nastirnij !!!! :D</h3>
</div>



<script>
    function openCity(evt, cityName) {
        var i, tabcontent, tablinks;
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++) {
            tabcontent[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablinks");
        for (i = 0; i < tablinks.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" active", "");
        }
        document.getElementById(cityName).style.display = "block";
        evt.currentTarget.className += " active";
    }

    // Get the element with id="defaultOpen" and click on it
    document.getElementById("defaultOpen").click();
</script>

</body>
</html>



<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="js/report-designer.js"></script>