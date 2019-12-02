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
    <link rel="stylesheet" href="/hangkong/assets/css/qxd.payment.css">
</head>
<body>
<div class="qxd_in">
    <table class="sousuo" style="text-align: center">

        <tr>
            <th>订单号</th>
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
            <tr>
                <td>${orderId}</td>
                <td>${act.flightNumber}</td>
                <td>${act.startDate.toString().substring(0,10)}</td>
                <td>${act.fromAirportName}</td>
                <td>${act.toAirportName}</td>
                <td>${act.departureTime.toString().substring(10,16)}</td>
                <td>${act.arrivalTime.toString().substring(10,16)}</td>
                <td>${act.basicPrice}</td>
                <td>${act.airplane}</td>
                <td>${act.sailLength}</td>
            </tr>
    </table>
    <form action="paymentsuccess" method="post">
        <table>
            <tr>
                <td colspan="4">第一位乘客</td>
            </tr>
            <tr>
                <td>姓名</td>
                <td>
                    <input type="text" name="passengerName" value="${passengerName}" readonly="readonly">
                </td>
                <td>证件号</td>
                <td>
                    <input type="text" name="certificationNumber" value="${certificationNumber}" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td colspan="4">联系人</td>
            </tr>
            <tr>
                <td>姓名</td>
                <td>
                    <input type="text" name="linkmanName" value="${linkmanName}" readonly="readonly">
                </td>
                <td>手机号</td>
                <td>
                    <input type="text" name="linkmanPhone" value="${linkmanPhone}" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <input  type="hidden" value="${orderId}" name="orderId">
                    <input  type="hidden" value="${flightId}" name="flightId">
                    <input type="submit" value="确认支付" >
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>













