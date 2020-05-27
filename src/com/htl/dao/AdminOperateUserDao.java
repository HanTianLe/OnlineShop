package com.htl.dao;

import com.htl.entity.Online_User;

import java.util.ArrayList;

public interface AdminOperateUserDao {
    // 添加普通用户信息
    public int insert(Object[] params);
    // 删除普通用户信息
    public int delete(String id);
    // 根据用户ID查询所有用户信息
    public Online_User findUserById(String id);
    // 更新用户信息
    public int update(Object[] params);
    // 查询全部用户信息
    public ArrayList<Online_User> findAllUser(int cpage, int count, String keyword);
    // 获取总记录数和总页数
    public int[] totalPage(int count, String keyword);
}
