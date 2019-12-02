<%@ page language="java" contentType="text/html;charset=UTF-8"
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
    <title>机场页面</title>
    <link rel="stylesheet" href="/hangkong/assets/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="BOX">

    <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" style="border-radius: 0;float: left">添加机场信息</button>
    <form action="adminfindAirport" method="post" style="float: right ;padding-right: 20px;">
        <input type="text" placeholder="请输入机场代码" style="height: 46px;" name="airportCode">
        <input type="submit" value="搜索" style="height: 46px;width: 80px;">
    </form>
    <form action="saveairport" method="post">
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <h4 class="modal-title" id="myModalLabel">
                            添加机场信息
                        </h4>
                    </div>
                    <div class="modal-body">
                        <table>
                            <tr>
                                <td>机场名称</td>
                                <td><input type="text" name="airportName"></td>
                            </tr>
                            <tr>
                                <td>所在城市</td>
                                <td><input type="text" name="city"></td>
                            </tr>
                            <tr>
                                <td>机场代码</td>
                                <td><input type="text" name="airportCode"></td>
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
            <th>机场代码</th>
            <th>机场名称</th>
            <th>所在城市</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${findAll}" var="fa" varStatus="status">
            <tr id="${fa.airportCode}">
                <td>${status.index+1}</td>
                <td>${fa.airportCode}</td>
                <td>${fa.airportName}</td>
                <td>${fa.city}</td>
                <td>
                    <a href="deleteairport/${fa.airportCode}">删除</a>
                    <button>修改</button>
                </td>
            </tr>
        </c:forEach>
        <tr id="${find.airportCode}" class="find">
            <td>1</td>
            <td class="airportCode">${find.airportCode}</td>
            <td>${find.airportName}</td>
            <td>${find.city}</td>
            <td>
                <a href="deletebranch/${find.airportCode}">删除</a>
                <button>修改</button>
            </td>
        </tr>
    </table>
</div>
<script src="/hangkong/assets/js/jquery-1.7.2.js"></script>
<script src="/hangkong/assets/js/admin/airport.js"></script>

</body>
</html>