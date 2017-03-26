<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="CSS\style.css" rel="stylesheet">
    <title>Designer</title>
</head>


<body>

<form id="form1" name="form1" method="post">

    <table width="872" align="center">

        <tr>
            <td colspan="7" >

                <h2 align="center">Report Designer</h2>
                <p>Select the report components:</p></td>
        </tr>
        <tr>
            <td colspan="7">      Number of students who have registered for a period of time:</td>
        </tr>
        <tr>
            <td width="21"><input type="radio" name="Rgr" value="переключатель" id="Rgr_0"></td>
            <td width="145">Date Range: </td>
            <td width="145">&nbsp;</td>
            <td colspan="4" rowspan="2">&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><label for="date"></label>      <input type="date" name="date" id="date"></td>
            <td><input type="date" name="date2" id="date2"></td>
        </tr>
        <tr>
            <td colspan="7">      Number of students who have registered for the selected period for the course:</td>
        </tr>
        <tr>
            <td><input type="radio" name="Rgr" value="переключатель" id="Rgr_1"></td>
            <td>Date Range:</td>
            <td>&nbsp;</td>
            <td width="145"><label for="select">Course:</label></td>
            <td colspan="3" rowspan="2">&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><input type="date" name="date3" id="date3"></td>
            <td><input type="date" name="date4" id="date4"></td>
            <td><select name="select" id="select">
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
            <td><input type="radio" name="Rgr"  id="Rgr_2"></td>
            <td>Date Range: </td>
            <td>&nbsp;</td>
            <td>Group:</td>
            <td width="145">Students Rating:</td>
            <td colspan="2" rowspan="2">&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><input type="date" name="date5" id="date5"></td>
            <td><input type="date" name="date6" id="date6"></td>
            <td><select name="select2" id="select2">
                <option>Group 1</option>
                <option>Group 2</option>
                <option>Group 3</option>
                <option>Group 4</option>
            </select></td>
            <td><select name="select3" id="select3">
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
            <td><input type="radio" name="Rgr" value="переключатель" id="Rgr_3"></td>
            <td>Course:</td>
            <td>Date Range: </td>
            <td>&nbsp;</td>
            <td>Rating:</td>
            <td colspan="2" rowspan="2">&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><select name="select4" id="select4">
                <option>Course 1</option>
                <option>Course 2</option>
                <option>Course 3</option>
                <option>Course 4</option>
            </select></td>
            <td><input type="date" name="date7" id="date7"></td>
            <td><input type="date" name="date8" id="date8"></td>
            <td><select name="select5" id="select5">
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
            <td><input type="radio" name="Rgr" value="переключатель" id="Rgr_4"></td>
            <td>Course:</td>
            <td colspan="5" rowspan="2">&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><select name="select6" id="select6">
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
            <td><input type="radio" name="Rgr" value="переключатель" id="Rgr_5"></td>
            <td>Group:</td>
            <td>Course:</td>
            <td><label for="select26">Test:</label></td>
            <td>Date Range: </td>
            <td width="145">&nbsp;</td>
            <td width="94"><label for="select27">Rating:</label></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><select name="select7" id="select7">
                <option>Group 1</option>
                <option>Group 2</option>
                <option>Group 3</option>
                <option>Group 4</option>
            </select></td>
            <td><select name="select8" id="select8">
                <option>Course 1</option>
                <option>Course 2</option>
                <option>Course 3</option>
                <option>Course 4</option>
            </select></td>
            <td><select name="select9" id="select9">
                <option>Test 1</option>
                <option>Test 2</option>
                <option>Test 3</option>
                <option>Test 4</option>
            </select></td>
            <td><input type="date" name="date9" id="date9"></td>
            <td>
                <input type="date" name="date10" id="date10"></td>
            <td><select name="select13" id="select12">
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
            <td><input type="radio" name="Rgr" value="переключатель" id="Rgr_6"></td>
            <td><label for="select28">Group:</label></td>
            <td>Course:</td>
            <td><label for="date3">Date Range:</label></td>
            <td>&nbsp;</td>
            <td>Rating:</td>
            <td><label for="select30">Students:</label></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><select name="select12" id="select11">
                <option>Group 1</option>
                <option>Group 2</option>
                <option>Group 3</option>
                <option>Group 4</option>
            </select></td>
            <td><select name="select11" id="select10">
                <option>Course 1</option>
                <option>Course 2</option>
                <option>Course 3</option>
                <option>Course 4</option>
            </select></td>
            <td><input type="date" name="date11" id="date9"></td>
            <td>
                <input type="date" name="date12" id="date10"></td>
            <td><select name="select10" id="select9">
                <option>10</option>
                <option>20</option>
                <option>30</option>
                <option>40</option>
            </select></td>
            <td><select name="select13" id="select13">
                <option>Student 1</option>
                <option>Student 2</option>
                <option>Student 3</option>
                <option>Student 4</option>
            </select></td>
        </tr>
        <tr>
            <td colspan="7" >


                <input name="submit"  type="submit" class="sendsubmit" id="submit" value="Send" >





            </td>
        </tr>
    </table>

</form>
</body>




</html>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        var form = $('#design_form');       // contact form
        var submit = $('#submit');          // submit button

        // form submit event
        form.on('submit', function(e) {
            e.preventDefault();

            $.ajax({
                url: 'controller',
                type: 'POST',
                dataType: 'html',
                data: form.serialize(),
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
</script>