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

        

<form action="setdataService" method="post">

    <table>
    	<tr>
            <td>id</td>
            <td>
                <input type="text" name="id" placeholder="${acts[0].getPeopleId()}">
            </td>
        </tr>
        <tr>
            <td>姓名</td>
            <td>
                <input type="text" name="name" placeholder="${acts[0].getPeopleName()}">
            </td>
        </tr>
        <tr>
            <td>身份证号</td>
            <td>
                <input type="text" name="idCard" placeholder="${acts[0].getIdCard()}">
            </td>
        </tr>
        <tr>
            <td>手机号</td>
            <td>
                <input type="text" name="phone" placeholder="${acts[0].getPhone()}">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="确认修改">
            </td>
        </tr>
    </table>
</form>
</body>
</html>