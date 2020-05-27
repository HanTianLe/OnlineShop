package com.htl.dao;

import com.htl.entity.Online_User;

public interface FindByUserIDDao {
    //根据用户ID查找用户
    public Online_User find(String userID);
}
