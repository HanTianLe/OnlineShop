package com.htl.dao.Impl;

import com.htl.dao.UserLoginDao;
import com.htl.entity.Online_User;
import com.htl.utils.JDBCTools;

import java.sql.SQLException;

public class UserLoginDao_Impl extends JDBCTools implements UserLoginDao {
    /**
     * 用户登录
     * @param UserID
     * @param Password
     * @return
     */
    @Override
    public Online_User login(String UserID, String Password) {
        Online_User u = null;
        String sql = "select * from online_user where USER_ID = ? and USER_PASSWORD = ?;";
        getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,UserID);
            preparedStatement.setObject(2,Password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                u = new Online_User(
                        resultSet.getString("USER_ID"),
                        resultSet.getString("USER_NAME"),
                        resultSet.getString("USER_PASSWORD"),
                        resultSet.getString("USER_SEX"),
                        resultSet.getString("USER_BIRTHDAY"),
                        resultSet.getString("USER_IDENTITY_CODE"),
                        resultSet.getString("USER_EMAIL"),
                        resultSet.getString("USER_MOBILE"),
                        resultSet.getString("USER_ADDRESS"),
                        resultSet.getInt("USER_STATUS")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 关闭资源
            close();
        }
        return u;
    }
}

