package com.htl.service.Impl;

import com.htl.dao.Impl.UserRegisterDao_Impl;
import com.htl.dao.UserRegisterDao;
import com.htl.entity.Online_User;
import com.htl.service.UserRegisterService;

public class UserRegisterService_Impl implements UserRegisterService {

    private UserRegisterDao userRegisterDao = new UserRegisterDao_Impl();

    /**
     * 普通用户注册
     * @param u
     * @return
     */
    @Override
    public int register(Online_User u) {
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
        int count = userRegisterDao.register(params);
        return count;
    }
}

