<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="CSS\style.css" rel="stylesheet">
    <title>Designer</title>
</head>


<body>


<form id="form1" name="form1" method="post">

    <table width="70%" align="center">

        <tr>
            <td colspan="7" >

                <h2 align="center">Дизайнер  отчетов
                </h2>
                <p>Выберите компоненты для отчета: </p></td>
        </tr>
        <tr>
            <td colspan="7">Кол-во студентов, зарегистрировавшихся за выбранный  период:</td>
        </tr>
        <tr>
            <td width="8%"><input type="radio" name="Rgr" value="переключатель" id="Rgr_0"></td>
            <td colspan="4"><label for="date"></label>
                С
                <input type="date" name="date" id="date"></td>
            <td colspan="2">По
                <input type="date" name="date2" id="date2"></td>
        </tr>
        <tr>
            <td colspan="7">Кол-во студентов, зарегистрировавшихся за выбранный  периодна курс:</td>
        </tr>
        <tr>
            <td><label>
                <input type="radio" name="Rgr" value="переключатель" id="Rgr_1">
            </label></td>
            <td colspan="3"><label for="date3">С:</label>
                <input type="date" name="date3" id="date3"></td>
            <td><label for="date4">По:</label>
                <input type="date" name="date4" id="date4"></td>
            <td colspan="2"><label for="select">Выбор  курса:</label>
                <select name="select" id="select">
                    <option>Course 1</option>
                    <option>Course 2</option>
                    <option>Course 3</option>
                    <option>Course 4</option>
                </select></td>
        </tr>
        <tr>
            <td colspan="7">Рейтинг студентов:</td>
        </tr>
        <tr>
            <td><label>
                <input type="radio" name="Rgr" value="переключатель" id="Rgr_2">
            </label></td>
            <td colspan="2"><label for="date5">С:</label>
                <input type="date" name="date5" id="date5"></td>
            <td><label for="date6">По:</label>
                <input type="date" name="date6" id="date6"></td>
            <td><label for="select2">Выбор  группы:</label>
                <select name="select2" id="select2">
                    <option>Group 1</option>
                    <option>Group 2</option>
                    <option>Group 3</option>
                    <option>Group 4</option>
                </select></td>
            <td colspan="2"><label for="select3">Студенты  с рейтингом не ниже ...<br>
                Выбор  рейтинга:</label>
                <select name="select3" id="select3">
                    <option>10</option>
                    <option>20</option>
                    <option>30</option>
                    <option>40</option>
                </select></td>
        </tr>
        <tr>
            <td colspan="7">Рейтинг групп:</td>
        </tr>
        <tr>
            <td><label>
                <input type="radio" name="Rgr" value="переключатель" id="Rgr_3">
            </label></td>
            <td colspan="2"><label for="select4">Выбор  курса:</label>
                <select name="select4" id="select4">
                    <option>Course 1</option>
                    <option>Course 2</option>
                    <option>Course 3</option>
                    <option>Course 4</option>
                </select></td>
            <td><label for="date7">С:</label>
                <input type="date" name="date7" id="date7"></td>
            <td><label for="date8">По:</label>
                <input type="date" name="date8" id="date8"></td>
            <td colspan="2"><label for="select5">Рейтинг :</label>
                <select name="select5" id="select5">
                    <option>10</option>
                    <option>20</option>
                    <option>30</option>
                    <option>40</option>
                </select></td>
        </tr>
        <tr>
            <td colspan="7">Количество тестов в курсе:</td>
        </tr>
        <tr>
            <td><label>
                <input type="radio" name="Rgr" value="переключатель" id="Rgr_4">
            </label></td>
            <td colspan="6"><label for="select6">Выбор  курса:</label>
                <select name="select6" id="select6">
                    <option>Course 1</option>
                    <option>Course 2</option>
                    <option>Course 3</option>
                    <option>Course 4</option>
                </select></td>
        </tr>
        <tr>
            <td colspan="7">Количество тестов в курсе:</td>
        </tr>
        <tr>
            <td><input type="radio" name="Rgr" value="переключатель" id="Rgr_5"></td>
            <td><label for="select7">Выбор  группы:</label>
                <select name="select7" id="select7">
                    <option>Group 1</option>
                    <option>Group 2</option>
                    <option>Group 3</option>
                    <option>Group 4</option>
                </select></td>
            <td><label for="select8">Выбор  курса:</label>
                <select name="select8" id="select8">
                    <option>Course 1</option>
                    <option>Course 2</option>
                    <option>Course 3</option>
                    <option>Course 4</option>
                </select></td>
            <td><label for="select9">Выбор  теста:</label>
                <select name="select9" id="select9">
                    <option>Test 1</option>
                    <option>Test 2</option>
                    <option>Test 3</option>
                    <option>Test 4</option>
                </select></td>
            <td><label for="date9">С:</label>
                <input type="date" name="date9" id="date9"></td>
            <td><label for="date10">По:</label>
                <input type="date" name="date10" id="date10"></td>
            <td><label for="select12">Рейтинг :</label>
                <select name="select13" id="select12">
                    <option>10</option>
                    <option>20</option>
                    <option>30</option>
                    <option>40</option>
                </select></td>
        </tr>
        <tr>
            <td colspan="7">Количество тестов в курсе:</td>
        </tr>
        <tr>
            <td><input type="radio" name="Rgr" value="переключатель" id="Rgr_6"></td>
            <td><label for="select11">Выбор  группы:</label>
                <select name="select12" id="select11">
                    <option>Group 1</option>
                    <option>Group 2</option>
                    <option>Group 3</option>
                    <option>Group 4</option>
                </select></td>
            <td><label for="select10">Выбор  курса:</label>
                <select name="select11" id="select10">
                    <option>Course 1</option>
                    <option>Course 2</option>
                    <option>Course 3</option>
                    <option>Course 4</option>
                </select></td>
            <td><label for="date9">С:</label>
                <input type="date" name="date11" id="date9"></td>
            <td><label for="date10">По:</label>
                <input type="date" name="date12" id="date10"></td>
            <td><label for="select9">Рейтинг :</label>
                <select name="select10" id="select9">
                    <option>10</option>
                    <option>20</option>
                    <option>30</option>
                    <option>40</option>
                </select></td>
            <td><label for="select13">Студенты:</label>
                <select name="select13" id="select13">
                    <option>Student 1</option>
                    <option>Student 2</option>
                    <option>Student 3</option>
                    <option>Student 4</option>
                </select></td>
        </tr>
        <tr>
            <td colspan="7"><input type="submit" name="submit" id="submit" value="Отправить"></td>
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