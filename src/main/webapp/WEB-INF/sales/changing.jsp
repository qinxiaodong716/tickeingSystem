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

<form action="gaiqian" method="post" target="gaiqian">
    <table class="qxd_carousel_control_right_button_con" style="width: 1280px">
        <tr>
            <td>订单号</td>
            <td>乘客姓名</td>
            <td>机票编号</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <input type="text" size="30" name="orderId" style="height:40px">
            </td>
            <td>
                <input type="text" size="30" name="passengerName" style="height:40px">
            </td>
            <td>
                <input type="text" size="30" name="ticketOrderId" style="height:40px" >
            </td>
            <td></td>
            <td><input type="submit" value="搜素" style="height:40px;width: 120px"></td>
        </tr>
    </table>
</form>
<div class="main"></div>
<iframe name="gaiqian" style="width: 95%;height: 85%;border: 1px solid #e6e6e6"></iframe>
</body>
</html>
