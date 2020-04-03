package com.atguigu1.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.atguigu1.util.JDBCUtils;

/*
 * 
 * 事务操作
 * 
 * 
 * DBC程序中为了让多个 SQL 语句作为一个事务执行：

 		调用 Connection 对象的setAutoCommit(false); 以取消自动提交事务
 		在所有的 SQL 语句都成功执行后，调用 commit(); 方法提交事务
		在出现异常时，调用 rollback(); 方法回滚事务
 * 
 */
public class TransactionTest {
	
	@Test
	public void testTransaction() {
		
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			
			//1.取消数据的自动提交功能
			connection.setAutoCommit(false);
			
			String sql1 = "update user_table set balance = balance - 100 where user = ?";
			update(connection, sql1, "AA");


			String sql2 = "update user_table set balance = balance + 100 where user = ?";
			update(connection, sql2, "BB");
			
			System.out.println("转账成功");
			
			//2.提交数据
			connection.commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//3.回滚数据
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			
			//4.将自动提交功能回复
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//4.关闭资源
			JDBCUtils.closeResource(connection, null);
		}
		
		
		
	}
	
	//通用的增删改操作 -----version 2.0  考虑事务
	public void update(Connection connection,String sql,Object ...args) {
								// sql当中占位符的个数应该与可变形参的长度相同

		//1.预编译sql语句，返回PreparedStatement的实例
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			//2.填充占位符
			for(int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);//小心参数声明错误
			}
			//3.执行
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			//4.关闭资源
			JDBCUtils.closeResource(null, ps);
		}
		
	}

}
