package com.qvyou.test;

import com.qvyou.pojo.User;
import com.qvyou.service.impl.UserServiceImpl;

public class UserServiceImplTest {
    public static void main(String[] args) {
        UserServiceImpl usi = new UserServiceImpl();

        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        if(usi.login(user) == null){
            System.out.println("登陆失败");
        }else{
            System.out.println("登陆成功");
        }

        System.out.println(usi.existsUsername("admin"));
    }
}
