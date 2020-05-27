package com.htl.dao.Impl;

import com.htl.dao.FindByUserIDDao;
import com.htl.entity.Online_User;
import com.htl.utils.JDBCTools;

import java.sql.SQLException;

public class FindByUserIDDao_Impl extends JDBCTools implements FindByUserIDDao {
    /**
     * 根据用户ID查找用户
     * @param userID
     * @return
     */
    @Override
    public Online_User find(String userID) {
        Online_User online_user = null;
        //获得连接对象
        getConnection();
        String sql = "select * from online_user where USER_ID = ?;";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userID);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                online_user = new Online_User(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getInt(10)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            close();
        }
        return online_user;
    }
}

