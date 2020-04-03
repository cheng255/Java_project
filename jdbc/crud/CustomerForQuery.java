package com.atguigu2.preparedstatement.crud;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

import com.atguigu3.bean.Customer;
import com.atguigu3.util.JDBCUtils;

/**
 * 
 * 针对于Customers表的查询操作
 * 
 * @author 86182
 *
 */
public class CustomerForQuery {
	
	@Test
	public void testQueryForCustomers() {
		String sql = "select id,name,birth,email from customers where id = ?";
		
		Customer customer = queryForCustomers(sql, 13);
		System.out.println(customer);
		
		
	}

	/**
	 * 针对于Customers表的通用的查询操作
	 * @throws Exception 
	 * 
	 * 
	 */
	public Customer queryForCustomers(String sql, Object...args) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = JDBCUtils.getConnection();
			
			ps = connection.prepareStatement(sql);
			for(int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
			
			rs = ps.executeQuery();
			// 获取结果集的元数据
			ResultSetMetaData rsmd = rs.getMetaData();
			// 通过ResultSetMetaData获取结果集中的列数
			int columnCount = rsmd.getColumnCount();
			if(rs.next()) {
				Customer cust = new Customer();		
				
				//处理结果集一行数据中的每一列
				for(int i = 0; i < columnCount; i++) {
					//获取每个列的值
					Object columnValue = rs.getObject(i+1);
					
					//获取每个列的列名
					String columnName = rsmd.getColumnName(i+1);
					
					// 给cust对象指定的columnName属性，赋值为columnValue,通过反射
					Field field = Customer.class.getDeclaredField(columnName);
					field.setAccessible(true);
					field.set(cust, columnValue);
				}
				return cust;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			JDBCUtils.closeResource(connection, ps, rs);
		}
		
		return null;
		
	}
	
	
	@Test
	public void testQuery1() {
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			//获取连接
			connection = JDBCUtils.getConnection();
			
			//预编译sql语句
			String sql = "select id,name,email,birth from customers where id = ?";
			ps = connection.prepareStatement(sql);
			
			//填充占位符
			ps.setObject(1, 1);
			
			//执行
			resultSet = ps.executeQuery();
			//处理结果集
			if(resultSet.next()) { // 判断结果集的下一条是否有数据，如果有数据返回true，并指针下移
										//如果没有数据返回false
				//获取当前这条数据的各个字段值
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String email = resultSet.getString(3);
				Date birth = resultSet.getDate(4);
				
//			Object[] data = new Object[] {id,name,email,birth};
				
				//推荐方式：将数据封装成一个对象
				Customer customer = new Customer(id, name, email, birth);
				System.out.println(customer);
						
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			//关闭资源
			JDBCUtils.closeResource(connection, ps, resultSet);
		}
		
		
		
		
	}
}
