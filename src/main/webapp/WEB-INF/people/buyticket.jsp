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
    <link rel="stylesheet" href="/hangkong/assets/css/qxd.buyticket.css">
</head>
<body>
<div class="qxd_in">
    <form action="/hangkong/payment" method="post" class="sousuo">
        <table style="text-align: center">
            <tr>
                <th>航班号</th>
                <th>出发日期</th>
                <th>出发地机场</th>
                <th>到达的机场</th>
                <th>离港时间</th>
                <th>到港时间</th>
                <th>基本票价</th>
                <th>执行机型</th>
                <th>航程</th>
            </tr>
            <c:forEach items="${acts}" var="act"  varStatus="status">
                <input type="hidden" name="flightNumber" value="${act.flightNumber}">
                <input type="hidden" name="date" value="${act.startDate}">
                <input type="hidden" name="Price" value="${act.basicPrice}">
                <input type="hidden" name="startDate" value="${act.startDate}">
                <tr>
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
                </tr>
            </c:forEach>
        </table>

        <table>
            <tr>
                <td colspan="2">第一位乘客</td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td>
                    <input type="text" name="passengername" autocomplete="off" value="秦晓东">
                </td>
            </tr>
            <tr>
                <td>证件号:</td>
                <td>
                    <input type="text" name="certificationnumber" autocomplete="off" value="141124199807010170">
                </td>
            </tr>
        </table>
        <table>
            <tr>
                <td colspan="2">联系人</td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td>
                    <input type="text" name="linkmanname" autocomplete="off" value="秦晓东">
                </td>
            </tr>
            <tr>
                <td>手机号:</td>
                <td>
                    <input type="text" name="linkmanphone" autocomplete="off" value="15103467169">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="下一步，支付" >
                </td>
            </tr>
        </table>


    </form>
</div>

</body>
</html>

