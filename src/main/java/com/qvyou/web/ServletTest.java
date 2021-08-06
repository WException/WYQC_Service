package com.qvyou.web;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class ServletTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("get被访问啦!");
        /* 接收部分 */
        Map map = req.getParameterMap(); // 获取前端传过来的数据装到一个map集合里
        Gson gson = new Gson(); // 这是一个工具类，可以通过它把上一步的map转换成 字符串 或者 json
        String mapJsonString = gson.toJson(map); // 如上所述，把接收到的数据转换成字符串
        System.out.println(mapJsonString); // 打印输出这个字符串
        /* 相应部分 */
        String JavaJson = "hello"; // 一个简单的字符串，想要返回给前端
        resp.getWriter().write(JavaJson); // 像之前说的，通过resp相应给前端
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){

    }

}
