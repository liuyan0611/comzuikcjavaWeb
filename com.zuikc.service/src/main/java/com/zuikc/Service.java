package com.zuikc;

import java.util.List;
import java.util.Map;

public interface Service {
    public List<User> selectUserService();
    public int insertService(User user);

    public void deleteService(String[] uids);
    public User selectUserServiceById(String[] uids);
    public int updateUserServiceById(User user);

    PageBean<User> getPageBean(String currentPage, String pageSize, Map<String, String[]> condiction);
}
