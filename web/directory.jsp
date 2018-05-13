<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wjl.Test" %>
<%@ page import="com.wjl.News" %><%--
  Created by IntelliJ IDEA.
  User: 汪建力
  Date: 2018/5/12
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>目录</title>
    <style>
        li{list-style: none;}
        .left{float: left;}
        .right{float: right}
        .main{
            width: 1000px;
            margin: 0 auto;
        }
        .item{
            width: 980px;
            border-radius: 5px;
            padding: 10px;
            font-size: 20px;
            height: 20px;
            line-height: 20px;
            margin-bottom: 0px;
        }
        .item:hover{
            background-color: #ddd;
        }
        .item ul{
            font-size: 18px;
            line-height: 18px;
            color: #fff;
            background-color: #333;
            border-radius: 5px;
            position: relative;
            top:0px;
            width: 680px;
            padding: 20px 50px;
            margin: 0 100px;
            opacity: 1;
        }
        .item ul li{
            font-size: 18px;
            line-height: 30px;
            top: 20px;
            left: 20px;
        }
    </style>
</head>
    <%
        Test test;
        if(application.getAttribute("Test") == null){
            test = new Test();
            application.setAttribute("Test",test);
        }else{
            test = (Test) application.getAttribute("Test");
        }
        ArrayList<News> newsList = test.accessNewsList();
        int x = newsList.size();
    %>
<body>
    <div class="main">
        <div>
            <%for (int i=0; i<x; i++){%>
                <% News temp = (News) newsList.get(i); %>
                <ul class="item">
                    <li class="left"><%=temp.getTitle()%></li>
                    <li class="right"><%=temp.getDate()%></li>
                    <ul style="display: none;">
                        <li style="font-size: 25px;line-height: 35px;text-align: left"><%=temp.getTitle()%></li>
                        <li><%=temp.getText()%></li>
                        <li>URL:<%=temp.getUrl()%></li></ul>
                </ul>
            <%}%>
        </div>
    </div>
</body>
</html>
<script type="application/javascript" src="http://libs.baidu.com/jquery/1.9.1/jquery.js"></script>
<script type="application/javascript">
    var item = $(".item");
    $(function () {
        $(".item").mousemove(function () {
           $(this).find("ul").show();
        });
        $(".item").mouseout(function () {
            $(this).find("ul").hide();
        });
    });
</script>
