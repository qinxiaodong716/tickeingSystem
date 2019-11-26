<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import="com.alibaba.fastjson.JSON"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" href="/hangkong/assets/css/qxd.index.css">
</head>
<body>
    <div class="qxd_head_nav">
        <div class="qxd_head_nav_mid">
            <div class="qxd_head_nav_mid_left">
                <p>服务热线:95530</p>
                <P>在线客服</P>
                <p>投诉建议</p>
                <P>微信</P>
                <p>微博</p>
                <P>特色产品</P>
                <p>友情链接</p>
                <P>language</P>
            </div>
            <div class="qxd_head_nav_mid_right">
                <%
                    if(!"yes".equals(session.getAttribute("login"))){
                %>
                    <P>
                        <a href="register">注册</a>
                    </P>
                    <p>
                        <a href="login">登录</a>
                    </p>
                <%
                    } else{
                %>
                    <p>
                        <a href="#" onclick="outlogin()">退出登录</a>
                    </p>
                    <P>
                        <span class = "username" ></span>
                    </P>
                <%
                    }
                %>
            </div>
        </div>
    </div>
    <div class="qxd_con_nav">
        <div class="qxd_con_nav_mid">
            <div class="qxd_log1"></div>
            <div class="qxd_log2"></div>
            <div class="qxd_log3"></div>
            <div class="qxd_con_nav_right">
                <span><a href="index" class="qxd_con_nav_right_a">首页</a></span>
                <span><a href="orderinquiry" class="qxd_con_nav_right_a" target="view">订单查看</a></span>
                <span><a href="#">退票</a></span>
                <span>积分商城</span>
                <span>旅行信息</span>
                <span>旅行度假</span>
                <span>旅行保险</span>
                <span>各国签证</span>
            </div>
        </div>
    </div>
    <div class="qxd_carousel">
        <iframe name="view" src="peopleseekflight" style="height: 530px;width: 100%; border: 0;"></iframe>
    </div>


</body>
<script src="/hangkong/assets/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="/hangkong/assets/js/qxd.index.js"></script>
</html>