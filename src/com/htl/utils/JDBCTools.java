package com.htl.utils;

import java.sql.*;

/**
 *      工具类
 */
public class JDBCTools {

    static String url ="jdbc:mysql://localhost:3306/online_shop?serverTimezone=UTC";
    static String user = "root";
    static String password = "password";

    /** 3个操作对象。*/
    protected Connection connection = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet resultSet = null;

    /**
     * 获得数据库连接对象。connection
     */
    public void getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //1、获得连接对象conn。
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭资源。
     */
    public void close(){
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

