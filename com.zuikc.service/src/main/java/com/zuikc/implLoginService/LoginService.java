package com.zuikc.implLoginService;

import com.zuikc.LoginUser;
import com.zuikc.implLoginDao.LoginDao;

public class LoginService implements com.zuikc.LoginService {

    @Override
    public String selectUsernameService(String username) {
        LoginDao loginDao = new LoginDao();
        return loginDao.selectUsername(username);
    }

    @Override
    public String selectUserPasswordService(String username) {
        LoginDao loginDao = new LoginDao();
        return loginDao.selectUserPassword(username);
    }
//
//    @Override
//    public int insertLoginUser(LoginUser user) {
//        LoginDao loginDao = new LoginDao();
//        return loginDao.insertLoginUser(user);
//    }
}
