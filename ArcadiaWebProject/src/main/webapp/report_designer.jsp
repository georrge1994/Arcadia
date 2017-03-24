<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="CSS\style.css" rel="stylesheet">
    <title>Designer</title>
</head>
<body>
    <form id="design_form" action="" method="post">
        <input type="text" name="name" />
        <input type="mail" name="email" />
        <input type="text" name="subject" />
        <textarea name="message"></textarea>
        <input id="submit" type="submit" value="Отправить">
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