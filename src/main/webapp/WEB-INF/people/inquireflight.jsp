<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>register</title>
    <link rel="stylesheet" href="/hangkong/assets/css/qxd.inquireflight.css">
</head>
<body>

<div class="qxd_in">
<form action="inquireflight" method="post" class="sousuo">
    <table>
        <tr>
            <td>出发城市</td>
            <td>
                <input type="text" size="30" name="fromCity" style="height:40px">
            </td>
            <td>到达城市</td>
            <td>
                <input type="text" size="30" name="toCity" style="height:40px">
            </td>
            <td>
                出发时间
            </td>
            <td>
                <input type="text" size="30" name="startDate" style="height:40px" >
            </td>
            <td>
                <input type="submit" value="搜素" style="height:40px;width: 60px">
            </td>
        </tr>
    </table>
</form>
<table class="hbxx">
    <tr>
        <th>序列</th>
        <th>航班号</th>
        <th>出发日期</th>
        <th>出发地机场</th>
        <th>到达的机场</th>
        <th>离港时间</th>
        <th>到港时间</th>
        <th>基本票价</th>
        <th>执行机型</th>
        <th>航程</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${acts}" var="act"  varStatus="status">
        <td>${status.index+1}</td>
        <td>${act.flightNumber}</td>
        <td>${act.startDate.toString().substring(0,10)}</td>
        <td>${act.fromAirportName}</td>
        <td>${act.toAirportName}</td>
        <td>${act.departureTime.toString().substring(10,16)}</td>
        <td>${act.arrivalTime.toString().substring(10,16)}</td>
        <td>${act.basicPrice}</td>
        <td>${act.airplane}</td>
        <%--<td>${act.basicPrice*1.6}</td>
        <td>${act.basicPrice*1.4}</td>
        <td>${act.basicPrice}</td>--%>
        <td>${act.sailLength}</td>
        <td>
        	<%
           		if("yes".equals(session.getAttribute("login"))){
            %>
           	 	<a href="buyticket/${act.flightNumber}">购买</a>
            <%}else{ %>
            	<a href="/hangkong/login" target="_parent">购买</a>
            <%} %>
        </td>
        </tr>
    </c:forEach>

</table>
</div>

</body>
</html>


