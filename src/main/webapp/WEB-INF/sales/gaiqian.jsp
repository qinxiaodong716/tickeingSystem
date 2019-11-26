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
</head>
<body>
<form action="orderinquiry" method="post">

	<div class="qxd_ddxx">
		<table style="width: 100%">
			<c:forEach items="${orders}" var="order">
				<tr>
					<td>订单号:</td>
					<td>
						<input type="text" value="${order.orderId}" name="orderId">
					</td>
					<td>航班号:</td>
					<td>
						<input type="text" disabled="disabled" value="${order.flightNumber}">
					</td>
					<td>出发日期:</td>
					<td>
						<input type="text" disabled="disabled" value="${order.departureDate}">
					</td>
					<td>机型:</td>
					<td>
						<input type="text" disabled="disabled" value="${order.airplane}">
					</td>
				</tr>
				<tr>
					<td>出发地:</td>
					<td>
						<input type="text" disabled="disabled" value="${order.fromCity}">
					</td>
					<td>目的地:</td>
					<td>
						<input type="text" disabled="disabled" value="${order.toCity}">
					</td>
					<td>起飞机场:</td>
					<td>
						<input type="text" disabled="disabled" value="${order.fromAirportName}">
					</td>
					<td>到达机场:</td>
					<td>
						<input type="text" disabled="disabled" value="${order.toAirportName}">
					</td>
				</tr>
				<tr>
					<td>离港时间:</td>
					<td>
						<input type="text" disabled="disabled" value="${order.departureTime.toString().substring(0,16)}">
					</td>
					<td>到港时间:</td>
					<td>
						<input type="text" disabled="disabled" value="${order.arrivalTime.toString().substring(0,16)}">
					</td>
					<td>里程:</td>
					<td>
						<input type="text" disabled="disabled" value="${order.sailLength}">
					</td>
					<td>舱位等级:</td>
					<td>
						<input type="text" disabled="disabled" value="${order.level}">
					</td>
				</tr>
				<tr>
					<td>乘客类型:</td>
					<td>
						<input type="text" disabled="disabled" value="${order.passengerType}">
					</td>
					<td>订单状态:</td>
					<td>
						<input type="text" disabled="disabled" value="${order.status}">
					</td>
					<td>是否出票:</td>
					<td>
						<input type="text" disabled="disabled" value="${order.orderId}">
					</td>
					<td>是否退票:</td>
					<td>
						<input type="text" disabled="disabled" value="${order.orderId}">
					</td>
				</tr>
				<tr>
					<td>乘客姓名:</td>
					<td>
						<input type="text" disabled="disabled" value="${order.passengerName}">
					</td>
					<td>联系电话:</td>
					<td>
						<input type="text" disabled="disabled" value="${order.linkmanPhone}">
					</td>
					<td>售票点:</td>
					<td>
						<input type="text" disabled="disabled" value="${order.branchName}">
					</td>
					<td>售票员:</td>
					<td>
						<input type="text" disabled="disabled" value="${order.salesName}">
					</td>
				</tr>
				<tr>
					<td>乘客证件:</td>
					<td>
						<input type="text" disabled="disabled" value="${order.certificationNumber}">
					</td>
					<td>机票号:</td>
					<td>
						<input type="text" disabled="disabled" value="${order.ticketOrderId}">
					</td>
					<td>机票总价:</td>
					<td>
						<input type="text" disabled="disabled" value="${order.price}">
					</td>
					<td>
						<input type="button"  value="改签">
					</td>
				</tr>
			</c:forEach>

		</table>
	</div>
</form>
</body>
</html>