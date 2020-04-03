package com.atguigu3.util;

import java.io.InputStream;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 * 操作数据库的连接
 * @author 86182
 *
 */
public class JDBCUtils {

	/**
	 * 获取数据库的连接
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception{
		
		//1.获取四个基本信息
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
		Properties pros = new Properties();
		pros.load(is);

		String user = pros.getProperty("user");
		String url = pros.getProperty("url");
		String password = pros.getProperty("password");
		String driverClass = pros.getProperty("driverClass");

		// 2.加载驱动
		Class.forName(driverClass);
		// 3.获取连接
		Connection connection = DriverManager.getConnection(url, user, password);
		
		return connection;
	}
	/**
	 * 关闭连接和Statement的操作
	 * @param connection
	 * @param ps
	 */
	public static void closeResource(Connection connection,Statement ps) {
		//7.资源关闭
		try {
			if(ps != null)
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(connection != null)
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	/**
	 * 关闭资源的操作
	 * 
	 * @param connection
	 * @param ps
	 * @param re
	 */
	public static void closeResource(Connection connection,Statement ps,ResultSet re) {
		//7.资源关闭
		try {
			if(ps != null)
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(ps != null)
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		try {
			if(re != null)
			re.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}
	
}
