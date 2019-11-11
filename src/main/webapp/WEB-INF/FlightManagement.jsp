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

</head>
<body>
<div class="BOX">
    <input type="button" class="add" value="添加新航班信息">
    <table class="table table-bordered">
        <tr>
            <th>序号</th>
            <th>
                航班号
                <!--<select class = "drop-down-options">
                </select>-->
            </th>

            <th>出发地</th>
            <th>目的地</th>
            <th>离港时间</th>
            <th>到港时间</th>
            <th>班期</th>
            <th>基准票价</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${findAll}" var="fa" varStatus="status">
        	<tr>
        		<td>${status.index+1}</td>
        		<td>${fa.flightNumber}</td>
        		<td>${fa.fromCity}</td>
        		<td>${fa.toCity}</td>
        		<td>${fa.departureTime}</td>
        		<td>${fa.arrivalTime}</td>
        		<td>${fa.scheduler}</td>
        		<td>${fa.basicPrice}</td>
        		<td><a href="">修改</a></td>
        	</tr>
        </c:forEach>
    </table>
</div>
<script src="/hangkong/assets/js/jquery-1.7.2.js"></script>

</body>
</html>
