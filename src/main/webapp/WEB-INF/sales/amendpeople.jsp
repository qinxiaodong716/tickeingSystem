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
    <title>航空售票系统——用户查询</title>
    <link rel="stylesheet" href="/hangkong/assets/layui/css/layui.css">
    <style>
        .ss td{
            width: 200px;
            padding-left: 40px;
        }
        input{
            height: 40px;
        }
        .sousuo{
            margin-right: 60px;
            float: right;
        }
        .people{
            width: 100%;
            text-align: center;
            margin:0;
            border: 1px solid #e6e6e6;
        }
        .people td,th{
            border: 1px solid #e6e6e6;
        }
    </style>
</head>
<body>
<table width="100%" class="ss">
    <tr>
        <td>手机号</td>
        <td></td>
        <td>用户名</td>
    </tr>
    <form action="salsesetpeople" method="post">
    <tr>
        <td>
            <input type="text" name="phone" autocomplete="off">
        </td>
        <td></td>
        <td>
            <input type="text" name="peoplename" class="peoplename" autocomplete="off">
        </td>
        <td></td>
        <td>
            <input type="submit" style="width: 80px;height: 40px;" class="sousuo"></input>
        </td>
    </tr>
    </form>
</table>
<div style="width: 92%;height: 85%;border: 1px solid #e6e6e6;margin-left: 40px;margin-top: 20px;" class="people">
    <table style="width: 100%;border: 1px; text-align: center;">
        <iframe name="view" style="height: 530px;width: 100%; border: 0;"></iframe>
    </table>
</div>
<script src="/hangkong/assets/js/layui.js"></script>
<script src="/hangkong/assets/js/jquery-1.7.2.js"></script>
</body>
</html>