<%@ page import="com.wjl.Test" %><%--
  Created by IntelliJ IDEA.
  User: Chien
  Date: 2018/5/10
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>小爬虫</title>
    <link rel="stylesheet" type="text/css" src="/css/index.css">
    <style>
        div.main a:hover{
            background-color: #ddd;
        }
    </style>
</head>
    <body>
        <div class="main" style="
            width: 1000px;
            margin: 0 auto;
            text-align: center;
            padding-top: 20px;
            ">
            <a href="/directory.jsp" style="
                font-size: 50px;
                text-decoration: none;
                text-underline: none;
                font-weight: 600;
                color: #000;
                display: block;
                padding: 20px;
                border-radius: 5px;
            ">欢迎，点击进入项目目录</a>
        </div>
    </body>
</html>
