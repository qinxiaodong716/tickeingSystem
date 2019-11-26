<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>售票员--搜索</title>

</head>
<body>

<form action="inquireflight" method="post">
    <table class="qxd_carousel_control_right_button_con" style="width: 1280px">
        <tr>
            <td>出发城市</td>
            <td>到达城市</td>
            <td>出发时间</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <input type="text" size="30" name="fromCity" style="height:40px">
            </td>
            <td>
                <input type="text" size="30" name="toCity" style="height:40px">
            </td>
            <td>
                <input type="text" size="30" name="startDate" style="height:40px" >
            </td>
            <td></td>
            <td><input type="submit" value="搜素" style="height:40px;width: 120px"></td>
        </tr>
    </table>
</form>
<div class="main"></div>

</body>
</html>
