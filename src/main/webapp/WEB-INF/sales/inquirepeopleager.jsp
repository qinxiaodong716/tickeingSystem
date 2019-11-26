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
    <link rel="stylesheet" href="/hangkong/assets/css/layui.css">
</head>
<body>
<table>
    <tr>
        <td>用户名:</td>
        <td>
            <input type="text" name="peoplename" class="peoplename" autocomplete="off">
        </td>
        <td>
            <input type="button" onclick="nameinquire()" value="按用户名查询">
        </td>
    </tr>
    <tr>
        <td>手机号:</td>
        <td>
            <input type="text" name="peoplephone" class="peoplephone" autocomplete="off">
        </td>
        <td>
            <input type="button" onclick="phoneinquire()" value="按手机号查询">
        </td>
    </tr>
    <table border="1">

    </table>

</table>
<script src="/hangkong/assets/js/layui.js"></script>
<script src="/hangkong/assets/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="/hangkong/assets/js/sales.js"></script>
</body>
</html>