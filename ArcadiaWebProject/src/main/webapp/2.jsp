<html>
<link href="CSS/style.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" href="favicons.png">
<head>
    <title>Report Designer</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.js"></script>

</head>
<body>

<div class="tabHeadtext"> Report Designer
    <div class="rightpic"> <img src="img/logo.png" width="196" height="53" alt=""/> </div>
</div>

<div class="tab">
    <div class="container">
        <div class="btn-group btn-group-justified">
            <a href="1.jsp" class="btn btn-primary tablinks"  >Period</a>
            <a href="2.jsp" class="btn btn-primary tablinks"  > Course </a>
            <a href="3.jsp" class="btn btn-primary tablinks"  > Users Rating </a>
            <a href="4.jsp" class="btn btn-primary tablinks" > Group Rating </a>
            <a href="5.jsp" class="btn btn-primary tablinks"> Courses Tests </a>
            <a href="E.jsp" class="btn btn-primary tablinks"> Empty </a>
            <div class="btn-group">
                <button type="button" data-toggle="dropdown" class="btn btn-primary dropdown-toggle"> More <span class="caret"></span> </button>
                <!-- Выпадающее меню -->
                <ul class="dropdown-menu">
                    <!-- Пункты меню -->

                    <li> <a href="1.jsp"    >Period </a> </li>
                    <li> <a href="2.jsp" >Course </a> </li>
                    <li> <a href="3.jsp" >Users Rating </a> </li>
                    <li> <a href="4.jsp" >Group Rating </a> </li>
                    <li> <a href="5.jsp" >Courses Tests </a> </li>
                    <li> <a href="E.jsp" >Empty </a> </li>
                    <li> <a href="6.jsp"  >Report 6 </a> </li>
                    <li> <a href="7.jsp"  >Report 7 </a> </li>
                </ul>
            </div>
        </div>
    </div>
</div>







<div >
            <span class="design-block">
              <div class="center">
                <h2> Course</h2>
                <h3>Select the report components:</h3>
              </div>
              <p>Number of students who have registered for the selected period for the course:</p>
              <p> Date Range:</p>
              <form name="report2_form" method="get" action="http://localhost:8080/report_2">
                <div>
                  <h5>Date1</h5>
                </div>
                <div class="black">
                  <input type="date" name="report2_date_begin" id="report2_date_begin">
                </div>
                <div>
                  <h5>Date2</h5>
                </div>
                <div class="black">
                  <input type="date" name="report2_date_end"  id="report2_date_end">
                </div>
                <div>
                  <h5>Course:</h5>
                </div>
                <div class="black">
                  <select name="report2_select_Course">
                    <option>Course 1</option>
                    <option>Course 2</option>
                    <option>Course 3</option>
                    <option>Course 4</option>
                  </select>
                </div>
                <div>
                  <h5>What kind of file should be formed?</h5>
                </div>
                <div class="flipswitch">
                  <input type="checkbox" name="report2_switch_pdf_or_xml" class="flipswitch-cb" id="fs2" checked>
                  <label class="flipswitch-label" for="fs2">
                  <div class="flipswitch-inner"></div>
                  <div class="flipswitch-switch"></div>
                  </label>
                </div>
                  <input type="text" name="index_report" style="display: none;" value="2">
                <div class="center">
                  <button onclick="dateVeryfy2()" class="button" style="vertical-align:middle"
                          name="report2_button_send"> <span>SEND</span> </button>
                </div>
              </form>
          </span>
    <span class="view-block">
              <h3> Example of report </h3>
              <div class="center" id="imgs2">


                <p> <img class="gallery" src="img/report2_pdf.png"/>
                    <img class="gallery" src="img/report2_xml.png" /></p>
              </div>
            </span></div>

</body>

<script type="text/javascript" src="js/gallery.js"></script>
<script type="text/javascript" src="js/date.js"></script>
</html>