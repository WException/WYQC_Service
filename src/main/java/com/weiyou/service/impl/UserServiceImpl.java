package com.weiyou.service.impl;

import com.weiyou.dao.UserDao;
import com.weiyou.dao.impl.UserDaoImpl;
import com.weiyou.pojo.User;
import com.weiyou.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    // 注册
    @Override
    public void registUser(User user) {
        dao.insertUser(user);
    }
    // 登录
    @Override
    public User login(User user) {
        return (User) dao.selectUser(user.getUsername(), user.getPassword());
    }
    // 验证
    @Override
    public boolean existsUsername(String username) {
        if(dao.selectUser(username) == null)
        {
            return false;
        }
        return true;
    }
}
