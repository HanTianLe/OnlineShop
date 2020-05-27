package com.htl.dao.Impl;

import com.htl.dao.AdminLoginDao;
import com.htl.entity.Online_User;
import com.htl.utils.JDBCTools;

import java.sql.SQLException;

public class AdminLoginDao_Impl extends JDBCTools implements AdminLoginDao {
    /**
     * 管理员登录
     * @param userID
     * @param password
     * @return
     */
    @Override
    public Online_User login(String userID, String password) {
        Online_User u = null;
        String sql = "select * from online_user where USER_ID = ? and USER_PASSWORD = ?;";
        getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,userID);
            preparedStatement.setObject(2,password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                u = new Online_User(resultSet.getString(1),
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
        return u;
    }
}
