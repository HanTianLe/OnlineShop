package com.htl.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取连接对象
	 * @return
	 */
	public static Connection getconn() {
		//创建一个连接对象
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_shop?serverTimezone=UTC","root","password");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 执行增删改语句
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int exectuIUD(String sql,Object[] params) {
		int count = 0;
		Connection conn = BaseDao.getconn();
		// 准备SQL
		PreparedStatement ps = null;
		// insert into user('''''')values(?,?,?)
		try {
			ps = conn.prepareStatement(sql);
			for(int i = 0;i<params.length;i++) {
				ps.setObject(i+1, params[i]);
			}
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeall(null, ps, conn);
		}
		return count;
	}
	/**
	 * 关闭资源
	 * @param rs
	 * @param ps
	 * @param conn
	 */
	public static void closeall(ResultSet rs, PreparedStatement ps, Connection conn) {
			try {
				if(rs != null)
					rs.close();
				if(ps != null)
					ps.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
}

