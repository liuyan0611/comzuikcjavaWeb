package com.zuikc;

public interface LoginDao {
    public String selectUsername(String username);
    public String selectUserPassword(String username);
//    public int insertLoginUser(LoginUser user);
}
