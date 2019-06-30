package com.zuikc.implLoginDao;

import com.zuikc.LoginUser;
import com.zuikc.common.C3P0Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao implements com.zuikc.LoginDao {
    @Override
    public String selectUsername(String username) {
        Connection conn = C3P0Utils.getConnection();
        String name = null;
        String sql = "select username from loginUser where username = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                 name = rs.getString(1);
            }
            C3P0Utils.release1(rs, stmt, conn);
            return name;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String selectUserPassword(String username) {
        Connection conn = C3P0Utils.getConnection();
        String password = null;
        String sql = "select password from loginUser where username = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                password = rs.getString(1);
            }
            C3P0Utils.release1(rs, stmt, conn);
            return password;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    @Override
//    public int insertLoginUser(LoginUser user) {
//        Connection conn = C3P0Utils.getConnection();
//        String sql = "insert into loginUser (usernam,password) value (?,?)";
//        try {
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.setString(1, user.getUsername());
//            stmt.setString(2, user.getPassword());
//            int re = stmt.executeUpdate();
//            C3P0Utils.release2(stmt, conn);
//            return re;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
}
