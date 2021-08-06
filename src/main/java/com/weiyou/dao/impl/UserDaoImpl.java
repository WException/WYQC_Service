package com.weiyou.dao.impl;

import com.weiyou.dao.UserDao;
import com.weiyou.pojo.User;
import com.weiyou.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public List select() {
        Connection con = JdbcUtils.getConnection();
        List list = null;
        PreparedStatement pstmt = null;
        String sql = "select * from t_user";
        try {
            pstmt = con.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = pstmt.executeQuery();
            if(rs != null)
            {
                list = new ArrayList();
                while(rs.next()){
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setEmail(rs.getString("email"));
                    list.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(pstmt != null)
                {
                        pstmt.close();
                }
                if(rs != null)
                {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtils.Close(con);
        }
        return list;
    }

    @Override
    public Object selectUser(String username) {
        User user = null;
        Connection con = JdbcUtils.getConnection();
        PreparedStatement pstmt = null;
        String sql = "select * from t_user where username = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = pstmt.executeQuery();
            if(rs != null && rs.next())
            {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(pstmt != null)
                {
                    pstmt.close();
                }
                if(rs != null)
                {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtils.Close(con);
        }
        return user;
    }

    @Override
    public Object selectUser(String username, String password) {
        User user = null;
        Connection con = JdbcUtils.getConnection();
        PreparedStatement pstmt = null;
        String sql = "select * from t_user where username = ? and password = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = pstmt.executeQuery();
            if(rs != null && rs.next())
            {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(pstmt != null)
                {
                    pstmt.close();
                }
                if(rs != null)
                {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtils.Close(con);
        }
        return user;
    }

    @Override
    public int insertUser(User user) {
        Connection con = JdbcUtils.getConnection();
        PreparedStatement pstmt = null;
        String sql = " INSERT INTO t_user (id,username,password,email) VALUES (?,?,?,?)";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int row = -1;
        try {
            row = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(pstmt != null)
                {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtils.Close(con);
        }
        return row;
    }
}
