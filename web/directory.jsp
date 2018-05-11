<%@ page import="com.wjl.Main" %>
<%@ page import="com.wjl.Test" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Chien
  Date: 2018/5/11
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>项目目录</title>
</head>
<body>
    <%
        Main main = new Main();
        if(main.refreshList()){
            Test test = main.getTest();
            ArrayList newsList = test.getNewsList();
        }
    %>
</body>
</html>
