package com.weiyou.dao;

import com.weiyou.pojo.User;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有用户
     * @return 返回集合，所有用户存放在里面
     */
    public List select();

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 如果有这个用户名，则返回这个用户,否则返回null
     */
    public Object selectUser(String username);

    /**
     * 根据用户名和用户密码查询用户
     * @param username 用户名
     * @param password 用户密码
     * @return 如果有这个用户名，则返回这个用户,否则返回null
     */
    public Object selectUser(String username, String password);

    /**
     * 添加用户
     * @param user 要添加的用户
     */
    public int insertUser(User user);
}
