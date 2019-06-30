package com.zuikc.implLoginService;

import com.zuikc.PageBean;
import com.zuikc.User;
import com.zuikc.implLoginDao.Dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Service implements com.zuikc.Service {
    @Override
    public List<User> selectUserService() {
        Dao dao = new Dao();
        return dao.selectUserDao();
    }

    @Override
    public int insertService(User user) {
        Dao dao = new Dao();
        return dao.insertUserDao(user);
    }

    @Override
    public void deleteService(String[] uids) {
        Dao dao = new Dao();
        for (int i = 0; i < uids.length; i++) {
             dao.deleteUserDao(uids[i]);
        }

    }

    @Override
    public User selectUserServiceById(String[] uids) {
        Dao dao = new Dao();
        for (String uid : uids) {
            return dao.selectUserDaoById(uid);
        }
        return null;
    }

    @Override
    public int updateUserServiceById(User user) {
        Dao dao = new Dao();
        return dao.updateDaoByID(user);
    }

    @Override
    public PageBean<User> getPageBean(String currentPage, String pageSize, Map<String, String[]> condiction) {
        int cP = Integer.parseInt(currentPage);
        int pS = Integer.parseInt(pageSize);
        if (cP<=0){
            cP=1;
        }
        PageBean<User> pageBean = new PageBean<>();
        pageBean.setCurrentPage(cP);
        pageBean.setPageSize(pS);

        Dao dao = new Dao();
        int totalCount = dao.getTotalCount(condiction);
        pageBean.setTotalCount(totalCount);

        int totalPage =  totalCount % pS ==0 ? totalPage = totalCount/pS:totalCount/pS+1;
        pageBean.setTotalPage(totalPage);

        if (cP>=totalPage){
            cP=totalPage;

        }        int start = (cP-1)*pS;
        List<User> lists = dao.getList(start,pS,condiction);
        pageBean.setList(lists);

        return pageBean;
    }
}
