package com.atguigu2.preparedstatement.crud;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

import com.atguigu3.bean.Order;
import com.atguigu3.util.JDBCUtils;

/**
 * 针对于Order表的通用的查询操作
 * 
 * @author 86182
 *
 */
public class OrderForQuery {

	/*
	 * 
	 * 针对于标的字段名和类的属性名不一致的情况，
	 * 1.必须声明sql时，使用类的属性名来命名字段的别名
	 * 2.在使用ResultSetMetaData时，需要使用getColumnLabel()来替换getColumnName(),
	 * 	从而获取类的别名
	 * 		说明:如果sql中没给字段起别名，getColumnLabel()获取的就是列名
	 * 
	 */
	@Test
	public void testOrderForQuery() {
		String sql = "select order_id orderId,order_name orderName,order_date orderDate from `order` where `order_id` = ?";
		Order order = orderForQuery(sql,1);
		System.out.println(order);
	}
	
	/**
	 * 通用的针对于order表的查询操作
	 * @param sql
	 * @param args
	 * @return
	 */
	
	public Order orderForQuery(String sql,Object...args) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = JDBCUtils.getConnection();
			ps = connection.prepareStatement(sql);
			for(int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
			
			//执行，获取结果集
			rs = ps.executeQuery();
			//获取结果集的元数据
			ResultSetMetaData rsmd = rs.getMetaData();
			//获取列数
			int columnCount = rsmd.getColumnCount();
			if(rs.next()) {
				Order order = new Order();
				for(int i = 0; i < columnCount; i++) {
					//获取每个列的值
					Object columnValue = rs.getObject(i+1);
					//获取每个列的列名
					//获取列的列名：getColumnName()
					//获取列的别名：getColumnLabel()
//					String columnName = rsmd.getColumnName(i+1); //不推荐使用
					String columnName = rsmd.getColumnLabel(i+1);
					
					//通过反射将对象的指定列名的属性附上指定的列值
					Field field = Order.class.getDeclaredField(columnName);
					field.setAccessible(true);
					field.set(order,columnValue);
				}
				
				return order;
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
		ResultSet rs = null;
		try {
			connection = JDBCUtils.getConnection();
			String sql = "select order_id,order_name,order_date from `order` where `order_id` = ?";
			ps = connection.prepareStatement(sql);
			ps.setObject(1, 1);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = (int) rs.getObject(1);
				String name = (String) rs.getObject(2);
				Date date = (Date) rs.getObject(3);
				
				Order order = new Order(id, date, name);
				System.out.println(order);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(connection, ps, rs);
			
		}
		
		
	}
}
