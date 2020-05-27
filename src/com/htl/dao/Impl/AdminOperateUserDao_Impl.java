package com.htl.dao.Impl;

import com.htl.dao.AdminOperateUserDao;
import com.htl.entity.Online_User;
import com.htl.utils.JDBCTools;

import java.sql.SQLException;
import java.util.ArrayList;

public class AdminOperateUserDao_Impl extends JDBCTools implements AdminOperateUserDao {

    /**
     * 插入一个普通新用户
     * @param params
     * @return int count
     */
    @Override
    public int insert(Object[] params) {
        int count = 0;
        String sql = "insert into online_user values(?, ?, ?, ?, DATE_FORMAT(?, '%Y-%m-%d'), ?, ?, ?, ?, ?)";
        //获取连接对象
        getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1,params[i]);
            }
            count = preparedStatement.executeUpdate();
            /*
            方法executeUpdate :
                    用于执行 insert、update 或 delete 语句以及 SQL DDL（数据定义语言）语句，
                    例如 create table 和 drop table。insert、update 或 delete 语句的效果是修改表中零行或多行中的一列或多列。
                    executeUpdate 的返回值是一个整数（int），指示受影响的行数（即更新计数）。
            */
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            close();
        }
        return count;
    }

    /**
     * 根据用户id删除普通用户
     * @param id
     * @return
     */
    @Override
    public int delete(String id) {
        int count = 0;
        String sql = "delete from online_user where USER_ID= ? and USER_STATUS != 2";
        //获取连接对象
        getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,id);
            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            close();
        }
        return count;
    }

    /**
     * 根据用户id查询全部用户信息
     * @param id
     * @return
     */
    @Override
    public Online_User findUserById(String id) {
        Online_User online_user = null;
        String sql = "select m.*,DATE_FORMAT(m.user_birthday,'%Y-%m-%d')birthday from online_user m where USER_ID = ?";
        //获取连接对象
        getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                online_user = new Online_User(
                        resultSet.getString("USER_ID"),
                        resultSet.getString("USER_NAME"),
                        resultSet.getString("USER_PASSWORD"),
                        resultSet.getString("USER_SEX"),
                        resultSet.getString("birthday"),
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
            ////关闭资源
            close();
        }
        return online_user;
    }

    /**
     * 更新用户信息
     * @param params
     * @return
     */
    @Override
    public int update(Object[] params) {
        int count = 0;
        String sql = "update online_user set USER_NAME=?, USER_PASSWORD=?, USER_SEX=?, USER_BIRTHDAY=DATE_FORMAT(?,'%y-%m-%d'), USER_IDENTITY_CODE=?, USER_EMAIL=?, USER_MOBILE=?, USER_ADDRESS=?, USER_STATUS=? where USER_ID=?";
        //获取连接对象
        getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1,params[i]);
            }
            count = preparedStatement.executeUpdate();
            /*
            方法executeUpdate :
                    用于执行 insert、update 或 delete 语句以及 SQL DDL（数据定义语言）语句，
                    例如 create table 和 drop table。insert、update 或 delete 语句的效果是修改表中零行或多行中的一列或多列。
                    executeUpdate 的返回值是一个整数（int），指示受影响的行数（即更新计数）。
            */
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            close();
        }
        return count;
    }

    /**
     * 查询全部用户信息
     * @param cpage
     * @param count
     * @param keyword
     * @return
     */
    @Override
    public ArrayList<Online_User> findAllUser(int cpage, int count, String keyword) {
        ArrayList<Online_User> arrayList = new ArrayList<Online_User>();
        //获取连接对象
        getConnection();
        try {
            String sql = "";
            if(keyword != null) {
                sql = "select * from online_user where USER_NAME like ? order by USER_BIRTHDAY desc limit ?,?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%"+keyword+"%");
                preparedStatement.setInt(2, (cpage-1)*count);
                preparedStatement.setInt(3, count);
            }else {
                sql = "select * from online_user order by USER_BIRTHDAY desc limit ?,?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, (cpage-1)*count);
                preparedStatement.setInt(2, count);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Online_User u = new Online_User(
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
                arrayList.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            close();
        }
        return arrayList;
    }

    /**
     * 获取总记录数和总页数
     * @param count
     * @param keyword
     * @return
     */
    @Override
    public int[] totalPage(int count, String keyword) {
        //0总记录数，1，页数
        int arr[] = {0,1};
        //获取连接对象
        getConnection();
        try {
            String sql = "";
            if(keyword != null) {
                sql = "select count(*) from online_user where USER_NAME like ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%"+keyword+"%");
            }else {
                sql = "select count(*) from online_user";
                preparedStatement = connection.prepareStatement(sql);
            }
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                arr[0] = resultSet.getInt(1);

                if(arr[0] % count ==0) {
                    arr[1] = arr[0]/count;
                }else {
                    arr[1] = arr[0]/count + 1;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return arr;
    }

}

