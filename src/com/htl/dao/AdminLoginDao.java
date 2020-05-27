package com.htl.dao;

import com.htl.entity.Online_User;

public interface AdminLoginDao {
    // 管理员登录
    public Online_User login(String userID, String password);
}
