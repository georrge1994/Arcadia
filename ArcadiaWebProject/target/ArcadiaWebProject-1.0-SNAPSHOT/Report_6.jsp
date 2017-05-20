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
            <a href="ReportRegisterStudents.jsp" class="btn btn-primary tablinks"  >Period</a>
            <a href="Report_2.jsp" class="btn btn-primary tablinks"  > Course </a>
            <a href="Report_3.jsp" class="btn btn-primary tablinks"  > Users Rating </a>
            <a href="Report_4.jsp" class="btn btn-primary tablinks" > Group Rating </a>
            <a href="Report_5.jsp" class="btn btn-primary tablinks"> Courses Tests </a>
            <a href="Report_E.jsp" class="btn btn-primary tablinks"> Empty </a>
            <div class="btn-group">
                <button type="button" data-toggle="dropdown" class="btn btn-primary dropdown-toggle"> More <span class="caret"></span> </button>
                <!-- Выпадающее меню -->
                <ul class="dropdown-menu">
                    <!-- Пункты меню -->

                    <li> <a href="ReportRegisterStudents.jsp"    >Period </a> </li>
                    <li> <a href="Report_2.jsp" >Course </a> </li>
                    <li> <a href="Report_3.jsp" >Users Rating </a> </li>
                    <li> <a href="Report_4.jsp" >Group Rating </a> </li>
                    <li> <a href="Report_5.jsp" >Courses Tests </a> </li>
                    <li> <a href="Report_E.jsp" >Empty </a> </li>
                    <li> <a href="Report_6.jsp"  >Report 6 </a> </li>
                    <li> <a href="Report_7.jsp"  >Report 7 </a> </li>
                </ul>
            </div>
        </div>
    </div>
</div>


<div >
            <span class="design-block">
            <div class="center">
              <h2> Report 6 </h2>
                <!--   <h3>Select the report components:</h3> -->
              </div>
                <form name="report6_form">
               <!--     <div>
                      <h5>Group:</h5>
                    </div>
                    <div class="black">
                      <select name="report6_select_group">
                        <option>Group 1</option>
                        <option>Group 2</option>
                        <option>Group 3</option>
                        <option>Group 4</option>
                      </select>
                    </div>
                    <div>
                      <h5>Course:</h5>
                    </div>
                    <div class="black">
                      <select name="report6_select_Course">
                        <option>Course 1</option>
                        <option>Course 2</option>
                        <option>Course 3</option>
                        <option>Course 4</option>
                      </select>
                    </div>
                    <div>
                      <h5>Test:</h5>
                    </div>
                    <div class="black">
                      <select name="report6_select_Test">
                        <option>Test 1</option>
                        <option>Test 2</option>
                        <option>Test 3</option>
                        <option>Test 4</option>
                      </select>
                    </div>
                    <div>
                      <p> Date Range:</p>
                    </div>
                    <div>
                      <h5>Date1</h5>
                    </div>
                    <div class="black">
                      <input type="date" name="report6_date_begin" id="report6_date_begin">
                    </div>
                    <div>
                      <h5>Date2</h5>
                    </div>
                    <div class="black">
                      <input type="date" name="report6_date_end" id="report6_date_end">
                    </div>
                    <div>
                      <h5>Rating:</h5>
                    </div>
                    <div class="black">
                      <select name="report6_select_raiting">
                        <option>10</option>
                        <option>20</option>
                        <option>30</option>
                        <option>40</option>
                      </select>
                    </div> -->
                    <div>
                      <h5>What kind of file should be formed?</h5>
                    </div>
                    <div class="flipswitch">
                      <input type="checkbox" name="report6_switch_pdf_or_xml" class="flipswitch-cb" id="fs6" checked>
                      <label class="flipswitch-label" for="fs6">
                      <div class="flipswitch-inner"></div>
                      <div class="flipswitch-switch"></div>
                      </label>
                    </div>
                    <div class="center">
                      <button  onclick="dateVeryfy6()" class="button" style="vertical-align:middle" name="report6_button_send" > <span>SEND</span> </button>
                    </div>
                </form>
            </span>
    <span class="view-block">

              <h3> Sample report </h3>
                <div class="center">
                <!--     <p> <img src="img/report1_pdf.png" width="554" height="788" alt=""/> </p>-->
                </div>

            </span>
</div>





</body>

<script type="text/javascript" src="js/gallery.js"></script>
<script type="text/javascript" src="js/date.js"></script>
</html>