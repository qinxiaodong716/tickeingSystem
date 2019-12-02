<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <meta charset="UTF-8">
    <title>Title</title>
   	<link rel="stylesheet" href="/hangkong/assets/css/bootstrap.css">
   		<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!-- <style type="text/css">
		th{
			font-size: 16px;
		}
	</style> -->
</head>
<body>
<div class="BOX">


<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" style="border-radius: 0;float: left">添加新航班信息</button>
<form action="flightNumberfind" method="post" style="float: right ;padding-right: 20px;">
	<input type="text" placeholder="请输入航班号" style="height: 46px;" name="flightNumber">
	<input type="submit" value="搜索" style="height: 46px;width: 80px;">
</form>
<form action="saveflightscheduler">
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					添加航班信息
				</h4>
			</div>
			<div class="modal-body">
				<table>
					<tr>
                        <td>航班号</td>
                        <td><input type="text" name="flightNumber"></td>
                    </tr>
                    <tr>
                        <td>出发时间</td>
                        <td><input type="date" name="startDate"></td>
                    </tr>
                    <tr>
                        <td>结束时间</td>
                        <td><input type="date" name="endDate"></td>
                    </tr>
					<tr>
                        <td>出发地</td>
                        <td class="formcity"></td>
                    </tr>
					<tr>
                        <td>目的地</td>
                        <td class="tocity"></td>
                    </tr>
					<tr>
                        <td>离港时间</td>
                        <td><input type="datetime-local" name="departureTime"></td>
                    </tr>
					<tr>
                        <td>到港时间</td>
                        <td><input type="datetime-local" name="arrivalTime"></td>
                    </tr>
					<tr>
                        <td>班期</td>
                        <td><input type="text" name="scheduler"></td>
                    </tr>
					<tr>
                        <td>基准票价</td>
                        <td><input type="text" name="basicPrice"></td>
                    </tr>
                    <tr>
                        <td>执行机型</td>
                        <td class="airplane"></td>
                    </tr>
                    <tr>
                        <td>航程</td>
                        <td><input type="text" name="sailLength"></td>
                    </tr>
				</table>
				
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<input type="submit" class="btn btn-primary" value="提交">
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
</form>



    <table class="table table-bordered">
        <tr>
            <th style="width: 50px;">序号</th>
            <th>航班号</th>
			<th>开始日期</th>
			<th>结束日期</th>
            <th>出发地</th>
            <th>目的地</th>
            <th>离港时间</th>
            <th>到港时间</th>
            <th>执行机型</th>
            <th>班期</th>
            <th>航程</th>
            <th>基准票价</th>
            <th>操作</th>
        </tr>
            <c:forEach items="${findAll}" var="fa" varStatus="status">
                <tr class="findAll">
                    <td>${status.index+1}</td>
                    <td>${fa.flightNumber}</td>
                    <td>${fa.startDate}</td>
                    <td>${fa.endDate}</td>
                    <td>${fa.fromAirportName}</td>
                    <td>${fa.toAirportName}</td>
                    <td>${fa.departureTime.toString().substring(0,16)}</td>
                    <td>${fa.arrivalTime.toString().substring(0,16)}</td>
                    <td>${fa.airplane}</td>
                    <td>${fa.scheduler}</td>
                    <td>${fa.sailLength}</td>
                    <td>${fa.basicPrice}</td>
                    <td>
                        <a href="deleteflightscheduler/${fa.flightNumber}">删除</a>
                        <button>修改</button>
                    </td>
                </tr>
            </c:forEach>
        <tr class="find" style="width: 100%">
            <td>1</td>
            <td class="findflightNumber">${find.flightNumber}</td>
            <td>${find.startDate}</td>
            <td>${find.endDate}</td>
            <td>${find.fromAirportName}</td>
            <td>${find.toAirportName}</td>
            <td>${find.departureTime.toString().substring(0,16)}</td>
            <td>${find.arrivalTime.toString().substring(0,16)}</td>
            <td>${find.airplane}</td>
            <td>${find.scheduler}</td>
            <td>${find.sailLength}</td>
            <td>${find.basicPrice}</td>
            <td>
                <a href="deleteflightscheduler/${find.flightNumber}">删除</a>
                <button>修改</button>
            </td>
        </tr>
    </table>
</div>
<script src="/hangkong/assets/js/jquery-1.7.2.js"></script>
<script src="/hangkong/assets/js/admin/flightmanagement.js"></script>
</body>
</html>