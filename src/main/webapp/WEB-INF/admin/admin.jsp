<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>中国航空公司后台管理</title>
    <link rel="stylesheet" href="/hangkong/assets/layui/css/layui.css">
    <link rel="stylesheet" href="/hangkong/assets/css/index.css">
    <link rel="stylesheet" type="text/css" href="/hangkong/assets/css/normalize.css" />
    <link rel="stylesheet" href="/hangkong/assets/css/font-awesome.min.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">管理员界面</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="HomePage" target="view">首页</a></li>
            <li class="layui-nav-item"><a href="adminsales" target="view">营业员</a></li>
            <li class="layui-nav-item"><a href="adminbranch" target="view">营业点</a></li>
            <li class="layui-nav-item"><a href="adminpeople" target="view">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">航班管理</a></dd>
                    <dd><a href="">营业点管理</a></dd>
                    <dd><a href="">用户管理</a></dd>
                </dl>
            </li>
            <div class="search d3">
                <form action="">
                    <input type="text" placeholder="请输入城市或营业点名称...">
                    <button type="submit"></button>
                </form>
            </div>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    贤心
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="Alogin">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
<!--                     <a class="" href="javascript:;">所有商品</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="javascript:;">列表三</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">解决方案</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li> -->
                <li class="layui-nav-item"><a href="flightmanagement" target="view">航班管理</a></li>

            </ul>
        </div>
    </div>

    <div class="layui-body">
<!--        <div class="left-map">
            <img src="img/zhongguo.jpg" alt="" style="height: 100%;width: 100%">
            <div class="left-map-zhong">中国营业点统计图</div>

        </div>
        <div class="down-zhongguo">中国营业点统计图</div>
        <div class="right-paihangbang"></div>-->
        <!-- 内容主体区域 -->
        <div style="padding: 15px;height: 95%">
            <iframe class="rihgt-view" src="HomePage" name="view" style="width: 99%;height: 100%"></iframe>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © YanhuiLiu.com
    </div>
</div>
<script src="/hangkong/assets/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>