
<html>
<link href="CSS/style.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" href="favicons.png">
<link href="CSS/bootstrap.min.css" rel="stylesheet" media="screen">

  <link href="CSS/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
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







<div>
            <span class="design-block">
                <div class="center">
                    <h2>Period</h2>
                    <h3>Select the report components:</h3>
                </div>
                <p>Number of students who have registered for a period of time:</p>
                <p> Date Range:</p>
                <form name="report1_form" id="report1_form" method="get">
				<!-- method="get" action="http://localhost:8080/report_1" -->
                    <div>
                        <h5>Date1</h5>
                    </div>
                    <div  class="black">
              <div class="controls input-append date form_date" data-date="" data-date-format="dd.mm.yy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                    <input size="16" type="text" name="report1_date_begin" id="report1_date_begin" value="" readonly>
                    <span class="add-on"><i class="icon-remove"></i></span>
					<span class="add-on"><i class="icon-th"></i></span>
                </div>
				<input type="hidden" id="dtp_input2" value="" /><br/>
				
                    </div>
					
		
                    <div>
                        <h5>Date2</h5>
                    </div>
                    <div class="black">				
					 <div class="controls input-append date form_date" data-date="" data-date-format="dd.mm.yy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                    <input size="16" type="text"  name="report1_date_end" id="report1_date_end" value="" readonly>
                    <span class="add-on"><i class="icon-remove"></i></span>
					<span class="add-on"><i class="icon-th"></i></span>
                </div>
				<input type="hidden" id="dtp_input2" value="" /><br/>
                     
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
                          <button type="send" onclick="dverify()" class="button" style="vertical-align:middle" name="report1_button_send" id="report1_button_send">
                              <span>SEND</span> </button>
                    </div>
                </form>
            </span>
    <span class="view-block">
              <h3> Sample report </h3>
              <div class="center" id="imgs">
                <p>

                    <img class="gallery" src="img/report1_pdf.png"  alt=""/>
                    <img class="gallery" src="img/report1_xml.png"  alt=""/>
                </p>
              </div>
            </span></div>

</body>

<script type="text/javascript" src="js/gallery.js"></script>
<script type="text/javascript" src="js/date.js"></script>
<script > 
function dverify(){
if (dateVeryfy(document.getElementById("report1_date_begin").value,document.getElementById("report1_date_end").value)==1)
{
	document.getElementById("report1_form").action="http://localhost:8080/report_1";
}
}
</script>
<script > 
					var now = new Date();
					
					document.getElementById("report1_date_begin").value=formatDate(now);
					document.getElementById("report1_date_end").value=formatDate(now);
					
				</script>
	
<script type="text/javascript" src="js/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="sample in bootstrap v2/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
<script type="text/javascript">
   
	$('.form_date').datetimepicker({
        language:  'en',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
    });
	
</script>
</html>