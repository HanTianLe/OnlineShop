package com.htl.service.Impl;

import com.htl.dao.AdminOperateUserDao;
import com.htl.dao.Impl.AdminOperateUserDao_Impl;
import com.htl.entity.Online_User;
import com.htl.service.AdminOperateUserService;

import java.util.ArrayList;

public class AdminOperateUserService_Impl implements AdminOperateUserService {

    private AdminOperateUserDao adminOperateUserDao = new AdminOperateUserDao_Impl();

    /**
     * 插入一个新用户
     * @param u
     * @return
     */
    @Override
    public int insert(Online_User u) {
        Object[] params = {
                u.getUSER_ID(),
                u.getUSER_NAME(),
                u.getUSER_PASSWORD(),
                u.getUSER_SEX(),
                u.getUSER_BIRTHDAY(),
                u.getUSER_IDENTITY_CODE(),
                u.getUSER_EMAIL(),
                u.getUSER_MOBILE(),
                u.getUSER_ADDRESS(),
                u.getUSER_STATUS()
        };
        int count = adminOperateUserDao.insert(params);
        return count;
    }

    /**
     * 据用户id删除用户
     * @param id
     * @return
     */
    @Override
    public int delete(String id) {
        int count = adminOperateUserDao.delete(id);
        return count;
    }

    /**
     * 通过用户ID查找用户
     * @param id
     * @return
     */
    @Override
    public Online_User findUserByID(String id) {
        Online_User u = adminOperateUserDao.findUserById(id);
        return u;
    }

    /**
     * 更新用户
     * @param u
     * @return
     */
    @Override
    public int update(Online_User u) {
        //注意要跟UserDao实现类里面对应方法的sql语句里面的字段对应。
        Object[] params = {
                u.getUSER_NAME(),
                u.getUSER_PASSWORD(),
                u.getUSER_SEX(),
                u.getUSER_BIRTHDAY(),
                u.getUSER_IDENTITY_CODE(),
                u.getUSER_EMAIL(),
                u.getUSER_MOBILE(),
                u.getUSER_ADDRESS(),
                u.getUSER_STATUS(),
                u.getUSER_ID()
        };
        int count = adminOperateUserDao.update(params);
        return count;
    }

    /**
     * 查询全部用户
     * @param cpage
     * @param count
     * @param keyword
     * @return
     */
    @Override
    public ArrayList<Online_User> findAllUser(int cpage, int count, String keyword) {
        ArrayList<Online_User> list = adminOperateUserDao.findAllUser(cpage,count,keyword);
        return list;
    }

}


