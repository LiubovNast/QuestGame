<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Magic School</title>
    <style>
        <%@include file="../../static/css/letter.css" %>
    </style>
</head>
<body>
<h2>Hello there, you have received a letter</h2>
<h4>Do you want to open it?</h4>
<form name="create" id="create" action="/" method="post">
    <label for="name"> write your name and plunge into <i>the world of magic and fairy tales</i>.
    </label><br>
    <input type="text" id="name" name="name" maxlength="30" minlength="3" required><br>
    <br>
    <button type="submit" id="yes" value="Open letter"> Open letter</button>
    <button type="reset" id="no" onclick="window.location='/end'">
        NO, I don't
    </button>
</form>
</body>
</html>
