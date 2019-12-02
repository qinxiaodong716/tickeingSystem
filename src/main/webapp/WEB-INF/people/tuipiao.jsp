<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户退票</title>
	<link rel="stylesheet" href="/hangkong/assets/css/qxd.findorder.css">
</head>
<body>
<form action="orderinquiry" method="post">

	<div class="qxd_ddxx">
		<c:forEach items="${orders}" var="order">
		<table>
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
						<input type="text" disabled="disabled" value="${order.departureTime.toString().substring(0,16)}" name="lgsj">
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
						<c:if test="${order.level=='j'}">
							<input type="text" disabled="disabled" value="经济舱">
						</c:if>
						<c:if test="${order.status=='g'}">
							<input type="text" disabled="disabled" value="公务舱">
						</c:if>
						<c:if test="${order.status=='t'}">
							<input type="text" disabled="disabled" value="头等舱">
						</c:if>
					</td>
				</tr>
				<tr>
					<td>乘客类型:</td>
					<td>
						<c:if test="${order.passengerType=='c'}">
							<input type="text" disabled="disabled" value="成人">
						</c:if>
						<c:if test="${order.passengerType=='x'}">
							<input type="text" disabled="disabled" value="小孩">
						</c:if>
					</td>
					<td>订单状态:</td>
					<td>
						<c:if test="${order.status=='yfk'}">
						<input type="text" disabled="disabled" value="已付款" name="start">
						</c:if>
						<c:if test="${order.status=='ytk'}">
							<input type="text" disabled="disabled" value="已退款" name="start">
						</c:if>
						<c:if test="${order.status=='wfk'}">
							<input type="text" disabled="disabled" value="未付款" name="start">
						</c:if>
					</td>
					<td>是否出票:</td>
					<td>
						<c:choose>
							<c:when test="${order.status=='ycp'}">
								<input type="text" disabled="disabled" value="已出票" name="start">
							</c:when>

							<c:otherwise>
								<input type="text" disabled="disabled" value="---" name="start">
							</c:otherwise>
						</c:choose>
					</td>
					<td>是否退票:</td>
					<td>
						<c:choose>
						<c:when test="${order.status=='ytk'}">
							<input type="text" disabled="disabled" value="已退款" name="start">
						</c:when>

						<c:otherwise>
							<input type="text" disabled="disabled" value="---" name="start">
						</c:otherwise>
					</c:choose>
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
						<input type="text" disabled="disabled" value="${order.price}" class="jpjg">
					</td>
				</tr>
				<tr>
					<td>可退金额</td>
					<td class="tkje"></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td class="tk">
						<input type="button"  value="确认退票" onclick="tuipiao(${order.orderId})" class="qrtp">
						<a href="#" class="tp" style="text-decoration: none">确认退票</a>
					</td>
				</tr>
		</table>
		</c:forEach>
	</div>
</form>
<script src="/hangkong/assets/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="/hangkong/assets/js/qxd.index.js"></script>
<script>
	$(function(){
		$("table").each(function () {
			var lgsjdate = new Date($(this).find("input[name ='lgsj']").val())
			var start = $(this).find("input[name ='start']").val()
			var xzsjdate = new Date()
			var sjc =(lgsjdate-xzsjdate)
			var piaojia = $(this).find(".jpjg").val()
			h = sjc/1000/60/60

			if("已付款"==start){
				if(h>24){
					tkje = piaojia
					$(this).find(".tp").css({"display":"none"})
				}else if(h>2){
					tkje = piaojia*0.9
					$(this).find(".tp").css({"display":"none"})
				}else if(h>0){
					tkje = piaojia*0.8
					$(this).find(".tp").css({"display":"none"})
				}else{
					tkje = 0
					$(this).find(".tp").html("无法退票")
					$(this).find(".tp").css({"display":"block"})
					$(this).find(".qrtp").css({"display":"none"})
				}
				$(this).find(".tkje").html(tkje)
			}else if("已退款"==start){
				$(".ktje").html(0)
				$(this).find(".tp").html("已退票")
				$(this).find(".qrtp").css({"display":"none"})
			}else{
				$(".ktje").html(0)
			}
		})

	})
	function tuipiao(e) {
		var orderId = e;
		$.ajax({
			type:"POST",
			url:"querentuipiao",
			data:{
				"orderId":orderId
			},
			success:function(data){
				if(data>0){
					$(".ddzt").html("ytk")
					alert("退款成功")
				}
			}
		})
	}
</script>
</body>
</html>