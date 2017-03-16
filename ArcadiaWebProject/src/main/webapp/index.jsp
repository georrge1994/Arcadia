<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get My Track!</title>
</head>
<body>
${textA}

<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    <input type="text" name="description" />
    <input type="file" name="file" />
    <input type="submit" />
</form>
${textC}
<!--<img src='<%=request.getParameter("image")%>'>-->
<img src=${textB}>
<!--<form action="${pageContext.request.contextPath}/s" method="post">
    <input type="submit" name="button1" value="Button 1" />
    <input type="submit" name="button2" value="Button 2" />
    <input type="submit" name="button3" value="Button 3" />
</form>-->
</body>
</html>