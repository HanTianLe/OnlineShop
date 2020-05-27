package com.htl.service;

import com.htl.entity.Online_User;

import java.util.ArrayList;

public interface AdminOperateUserService {
    // 插入一个普通新用户
    public int insert(Online_User u);
    // 删除普通用户
    public int delete(String id);
    // 通过用户ID查找全部用户
    public Online_User findUserByID(String id);
    // 更新用户
    public int update(Online_User u);
    // 调出所有用户
    public ArrayList<Online_User> findAllUser(int cpage, int count, String keyword);

}
