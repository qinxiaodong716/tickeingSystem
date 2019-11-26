<%@ page language="java" contentType="text/html; charset=UTF-8"
                pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>register</title>
</head>
<body>
<form action="registerservice" method="post">
    <table>
        <tr>
            <td>姓名</td>
            <td>
                <input type="text" name="name" autocomplete="off">
            </td>
        </tr>
        <tr>
            <td>身份证号</td>
            <td>
                <input type="text" name="idCard" autocomplete="off">
            </td>
        </tr>
        <tr>
            <td>手机号</td>
            <td>
                <input type="text" name="phone" autocomplete="off">
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <input type="password" name="password" autocomplete="off">
            </td>
        </tr>
        <tr>
            <td>确认密码</td>
            <td>
                <input type="password" name="password1" autocomplete="off">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="注册">
            </td>
        </tr>
    </table>
</form>
</body>
</html>