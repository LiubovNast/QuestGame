<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="../../static/css/letter.css"%></style>
</head>
<body>
<h4>Ok, let's start our quest!!</h4>
<form name="quest" id="quest" action="/quest" method="post">
    <label><%=request.getSession().getAttribute("question")%></label>
    <br>
    <%
        List<String> list = (List<String>) request.getSession().getAttribute("variants");
        for (String variant : list) {
    %>
    <input type="radio" name="answer" value="<%=variant%>"><%=variant%><br>
    <%
        }
    %>

    <button type="submit" id="yes"> Ok </button>
    <button type="reset" id="no" onclick="window.location='/end'">
        NO, I don't know
    </button>
</form>
</body>
</html>
