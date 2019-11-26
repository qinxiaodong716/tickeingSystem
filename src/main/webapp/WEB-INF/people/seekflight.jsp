<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
    <meta charset="utf-8">
    <title>航空售票系统——客户端</title>
    <link rel="stylesheet" href="/hangkong/assets/css/qxd.index.css">
</head>
<body>
    <div class="qxd_carousel_control" style="margin-top: 50px;">
        <div class="qxd_carousel_control_left">
            <div class="qxd_control" style="background: #ffffff">订购机票</div>
            <div class="qxd_control">航班动态</div>
            <div class="qxd_control">旅游度假</div>
            <div class="qxd_control">东航金融</div>
        </div>
        <div class="qxd_carousel_control_right">

            <div class="qxd_carousel_control_right_top">
                <div class="qxd_carousel_control_right_top_carousel">机票</div>
                <div class="qxd_carousel_control_right_top_carousel">预办登机</div>
                <div class="qxd_carousel_control_right_top_carousel">酒店</div>
                <div class="qxd_carousel_control_right_top_carousel">机场接送</div>
            </div>
            <div class="qxd_carousel_control_right_button">
                <form action="inquireflight" method="post">
                    <table class="qxd_carousel_control_right_button_con">
                        <tr>
                            <td>出发城市</td>
                            <td>到达城市</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>
                                <input type="text" size="30" name="fromCity" style="height:40px">
                            </td>
                            <td>
                                <input type="text" size="30" name="toCity" style="height:40px">
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>
                                出发时间
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="text" size="30" name="startDate" style="height:40px" >
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td><input type="submit" value="搜素" style="height:40px;width: 120px"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</body>
</html>