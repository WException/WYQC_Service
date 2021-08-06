package com.weiyou.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// http://localhost:8080/WeiYouDemo_war_exploded/
public class RegistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("被访问啦");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        UserServiceImpl userService = new UserServiceImpl();
//        // 获取客户端表单信息
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        String email = req.getParameter("email");
//        // 检查用户名是否可用
//        if(!userService.existsUsername(username))
//        {
//            User user = new User();
//            user.setUsername(username);
//            user.setPassword(password);
//            user.setEmail(email);
//            userService.registUser(user);
//        }
//        else
//        {
//            System.out.println("用户名不合法");
//        }
        System.out.println("被访问啦");
    }
}
