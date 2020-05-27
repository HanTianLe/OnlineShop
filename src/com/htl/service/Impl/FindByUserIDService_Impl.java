package com.htl.service.Impl;

import com.htl.dao.FindByUserIDDao;
import com.htl.dao.Impl.FindByUserIDDao_Impl;
import com.htl.entity.Online_User;
import com.htl.service.FindByUserIDService;

public class FindByUserIDService_Impl implements FindByUserIDService {

    private FindByUserIDDao findByUserIDDao = new FindByUserIDDao_Impl();

    /**
     * 根据用户ID查找用户
     * @param userID
     * @return
     */
    @Override
    public boolean find(String userID) {
        Online_User u = findByUserIDDao.find(userID);
        Boolean result = null;
        if (u != null){
            result = true;
        }else {
            result = false;
        }
        return result;
    }
}

