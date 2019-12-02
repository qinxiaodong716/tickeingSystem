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
</head>
<body>
<form action="adminfindpeople" method="post">
	<input type="text" placeholder="请输入手机号" style="height: 46px;" name="phone">
	<input type="submit" value="搜索" style="height: 46px;width: 80px;">
</form>
<div class="BOX">
    <table class="table table-bordered">
        <tr>
            <th style="width: 50px;">序号</th>
            <th>id
                <!--<select class = "drop-down-options">
                </select>-->
            </th>
			<th>姓名</th>
			<th>电话</th>
            <th>身份证号</th>
        </tr>
        <c:forEach items="${findAll}" var="fa" varStatus="status">
        	<tr>
        		<td>${status.index+1}</td>
        		<td>${fa.peopleId}</td>
				<td>${fa.peopleName}</td>
        		<td>${fa.phone}</td>
        		<td>${fa.idCard}</td>
        	</tr>
        </c:forEach>
		<tr class="find">
			<td>1</td>
			<td class="peopleId">${find.peopleId}</td>
			<td>${find.peopleName}</td>
			<td>${find.phone}</td>
			<td>${find.idCard}</td>
		</tr>
    </table>
</div>
<script src="/hangkong/assets/js/jquery-1.7.2.js"></script>
<script src="/hangkong/assets/js/admin/people.js"></script>
</body>
</html>