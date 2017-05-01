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
            <a href="#" class="btn btn-primary tablinks" onclick="openRep(event, 'R1')" id="defaultOpen" >Period</a>
            <a href="#" class="btn btn-primary tablinks" onclick="openRep(event, 'R2')" > Course </a>
            <a href="#" class="btn btn-primary tablinks" onclick="openRep(event, 'R3')" > Users Rating </a>
            <a href="#" class="btn btn-primary tablinks" onclick="openRep(event, 'R4')"> Group Rating </a>
            <a href="#" class="btn btn-primary tablinks" onclick="openRep(event, 'R5')"> Courses Tests </a>
            <a href="#" class="btn btn-primary tablinks" > Empty </a>
            <div class="btn-group">
                <button type="button" data-toggle="dropdown" class="btn btn-primary dropdown-toggle"> More <span class="caret"></span> </button>
                <!-- Выпадающее меню -->
                <ul class="dropdown-menu">
                    <!-- Пункты меню -->

                    <li> <a href="#"  onclick="openRep(event, 'R1')"  >Period </a> </li>
                    <li> <a href="#" onclick="openRep(event, 'R2')" >Course </a> </li>
                    <li> <a href="#" onclick="openRep(event, 'R3')" >Users Rating </a> </li>
                    <li> <a href="#" onclick="openRep(event, 'R4')">Group Rating </a> </li>
                    <li> <a href="#" onclick="openRep(event, 'R5')">Courses Tests </a> </li>
                    <li> <a href="#"  onclick="openRep(event, 'R6')">Report 6 </a> </li>
                    <li> <a href="#"  onclick="openRep(event, 'R7')">Report 7 </a> </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<div id="R1" class="tabcontent">
            <span class="design-block">
                <div class="center">
                    <h3>Select the report components:</h3>
                </div>
                <p>Number of students who have registered for a period of time:</p>
                <p> Date Range:</p>
                <form name="report1_form" method="get" action="http://localhost:8080/report_1">
                    <div>
                        <h5>Date1</h5>
                    </div>
                    <div class="black_betty">
                        <input type="date" name="report1_date_begin" id="report1_date_begin">
                    </div>
                    <div>
                        <h5>Date2</h5>
                    </div>
                    <div class="black_betty">
                        <input type="date" name="report1_date_end" id="report1_date_end">
                    </div>
                    <div>
                        <h5>What kind of file should be formed?</h5>
                    </div>
                    <div class="flipswitch">
                        <input type="checkbox" name="report1_switch_pdf_or_xml" class="flipswitch-cb" id="fs1" checked>
                        <label class="flipswitch-label" for="fs1">
                            <div class="flipswitch-inner"></div>
                            <div class="flipswitch-switch"></div>
                        </label>
                    </div>
                    <input type="text" name="index_report" style="display: none;" value="1">
                    <div class="center">
                          <button type="send" onmouseover="dateVeryfy()" class="button" style="vertical-align:middle" name="report1_button_send" id="report1_button_send">
                              <span>SEND</span> </button>
                    </div>
                </form>
            </span>
    <span class="view-block">
              <h3> Example of report </h3>
              <div class="center" id="imgs">
                <p>

                    <img src="img/report1_pdf.png" width="85%" height="150%" alt=""/>
                    <img src="img/report1_xml.png" width="85%" height="150%" alt=""/>
                </p>
              </div>
            </span></div>
<div id="R2" class="tabcontent">
            <span class="design-block">
              <div class="center">
                <h3>Select the report components:</h3>
              </div>
              <p>Number of students who have registered for the selected period for the course:</p>
              <p> Date Range:</p>
              <form name="report2_form" method="get" action="http://localhost:8080/report_2">
                <div>
                  <h5>Date1</h5>
                </div>
                <div class="black_betty">
                  <input type="date" name="report2_date_begin" id="report2_date_begin">
                </div>
                <div>
                  <h5>Date2</h5>
                </div>
                <div class="black_betty">
                  <input type="date" name="report2_date_end"  id="report2_date_end">
                </div>
                <div>
                  <h5>Course:</h5>
                </div>
                <div class="black_betty">
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
                  <button onmouseover="dateVeryfy2()" class="button" style="vertical-align:middle"
                          name="report2_button_send"> <span>SEND</span> </button>
                </div>
              </form>
          </span>
    <span class="view-block">
              <h3> Example of report </h3>
              <div class="center" id="imgs2">


                <p> <img src="img/report2_pdf.png" width="85%" height="150%" alt=""/>
                    <img src="img/report2_xml.png" width="85%" height="150%" alt=""/></p>
              </div>
            </span></div>
<div id="R3" class="tabcontent">
            <span class="design-block">
              <div class="center">
                <h3>Select the report components:</h3>
              </div>
              <p>Students Rating:</p>
              <p> Date Range:</p>
              <form name="report3_form" method="get" action="http://localhost:8080/report_3">
                <div>
                  <h5>Date1</h5>
                </div>
                <div class="black_betty">
                  <input type="date" name="report3_date_begin" id="report3_date_begin">
                </div>
                <div>
                  <h5>Date2</h5>
                </div>
                <div class="black_betty">
                  <input type="date" name="report3_date_end" id="report3_date_end">
                </div>
                <div>
                  <h5>Group:</h5>
                </div>
                <div class="black_betty">
                  <select name="report3_select_group">
                    <option>Group 1</option>
                    <option>Group 2</option>
                    <option>Group 3</option>
                    <option>Group 4</option>
                  </select>
                </div>
                <div>
                  <h5>Students Rating:</h5>
                </div>
                <div class="black_betty">
                  <select name="report3_select_raiting">
                    <option>10</option>
                    <option>20</option>
                    <option>30</option>
                    <option>40</option>
                  </select>
                </div>
                <div>
                  <h5>What kind of file should be formed?</h5>
                </div>
                <div class="flipswitch">
                  <input type="checkbox" name="report3_switch_pdf_or_xml" class="flipswitch-cb" id="fs3" checked>
                  <label class="flipswitch-label" for="fs3">
                  <div class="flipswitch-inner"></div>
                  <div class="flipswitch-switch"></div>
                  </label>
                </div>
                  <input type="text" name="index_report" style="display: none;" value="3">
                <div class="center">
                  <button onmouseover="dateVeryfy3()" class="button" style="vertical-align:middle"
                          name="report3_button_send"> <span>SEND</span> </button>
                </div>
              </form>
            </span>
    <span class="view-block">
              <h3> Example of report </h3>
              <div id="imgs3" class="center" >
                <p>
                    <img src="img/report3_pdf.png" width="85%" height="150%" alt=""/>
                    <img src="img/report3_xml.png" width="85%" height="150%" alt=""/></p>
              </div>
            </span>
</div>
<div id="R4" class="tabcontent">
            <span class="design-block">
             <!-- <div class="center">
                <h3>Select the report components:</h3>
              </div>
                  <p>Rating of groups:</p>-->
                  <form name="report4_form" method="get" action="http://localhost:8080/report_4">

                   <!-- <div>
                      <h5>Course:</h5>
                    </div>
                    <div class="black_betty">
                      <select name="report4_select_Course">
                        <option>Course 1</option>
                        <option>Course 2</option>
                        <option>Course 3</option>
                        <option>Course 4</option>
                      </select>
                    </div>
                    <p> Date Range:</p>
                    <div>
                      <h5>Date1</h5>
                    </div>
                    <div class="black_betty">
                      <input type="date" name="report4_date_begin" id="report4_date_begin">
                    </div>
                    <div>
                      <h5>Date2</h5>
                    </div>
                    <div class="black_betty">
                      <input type="date" name="report4_date_end" id="report4_date_end">
                    </div>
                    <div>
                      <h5>Rating:</h5>
                    </div>
                    <div class="black_betty">
                      <select name="report4_select_raiting" id="select4">
                        <option>10</option>
                        <option>20</option>
                        <option>30</option>
                        <option>40</option>
                      </select>
                    </div>  -->

                <div>
                  <h5>What kind of file should be formed?</h5>
                </div>
                <div class="flipswitch">
                  <input type="checkbox" name="report4_switch_pdf_or_xml" class="flipswitch-cb" id="fs4" checked>
                  <label class="flipswitch-label" for="fs4">
                  <div class="flipswitch-inner"></div>
                  <div class="flipswitch-switch"></div>
                  </label>
                </div>
                  <input type="text" name="index_report" style="display: none;" value="4">
                <div class="center">
                  <button onmouseover="dateVeryfy4()" class="button" style="vertical-align:middle"
                          name="report4_button_send"> <span>SEND</span> </button>
                </div>
              </form>
          </span>
    <span class="view-block">
              <h3> Example of report </h3>
              <div class="center" id="imgs4">
                <p> <img src="img/report4_pdf.png" width="85%" height="150%" alt=""/>
                    <img src="img/report4_xml.png" width="85%" height="150%" alt=""/> </p>
              </div>
            </span>
</div>
<div id="R5" class="tabcontent">
            <span class="design-block">
            <!--   <div class="center">
                <h3>Select the report components:</h3>
              </div>
              <p>Number of tests in the course:</p> -->
              <form name="report5_form" method="get" action="http://localhost:8080/report_5">
            <!--     <div>
                  <h5>Course:</h5>
                </div>
                <div class="black_betty">
                  <select name="report5_select_Course">
                    <option>Course 1</option>
                    <option>Course 2</option>
                    <option>Course 3</option>
                    <option>Course 4</option>
                  </select>
                </div> -->
                <div>
                  <h5>What kind of file should be formed?</h5>
                </div>
                <div class="flipswitch">
                  <input type="checkbox" name="report5_switch_pdf_or_xml" class="flipswitch-cb" id="fs5" checked>
                  <label class="flipswitch-label" for="fs5">
                      <div class="flipswitch-inner"></div>
                      <div class="flipswitch-switch"></div>
                  </label>
                </div>
                  <input type="text" name="index_report" style="display: none;" value="5">
                <div class="center">
                  <button class="button" style="vertical-align:middle"
                          name="report5_button_send"> <span>SEND</span> </button>
                </div>
              </form>
            </span>
    <span class="view-block">
              <h3> Example of report </h3>
              <div class="center" id="imgs5">
                <p> <img src="img/report5_pdf.png" width="85%" height="150%" alt=""/>
                    <img src="img/report5_xml.png" width="85%" height="150%" alt=""/> </p>
              </div>
            </span>
</div>
<div id="R6" class="tabcontent">
            <span class="design-block">
               <!--    <div class="center">
                    <h3>Select the report components:</h3>
                </div>
                <p>Number of tests in the course:</p> -->
                <form name="report6_form">
               <!--     <div>
                      <h5>Group:</h5>
                    </div>
                    <div class="black_betty">
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
                    <div class="black_betty">
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
                    <div class="black_betty">
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
                    <div class="black_betty">
                      <input type="date" name="report6_date_begin" id="report6_date_begin">
                    </div>
                    <div>
                      <h5>Date2</h5>
                    </div>
                    <div class="black_betty">
                      <input type="date" name="report6_date_end" id="report6_date_end">
                    </div>
                    <div>
                      <h5>Rating:</h5>
                    </div>
                    <div class="black_betty">
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
                      <button  onmouseover="dateVeryfy6()" class="button" style="vertical-align:middle" name="report6_button_send" > <span>SEND</span> </button>
                    </div>
                </form>
            </span>
    <span class="view-block">
                <h3> Example of report </h3>
                <div class="center">
                    <p> <img src="img/report1_pdf.png" width="554" height="788" alt=""/> </p>
                </div>
            </span>
</div>
<div id="R7" class="tabcontent">
            <span class="design-block">
           <!--     <div class="center">
                    <h3>Select the report components:</h3>
                </div>
                <p>Number of tests in the course:</p>
                <form name="report7_form">
                    <div>
                      <h5>Group:</h5>
                    </div>
                    <div class="black_betty">
                      <select name="report7_select_group">
                        <option>Group 1</option>
                        <option>Group 2</option>
                        <option>Group 3</option>
                        <option>Group 4</option>
                      </select>
                    </div>
                    <div>
                      <h5>Course:</h5>
                    </div>
                    <div class="black_betty">
                      <select name="report7_select_Course">
                        <option>Course 1</option>
                        <option>Course 2</option>
                        <option>Course 3</option>
                        <option>Course 4</option>
                      </select>
                    </div>
                    <div>
                      <p> Date Range:</p>
                    </div>
                    <div>
                      <h5>Date1</h5>
                    </div>
                    <div class="black_betty">
                      <input type="date" name="report7_date_begin" id="report7_date_begin">
                    </div>
                    <div>
                      <h5>Date2</h5>
                    </div>
                    <div class="black_betty">
                      <input type="date" name="report7_date_end" id="report7_date_end">
                    </div>
                    <div>
                      <h5>Rating:</h5>
                    </div>
                    <div class="black_betty">
                      <select name="report7_select_raiting">
                        <option>10</option>
                        <option>20</option>
                        <option>30</option>
                        <option>40</option>
                      </select>
                    </div>
                    <div>
                      <h5>Students:</h5>
                    </div>
                    <div class="black_betty">
                      <select name="report7_select_Student">
                        <option>Student 1</option>
                        <option>Student 2</option>
                        <option>Student 3</option>
                        <option>Student 4</option>
                      </select>
                    </div> -->
                    <div>
                      <h5>What kind of file should be formed?</h5>
                    </div>
                    <div class="flipswitch">
                      <input type="checkbox" name="report7_switch_pdf_or_xml" class="flipswitch-cb" id="fs7" checked>
                      <label class="flipswitch-label" for="fs7">
                      <div class="flipswitch-inner"></div>
                      <div class="flipswitch-switch"></div>
                      </label>
                    </div>
                    <div class="center">
                      <button onmouseover="dateVeryfy7()" class="button" style="vertical-align:middle" name="report7_button_send"> <span>SEND</span> </button>
                    </div>
                </form>
            </span>
    <span class="view-block">
                <h3> Example of report </h3>
                <div class="center">
                    <p> <img src="img/report1_pdf.png" width="554" height="788" alt=""/> </p>
                </div>
            </span>
</div>

<div class="design-block">

</div>
</body>



<script type="text/javascript" src="js/table.js"></script>
<script type="text/javascript" src="js/gallery.js"></script>
<script type="text/javascript" src="js/date.js"></script>
</html>


