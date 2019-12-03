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
        <tr>
            <td>
                <input type="text" name="peoplephone" autocomplete="off">
            </td>
            <td></td>
            <td>
                <input type="text" name="peoplename" class="peoplename" autocomplete="off">
            </td>
            <td></td>
            <td>
                <button style="width: 80px;height: 40px;" class="sousuo" onclick="findpeople()">搜索</button>
            </td>
        </tr>
    </table>
<div style="width: 92%;height: 85%;border: 1px solid #e6e6e6;margin-left: 40px;margin-top: 20px;" class="people">
    <table style="width: 100%;border: 1px; text-align: center;">

    </table>
</div>
<script src="/hangkong/assets/js/layui.js"></script>
<script src="/hangkong/assets/js/jquery-1.7.2.js"></script>
<script>
    function findpeople() {
        var phone = $("input[name='peoplephone']").val();
        $.post(
            "salesfindpeople",{"phone":phone},function (data) {
                if(data="wzd"){
                    alert("未找到")
                }else{
                    var people = JSON.parse(data)
                    var table = "<table class='people'><tr>" +
                        "            <th>序号</th>\n" +
                        "            <th>姓名</th>\n" +
                        "            <th>手机号</th>\n" +
                        "            <th>身份证号</th>\n" +
                        "        </tr><tr>"
                    table+="<td>"+1+"</td>"
                    table+="<td>"+people.peopleName+"</td>"
                    table+="<td>"+people.phone+"</td>"
                    table+="<td>"+people.idCard+"</td>"
                    table+="</tr></table>"
                    $(".people").html(table)
                }
            }
        )
    }
</script>
</body>
</html>