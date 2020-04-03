package com.atguigu2.preparedstatement.crud;

/**
 * 使用PreparedStatement替换Statement，解决了SQL注入问题
 * 还有:		1.可以操作Blob的数据
 * 			2.可以实现更高效的批量操作
 * 
 */
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.atguigu3.bean.Customer;
import com.atguigu3.bean.Order;
import com.atguigu3.util.JDBCUtils;



/**
 * 使用PreparedStatement实现针对于不同表的通用的查询操作
 * 
 * @author 86182
 *
 */
public class PreparedStatementQueryTest {
	@Test
	public void testGetForList() {
		
		String sql = "select id,name,email from customers where id < ?";
		List<Customer> list = getForList(Customer.class, sql, 12);
		list.forEach(System.out::println);
		
		String sql1 = "select order_id orderId,order_name orderName,order_date orderDate from `order`";
		List<Order> list2 = getForList(Order.class,sql1);
		list2.forEach(System.out::println);
		
	}
	
	
	public <T> List<T> getForList(Class<T> clazz,String sql,Object...args) {
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
			//创建集合对象
			ArrayList<T> list = new ArrayList<T>();
			while(rs.next()) {
				T t = clazz.newInstance();
				//处理结果集每一行数据中的每一个列：给t对象指定的属性赋值的过程
				for(int i = 0; i < columnCount; i++) {
					//获取每个列的值
					Object columnValue = rs.getObject(i+1);
					//获取每个列的列名
					//获取列的列名：getColumnName()
					//获取列的别名：getColumnLabel()
//					String columnName = rsmd.getColumnName(i+1); //不推荐使用
					String columnName = rsmd.getColumnLabel(i+1);
					
					//通过反射将t对象的指定列名的属性附上指定的列值
					Field field = clazz.getDeclaredField(columnName);
					field.setAccessible(true);
					field.set(t,columnValue);
					
				}
				list.add(t);
			}
			
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			JDBCUtils.closeResource(connection, ps, rs);
		}
		return null;
	}
	
	
	@Test
	public void testGetInstance() {
		
		String sql = "select id,name,email from customers where id = ?";
		Customer customer = getInstance(Customer.class, sql, 12);
		System.out.println(customer);
		
		String sql1 = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
		Order order = getInstance(Order.class,sql1,2);
		System.out.println(order);
		
	}
	
	/**
	 * 针对于不同的表的通用的查询操作，返回表中的一条记录
	 * @param <T>
	 * @param clazz
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T> T getInstance(Class<T> clazz,String sql,Object...args) {
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
				T t = clazz.newInstance();
				for(int i = 0; i < columnCount; i++) {
					//获取每个列的值
					Object columnValue = rs.getObject(i+1);
					//获取每个列的列名
					//获取列的列名：getColumnName()
					//获取列的别名：getColumnLabel()
//					String columnName = rsmd.getColumnName(i+1); //不推荐使用
					String columnName = rsmd.getColumnLabel(i+1);
					
					//通过反射将t对象的指定列名的属性附上指定的列值
					Field field = clazz.getDeclaredField(columnName);
					field.setAccessible(true);
					field.set(t,columnValue);
				}
				
				return t;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			JDBCUtils.closeResource(connection, ps, rs);
		}
		return null;
		
	}
}
