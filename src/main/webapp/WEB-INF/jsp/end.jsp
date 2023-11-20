<%@ page import="java.util.List" %>
<%@ page import="com.nastoiashcha.database.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>The end...</title>
    <style>
        <%@include file="../../static/css/letter.css" %>
    </style>
</head>
<body style="background-color: <%=request.getSession().getAttribute("color")%>">
<h2 style="color: <%=request.getSession().getAttribute("text")%>"><%=request.getSession().getAttribute("message")%>
</h2>
<h3>Table of results</h3>
<table>
    <tr>
        <th> Name</th>
        <th> Score</th>
        <th> Info</th>
    </tr>
    <%
        List<User> list = (List<User>) request.getSession().getAttribute("list");
        for (User user : list) {
    %>
    <tr>
        <td><%=user.getName()%>
        </td>
        <td><%=user.getScore()%>
        </td>
        <td><%=user.getInfo()%>
        </td>
    </tr>
    <%
        }
    %>
</table>
<p>Do you want restart game?</p>
<%session.invalidate();%>
<button id="yes" onclick="window.location='/'">Restart</button>
</body>
</html>
