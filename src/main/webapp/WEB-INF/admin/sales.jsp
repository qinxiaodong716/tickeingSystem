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


    <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" style="border-radius: 0;float: left">添加营业员信息</button>
    <form action="" method="post" style="float: right ;padding-right: 20px;">
        <input type="text" placeholder="请输入营业员姓名" style="height: 46px;">
        <input type="submit" value="搜索" style="height: 46px;width: 80px;">
    </form>
    <form action="insertsales" method="post">
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <h4 class="modal-title" id="myModalLabel">
                            添加营业员信息
                        </h4>
                    </div>
                    <div class="modal-body">
                        <table>
                            <tr>
                                <td>所在站点id</td>
                                <td><input type="text" name="branchId"></td>
                            </tr>
                            <tr>
                                <td>姓名</td>
                                <td><input type="text" name="salesName"></td>
                            </tr>
                            <tr>
                                <td>密码</td>
                                <td><input type="text" name="password"></td>
                            </tr>
                            <tr>
                                <td>手机号</td>
                                <td><input type="text" name="phone"></td>
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
            <th>id
                <!--<select class = "drop-down-options">
                </select>-->
            </th>
            <th>所在站点</th>
            <th>姓名</th>
            <th>手机号</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${findAll}" var="fa" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${fa.salesId}</td>
                <td>${fa.branchId}</td>
                <td>${fa.salesName}</td>
                <td>${fa.phone}</td>
                <td>
                    <a href="deletesales/${fa.salesId}">删除</a>
                    <button>修改</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script src="/hangkong/assets/js/jquery-1.7.2.js"></script>

</body>
</html>
