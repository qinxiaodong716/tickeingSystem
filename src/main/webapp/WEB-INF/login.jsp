<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/hangkong/assets/layui/css/layui.css">
    <title>中国航空公司</title>
    <style>
        body, html{
            padding: 0;
            margin: 0;
        }
        .zh-top{
            height: 80px;
            width: 100%;
            background-color: #061f3e;
        }
        .zh-top-left img{
            position: absolute;
            left: 200px;
            height: 80px;
            width: 80px;
        }
        .zh-top-left span{
            position: absolute;
            top: 8px;
            left: 300px;
            font-size: 30px;
            color: red;
        }
        .zh-top-left i{
            position: absolute;
            top: 45px;
            left: 300px;
            font-size: 14px;
            color: greenyellow;
        }
        .zh-zhong{
            height: 500px;
            width: 100%;
        }
        .zh-zhong img{
            height: 100%;
            width: 100%;
        }
        .zh-zhong-right{
            position: relative;
            padding: 20px 18px 0;
            left: 900px;
            top: -445px;
            height: 372px;
            width: 364px;
            background-color: white;
            border-radius: 4px;
        }
        .layui-tab-content dl{
            clear: both;
            width: 100%;
            display: inline-block;
            padding-bottom: 14px;
            position: relative;
            padding-left: 19px;
        }
        .layui-tab-content dl dt{
            float: left;
            width: 67px;
            font-size: 12px;
            line-height: 26px;
            color: #444;
        }
        .layui-tab-content dl dd{
            float: left;
        }
        .layui-tab-content dl dd .input-long{
            width: 246px;
            height: 22px;
        }
        .layui-tab-content .r{
            width: 317px;
            text-align: right;
            margin-top: 10px;
        }
        .layui-tab-content .r .button{
            width: 250px;
            max-width: 250px;
            height: 32px;
            background-color: #3c763d;
            font-size: 16px;
            color: #fff;
            text-align: center;
            cursor: pointer;
            border: 1px solid #5cb85c;
            border-radius: 2px;
        }
    </style>
</head>
<body>
    <div class="zh-top">
        <div class="zh-top-left">
            <img src="assets/img/timg.jpg" alt="">
            <span>中国航空</span>
            <i>CHINA AVIATION</i>
        </div>
    </div>
    <div class="zh-zhong">
        <img src="assets/img/plane.jpg" alt="">
        <div class="zh-zhong-right">
            <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
                <ul class="layui-tab-title">
                    <li class="layui-this" style="font-size: 16px;width: 150px">企业账号登录</li>
                    <li style="font-size: 16px;width: 150px">员工账户登录</li>
                </ul>
                <div class="layui-tab-content" style="padding-top: 20px">
                    <div class="layui-tab-item layui-show">
                        <dl>
                            <dt>登录名</dt>
                            <dd>
                                <input type="text" name="username" class="input-long" placeholder="请输入用户名" value>
                            </dd>
                        </dl>
                        <dl>
                            <dt>密码</dt>
                            <dd>
                                <input type="password" name="password" class="input-long" placeholder="请输入登录密码" value>
                            </dd>
                        </dl>
                        <dl class="ten">
                            <dd class="r">
                                <input type="button" class="button" name="login" value="登录">
                            </dd>
                        </dl>
                    </div>
                    <div class="layui-tab-item">
						<dl>
                            <dt>登录名</dt>
                            <dd>
                                <input type="text" name="username" class="input-long" placeholder="请输入手机号" value>
                            </dd>
                        </dl>
                        <dl>
                            <dt>密码</dt>
                            <dd>
                                <input type="password" name="password" class="input-long" placeholder="请输入登录密码" value>
                            </dd>
                        </dl>
                        <dl class="ten">
                            <dd class="r">
                                <input type="button" class="button" name="login" value="登录">
                            </dd>
                        </dl>
					</div>
                </div>
            </div>
        </div>
    </div>
    <div class="zh-down">

    </div>


    <script src="/hangkong/assets/layui/layui.js"></script>
    <script>
        layui.use('element', function(){
            var element = layui.element;

            //一些事件监听
            element.on('tab(demo)', function(data){
                console.log(data);
            });
        });
    </script>
</body>
</html>