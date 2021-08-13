package com.qvyou.web;

import com.qvyou.pojo.User;
import com.qvyou.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserServiceImpl userService = new UserServiceImpl();
        if(userService.login(user) != null)
        {
            System.out.println(user.getUsername()+"登陆成功");
            // 跳转到主页
            req.getRequestDispatcher("/index.html").forward(req, resp);
        }
        else
        {
            req.getRequestDispatcher("/regist.html").forward(req, resp);
        }
    }
}
