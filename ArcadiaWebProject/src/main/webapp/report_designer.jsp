<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="CSS\style.css" rel="stylesheet">
    <title>Designer</title>
</head>
<body>
    <form id="design_form" name="design_form" method="get" action="http://localhost:8080/controller">
        <table width="872" align="center">
            <tr>
                <td colspan="7" >
                    <h2 align="center">Report Designer</h2>
                    <p>Select the report components:</p>
                </td>
            </tr>
            <tr>
                <td colspan="7">      Number of students who have registered for a period of time:</td>
            </tr>
            <tr>
                <td width="21"><input class="special-radio"  type="radio" name="select-report" value="report1" id="Rgr_0" checked></td>
                <td width="145" colspan="2">Date Range: </td>
                <td colspan="4" rowspan="2">&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input class="report1" type="date" name="date1" id="date1"></td>
                <td><input type="date" class="report1" name="date2" id="date2"></td>
            </tr>
            <tr>
                <td colspan="7">      Number of students who have registered for the selected period for the course:</td>
            </tr>
            <tr>
                <td><input class="special-radio"  type="radio" name="select-report" value="report2" id="Rgr_1"></td>
                <td colspan="2">Date Range:</td>
                <td width="145"><label for="select">Course:</label></td>
                <td colspan="3" rowspan="2">&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input class="report2" type="date" name="date3" id="date3"></td>
                <td><input class="report2" type="date" name="date4" id="date4"></td>
                <td><select class="report2" name="select" id="select">
                    <option>Course 1</option>
                    <option>Course 2</option>
                    <option>Course 3</option>
                    <option>Course 4</option>
                </select></td>
            </tr>
            <tr>
                <td colspan="7">      Students Rating:</td>
            </tr>
            <tr>
                <td><input class="special-radio" type="radio" name="select-report" value="report3" id="Rgr_2" ></td>
                <td colspan="2">Date Range: </td>
                <td>Group:</td>
                <td width="145">Students Rating:</td>
                <td colspan="2" rowspan="2">&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input class="report3" type="date" name="date5" id="date5"></td>
                <td><input class="report3" type="date" name="date6" id="date6"></td>
                <td><select class="report3" name="select2" id="select2">
                    <option>Group 1</option>
                    <option>Group 2</option>
                    <option>Group 3</option>
                    <option>Group 4</option>
                </select></td>
                <td><select class="report3" name="select3" id="select3">
                    <option>10</option>
                    <option>20</option>
                    <option>30</option>
                    <option>40</option>
                </select></td>
            </tr>
            <tr>
                <td colspan="7">      Rating of groups:</td>
            </tr>
            <tr>
                <td><input class="special-radio" type="radio" name="select-report" value="report4" id="Rgr_3"></td>
                <td>Course:</td>
                <td colspan="2">Date Range: </td>
                <td>Rating:</td>
                <td colspan="2" rowspan="2">&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><select class="report4" name="select4" id="select4">
                    <option>Course 1</option>
                    <option>Course 2</option>
                    <option>Course 3</option>
                    <option>Course 4</option>
                </select></td>
                <td><input class="report4" type="date" name="date7" id="date7"></td>
                <td><input class="report4" type="date" name="date8" id="date8"></td>
                <td><select class="report4" name="select5" id="select5">
                    <option>10</option>
                    <option>20</option>
                    <option>30</option>
                    <option>40</option>
                </select></td>
            </tr>
            <tr>
                <td colspan="7">      Number of tests in the course:</td>
            </tr>
            <tr>
                <td><input class="special-radio"  type="radio" name="select-report" value="report5" id="Rgr_4"></td>
                <td>Course:</td>
                <td colspan="5" rowspan="2">&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><select class="report5"  name="select6" id="select6">
                    <option>Course 1</option>
                    <option>Course 2</option>
                    <option>Course 3</option>
                    <option>Course 4</option>
                </select></td>
            </tr>
            <tr>
                <td colspan="7">      Number of tests in the course:</td>
            </tr>
            <tr>
                <td><input class="special-radio"  type="radio" name="select-report" value="report6" id="Rgr_5"></td>
                <td>Group:</td>
                <td>Course:</td>
                <td>Test:</td>
                <td colspan="2">Date Range: </td>
                <td width="94">Rating:</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><select class="report6" name="select7" id="select7">
                    <option>Group 1</option>
                    <option>Group 2</option>
                    <option>Group 3</option>
                    <option>Group 4</option>
                </select></td>
                <td><select class="report6" name="select8" id="select8">
                    <option>Course 1</option>
                    <option>Course 2</option>
                    <option>Course 3</option>
                    <option>Course 4</option>
                </select></td>
                <td><select class="report6" name="select9" id="select9">
                    <option>Test 1</option>
                    <option>Test 2</option>
                    <option>Test 3</option>
                    <option>Test 4</option>
                </select></td>
                <td><input class="report6" type="date" name="date9" id="date9"></td>
                <td>
                    <input class="report6" type="date" name="date10" id="date10"></td>
                <td><select class="report6" name="select13" id="select12">
                    <option>10</option>
                    <option>20</option>
                    <option>30</option>
                    <option>40</option>
                </select></td>
            </tr>
            <tr>
                <td colspan="7">      Number of tests in the course:</td>
            </tr>
            <tr>
                <td><input class="special-radio"  type="radio" name="select-report" value="report7" id="Rgr_6"></td>
                <td>Group:</td>
                <td>Course:</td>
                <td colspan="2">Date Range:</td>
                <td>Rating:</td>
                <td>Students:</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><select class="report7" name="select12" id="select11">
                    <option>Group 1</option>
                    <option>Group 2</option>
                    <option>Group 3</option>
                    <option>Group 4</option>
                </select></td>
                <td><select class="report7" name="select11" id="select10">
                    <option>Course 1</option>
                    <option>Course 2</option>
                    <option>Course 3</option>
                    <option>Course 4</option>
                </select></td>
                <td><input class="report7" type="date" name="date11" id="date11"></td>
                <td>
                    <input class="report7" type="date" name="date12" id="date12"></td>
                <td><select class="repozrt7" name="select10" id="select14">
                    <option>10</option>
                    <option>20</option>
                    <option>30</option>
                    <option>40</option>
                </select></td>
                <td><select class="report7" name="select13" id="select13">
                    <option>Student 1</option>
                    <option>Student 2</option>
                    <option>Student 3</option>
                    <option>Student 4</option>
                </select></td>
            </tr>
            <tr>
                <td colspan="7" >
                    <input name="submit"  type="submit" class="sendsubmit" id="submit_pdf" value="PDF" >
                    <input name="submit"  type="submit" class="sendsubmit" id="submit_xml" value="XML" style="background-color: brown;">
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="js/report-designer.js"></script>