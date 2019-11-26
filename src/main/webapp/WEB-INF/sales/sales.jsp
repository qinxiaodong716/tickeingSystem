<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
    <meta charset="utf-8">
    <title>航空售票系统——售票员</title>
    <link rel="stylesheet" href="/hangkong/assets/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">欢迎登录本系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="/hangkong/assets/image/touxiang.jpg" class="layui-nav-img">
                    <span class = "username" ></span>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="setdata" target="view">基本资料</a></dd>
                    <dd><a href="setpassword" target="view">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="#" onclick="outlogin(${act.id})">退出登录</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">票务管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="seekflight" target="view">购票</a></dd>
                        <dd><a href="refund" target="view">退票</a></dd>
                        <dd><a href="changing" target="view">改签</a></dd>
                        <dd><a href="orderinquiry" target="view">查询订单</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="inquirepeople" target="view">用户查询</a></dd>
                        <dd><a href="setpeople" target="view">用户修改</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <iframe name="view"  src="seekflight" style="height: 95%;width: 99%; border: 0;"></iframe>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>

<script src="/hangkong/assets/js/layui.js"></script>
<script src="/hangkong/assets/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="/hangkong/assets/js/qxd.sales.js"></script>
</body>
</html>