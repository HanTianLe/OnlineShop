package com.htl.dao;

import com.htl.entity.Online_User;

public interface UserLoginDao {
    // 用户登录
    public Online_User login(String UserID,String Password);

}
