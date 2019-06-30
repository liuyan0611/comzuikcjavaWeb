package com.zuikc.implLoginDao;

import com.zuikc.User;
import com.zuikc.common.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dao  implements com.zuikc.Dao {
    @Override
    public List<User> selectUserDao() {
//        Connection conn = C3P0Utils.getConnection();
//        String sql = "select*from users";
//        User user = new User();
//        List<User> list = new ArrayList<>();
//        try {
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()){
//                int i = rs.getInt(1);
//                System.out.println(i);
//                String a = rs.getString(2);
//                System.out.println(a);
//                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDouble(10), rs.getDouble(11));
//                System.out.println(user);
//                list.add(user);
//                C3P0Utils.release1(rs, stmt, conn);
//                return  list;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        QueryRunner query = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select*from users";
        try {
            List<User> users = query.query(sql, new BeanListHandler<User>(User.class));
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insertUserDao(User user) {
        Connection conn = C3P0Utils.getConnection();
        String sql = "insert into users (siteTime,siteNum,siteLocation,siteName,siteDescription,siteLinker,siteDayHandle,siteCommWay,siteLong,siteLat) value (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getSiteTime());
            stmt.setString(2, user.getSiteNum());
            stmt.setString(3, user.getSiteLocation());
            stmt.setString(4, user.getSiteName());
            stmt.setString(5, user.getSiteDescription());
            stmt.setString(6, user.getSiteLinker());
            stmt.setString(7, user.getSiteDayHandle());
            stmt.setString(8, user.getSiteCommWay());
            stmt.setDouble(9, user.getSiteLong());
            stmt.setDouble(10, user.getSiteLat());
            int re = stmt.executeUpdate();
            C3P0Utils.release2(stmt, conn);
            return re;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void deleteUserDao(String uid) {
        int id1 = Integer.parseInt(uid);
        Connection conn = C3P0Utils.getConnection();
        String sql = "delete from users where id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id1);
            int re = stmt.executeUpdate();
            C3P0Utils.release2(stmt, conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public User selectUserDaoById(String uid) {
        QueryRunner query = new QueryRunner(C3P0Utils.getDataSource());
        User user = new User();
        int uid1 = Integer.parseInt(uid);
        String sql = "select*from users where id = ?";
        try {
            user = query.query(sql, new BeanHandler<User>(User.class),uid1);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateDaoByID(User user) {
        Connection conn = C3P0Utils.getConnection();
        String sql = "update users set siteTime=?,siteNum=?,siteLocation=?,siteName=?,siteDescription=?,siteLinker=?,siteDayHandle=?,siteCommWay=?,siteLong=?,siteLat=? where id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getSiteTime());
            stmt.setString(2, user.getSiteNum());
            stmt.setString(3, user.getSiteLocation());
            stmt.setString(4, user.getSiteName());
            stmt.setString(5, user.getSiteDescription());
            stmt.setString(6, user.getSiteLinker());
            stmt.setString(7, user.getSiteDayHandle());
            stmt.setString(8, user.getSiteCommWay());
            stmt.setDouble(9, user.getSiteLong());
            stmt.setDouble(10, user.getSiteLat());
            stmt.setInt(11, user.getId());
            int re = stmt.executeUpdate();
            C3P0Utils.release2(stmt, conn);
            return re;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getTotalCount(Map<String, String[]> condiction) {
        Connection conn = C3P0Utils.getConnection();
        String sql = "select count(*) from users where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condiction.keySet();
        List<Object> list = new ArrayList<>();
        for (String key : keySet) {
            if ("currentPage".equals(key)||"pageSize".equals(key)){
                continue;
            }
            String value = condiction.get(key)[0];
            if (value!=null){
                sb.append(" and " +key+" like ? ");
                list.add("%"+value+"%");
            }
        }
        System.out.println(list.toArray());

        System.out.println(sb.toString());

        String sql1 = sb.toString();
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        try {
            Long query = queryRunner.query(sql1, new ScalarHandler<>(), list.toArray());
            System.out.println(query);
            return query.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        int re = 0;
//        try {
//            PreparedStatement stmt = conn.prepareStatement(sql1);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()){
//                re = rs.getInt(1);
//                C3P0Utils.release1(rs, stmt, conn);
//                return re;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
            return 0;
    }

    @Override
    public List<User> getList(int start, int pS, Map<String, String[]> condiction) {
        QueryRunner query = new QueryRunner(C3P0Utils.getDataSource());
//        String sql = "select* from users limit ?,?";
        String sql = "select * from users where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condiction.keySet();
        List<Object> list = new ArrayList<>();
        for (String key : keySet) {
            if ("currentPage".equals(key)||"pageSize".equals(key)){
                continue;
            }
            String value = condiction.get(key)[0];
            if (value!=null){
                sb.append(" and " +key+" like ? ");
                list.add("%"+value+"%");
            }
        }
        list.add(start);
        list.add(pS);
        sb.append(" limit ? , ? ");
        String sql1 = sb.toString();
        System.out.println(sql1);
        try {
            List<User> lists = query.query(sql1, new BeanListHandler<User>(User.class), list.toArray());

            return lists;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
