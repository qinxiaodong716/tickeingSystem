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


<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" style="border-radius: 0;">添加新航班信息</button>

<form action="FMadd">
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
				<ul>
					<li><span>航班号</span><input type="text" name="flightNumber"></li>
					<li><span>出发地</span><input type="text" name="fromCity"></li>
					<li><span>目的地</span><input type="text" name="toCity"></li>
					<li><span>离港时间</span><input type="text" name="departureTime"></li>
					<li><span>到港时间</span><input type="text" name="arrivalTime"></li>
					<li><span>班期</span><input type="text" name="scheduler"></li>
					<li><span>基准票价</span><input type="text" name="basicPrice"></li>
				</ul>
				
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
            <th>航班号
                <!--<select class = "drop-down-options">
                </select>-->
            </th>
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
        	<tr>
        		<td>${status.index+1}</td>
        		<td>${fa.flightNumber}</td>
        		<td>${fa.startDate}</td>
        		<td>${fa.endDate}</td>
        		<td>${fa.fromCity}</td>
        		<td>${fa.toCity}</td>
        		<td>${fa.departureTime}</td>
        		<td>${fa.arrivalTime}</td>
        		<td>${fa.airplane}</td>
        		<td>${fa.scheduler}</td>
        		<td>${fa.sailLength}</td>
        		<td>${fa.basicPrice}</td>
        		<td><button>修改</button><button>删除</button></td>
        	</tr>
        </c:forEach>
    </table>
</div>
<script src="/hangkong/assets/js/jquery-1.7.2.js"></script>

</body>
</html>