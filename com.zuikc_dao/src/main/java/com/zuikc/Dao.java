package com.zuikc;

import java.util.List;
import java.util.Map;

public interface Dao {
    public List<User> selectUserDao();
    public int insertUserDao(User user);

    public void deleteUserDao(String uid);
    public User selectUserDaoById(String uid);
    public int updateDaoByID(User user);

    int getTotalCount(Map<String, String[]> condiction);

    List<User> getList(int start, int pS, Map<String, String[]> condiction);
}
