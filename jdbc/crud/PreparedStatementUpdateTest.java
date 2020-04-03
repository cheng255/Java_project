package com.atguigu2.preparedstatement.crud;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Properties;

import org.junit.Test;

import com.atguigu3.util.JDBCUtils;

/*
 * 
 * 使用PreparedStatement来替换Statement,实现对数据表的增删改的操作
 * 
 * 增删改 ；  查
 * 
 */
public class PreparedStatementUpdateTest {
	
	@Test
	public void testCommonUpdate() {
//		String sql = "delete from customers where id = ?";
//		update(sql,3);
		
		String sql = "update `order` set order_name = ? where order_id = ?";
		update(sql,"DD",2);
		
	}
	
	
	
	//通用的增删改操作
	public void update(String sql,Object ...args) {
								// sql当中占位符的个数应该与可变形参的长度相同
		//获取数据库连接
		Connection connection = null;
		//2.预编译sql语句，返回PreparedStatement的实例
		PreparedStatement ps = null;
		try {
			connection = JDBCUtils.getConnection();
			ps = connection.prepareStatement(sql);
			//3.填充占位符
			for(int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);//小心参数声明错误
			}
			//4.执行
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			//5.关闭资源
			JDBCUtils.closeResource(connection, ps);
		}
		
	}
	
	
	
	
	//修改customers表中的一条记录
	@Test
	public void testUpdate() {
		//1.获取数据库的连接
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = JDBCUtils.getConnection();
			//2.预编译sql语句，返回PreparedStatement的实例
			String sql = "update customers set name = ? where id = ?";
			ps = connection.prepareStatement(sql);
			//3.填充占位符
			ps.setObject(1, "莫扎特");
			ps.setObject(2, 18);
			//4.执行
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5.资源的关闭
			JDBCUtils.closeResource(connection, ps);
		}

	}
	
	
	
	//向customers表中添加一条记录
	@Test
	public void testInsert() {
		
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			//1.获取四个基本信息
			InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
			Properties pros = new Properties();	
			pros.load(is);
			
			String user = pros.getProperty("user");
			String url = pros.getProperty("url");
			String password = pros.getProperty("password");
			String driverClass = pros.getProperty("driverClass");
			
			//2.加载驱动
			Class.forName(driverClass);
			//3.获取连接
			connection = DriverManager.getConnection(url, user, password);
			
			
			//4.预编译sql语句，返回PreparedStatement的实例
			String sql = "insert into customers(name,email,birth)value(?,?,?)";//?:占位符
			ps = connection.prepareStatement(sql);
			//5.填充占位符
			ps.setObject(1, "哪吒");
			ps.setString(2, "nezha@gmail.com");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = sdf.parse("2000-10-02");
			
			ps.setDate(3, new Date(date.getTime()));
			
			//6.执行操作
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
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
		}
		
		
		
		
	}
	
	

}
