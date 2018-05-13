package com.wjl;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class MainServlet extends HttpServlet {
    Test test;
    ArrayList newsList;

    @Override
    public void init(ServletConfig config) throws ServletException {
        //首次调用去执行的操作（遍历目录），并转跳到index.jsp
        System.out.println("init方法执行");
        Test t = new Test();
        try {
            t.traversalDirectory("http://www.hzpt.edu.cn/Newslist.php?pernums=0&cid=315&page=1");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            ServletContext sc = getServletContext();//ServletContext在JSP中就是application对象
            sc.setAttribute("newsList",newsList);
            this.newsList = newsList;
            this.test = t;
        }
        System.out.println("init方法结束");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        ServletContext sc = getServletContext();
        sc.setAttribute("newsList",this.newsList);
    }
}