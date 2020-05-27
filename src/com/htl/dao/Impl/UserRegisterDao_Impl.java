package com.htl.dao.Impl;

import com.htl.dao.UserRegisterDao;
import com.htl.utils.JDBCTools;

import java.sql.SQLException;

public class UserRegisterDao_Impl extends JDBCTools implements UserRegisterDao {
    /**
     * 普通用户注册
     * @param params
     * @return
     */
    @Override
    public int register(Object[] params) {
        int count = 0;
        String sql = "insert into online_user values (?, ?, ?, ?, DATE_FORMAT(?, '%Y-%m-%d'), ?, ?, ?, ?, ?);";
        getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1,params[i]);
            }
            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return count;
    }
}

