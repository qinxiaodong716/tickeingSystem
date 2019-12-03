<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/27 0027
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改个人资料</title>
    <link rel="stylesheet" href="/hangkong/assets/css/qxd.index.css">
    <link rel="stylesheet" href="/hangkong/assets/layui/css/layui.css">
    <style>
    	
        .setpeople{
            width: 400px;
            margin: auto;
            margin-top: 20px;
            background-color: rgba(0,0,0,0.3);
            border-radius: 10px;
            color: blue;
        }
        td{
        	height:30px;
        }
        input{
        	margin:auto;
        }
    </style>
</head>
<body>
<div class="qxd_carousel_control">
<div class="zh-zhong-right">
            <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
                <ul class="layui-tab-title">
                    <li class="layui-this" style="font-size: 16px;width: 47%">修改信息</li>
                    <li style="font-size: 16px;width: 47%">修改密码</li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                    	<form action="setdataService" method="post" name="form">
	                    <table class="setpeople">
						    <tr>
						        <td>用户名</td>
						    </tr>
						    <tr>
						    	<td>
						            <input type="text" value="${people.peopleName}" name="name">
						        </td>
						    </tr>
						    <tr>
						        <td>身份证号</td>
						    </tr>
						    <tr>
						    	<td>
						            <input type="text" value="${people.idCard}" name="idCard">
						        </td>
						    </tr>
						    <tr>
						        <td>手机号</td>
						    </tr>
						    <tr>
						        <td>
						            <input type="text" value="${people.phone}" name="phone">
						        </td>
					        </tr>
					        <tr>
						    	<td>
						    		<input type="hidden" value="${people.peopleId}" name="id">
						    		<input type="submit" value="确认修改">
						    	</td>
						    </tr>
						</table>
						</form>
                    </div>
                    <div class="layui-tab-item">
                    	<form action="setpasswordservice" method="post" name="form">
						<table class="setpeople">
							<%
								if(Integer.parseInt(session.getAttribute("identity").toString())==3){
							%>
						    <tr>
						        <td>旧密码</td>
						    </tr>
						    <tr>
						        <td>
						            <input type="password" name="oldpassword">
						        </td>
						    </tr>
						    <tr>
						        <td>新密码</td>
						    </tr>
						    <tr>
						        <td>
						            <input type="password" name="password">
						        </td>
						    </tr>
						    <tr>
						        <td>确认密码</td>
						    </tr>
						    <tr>
						        <td>
						            <input type="password" name="password2">
						        </td>
						    </tr>
							<%
								}else{
							%>
							<tr>
								<td>新密码</td>
							</tr>
							<tr>
								<td>
									<input type="password" name="password">
								</td>
							</tr>
							<%}%>
						    <tr>
						    	<td>
						    		<input type="hidden" value="${people.peopleId}" name="id">
						    		<input type="submit" value="确认修改">
						    	</td>
						    </tr>
						    </table>
						  </form>
					</div>
                </div>
            </div>
       </div>
</div> 
	<script src="/hangkong/assets/layui/layui.js"></script>
	<script src="/hangkong/assets/js/jquery-1.7.2.js"></script>
    <script src="/hangkong/assets/js/jquery.validate.js"></script>
    <script>
    layui.use('element', function(){
        var element = layui.element;

        //一些事件监听
        element.on('tab(demo)', function(data){
            console.log(data);
        });
    });
    window.onload=function (){
		$("form").validate({
			 rules: {
				 phone:{
					 required:true,
				 	 rangelength:[11,11]
				 },
				 password:{
					 required:true
				 }
		
			 },
			 messages: {
				 phone:{
					 required:"必须输入手机号",
				 	 rangelength:"长度为11"
				 },
				 password:{
					 required:"必须输入密码"
				 }
				
			 }
		 });
	}
    </script>
</body>
</html>
