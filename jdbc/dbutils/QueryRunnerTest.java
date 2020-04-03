package com.atguigu3.dbutils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.atguigu1.util.JDBCUtils;
import com.atguigu2.bean.Customer;

/*
 * commons-dbutils 是 Apache 组织提供的一个开源 JDBC工具类库,封装了针对于数据库的增删改查操作
 * 
 * 
 */
public class QueryRunnerTest {
	//测试插入
	@Test
	public void testInsert() {
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection1();
			String sql = "insert into customers(name,email,birth)values(?,?,?)";
			int insertCount = runner.update(conn, sql, "蔡徐坤","caixukun@126.com","1997-02-10");
			System.out.println("添加了" + insertCount + "条记录");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			JDBCUtils.closeResource(conn, null);
		}
		
	}
	
	//测试查询
	/*
	 * BeanHandler:是ResultSetHandler接口的一个实现类，用于封装表中的一条记录
	 */
	@Test
	public void testQuery() {
		
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			
			conn = JDBCUtils.getConnection1();
			String sql = "select id,name,email,birth from customers where id=?";
			
			BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);
			
			Customer customer = runner.query(conn, sql, handler, 18);
			System.out.println(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			JDBCUtils.closeResource(conn, null);
		}
		
	}
	/*
	 * BeanListHandler:用于封装表中的多条记录构成的集合
	 */
	@Test
	public void testQuery1() {
		
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			
			conn = JDBCUtils.getConnection1();
			String sql = "select id,name,email,birth from customers where id<?";
			
			BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);
			
			List<Customer> list = runner.query(conn, sql, handler, 18);
			list.forEach(System.out::println);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
			
		}
		
		
	}
	/*
	 * MapHandler:  对应表中的一条记录，将字段和对应的值以map键值对的形式呈现
	 */
	@Test
	public void testQuery2() {
		
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			
			conn = JDBCUtils.getConnection1();
			String sql = "select id,name,email,birth from customers where id=?";
			
			MapHandler handler = new MapHandler();
			
			Map<String, Object> map = runner.query(conn, sql, handler, 18);
			System.out.println(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
			
		}
			
	}
	
	/*
	 * MapListHandler:  对应表中的多条记录，每一条将字段和对应的值以map键值对的形式呈现，将这些map添加
	 * 到list中
	 */
	@Test
	public void testQuery3() {
		
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			
			conn = JDBCUtils.getConnection1();
			String sql = "select id,name,email,birth from customers where id<?";
			
			MapListHandler listHandler = new MapListHandler();
			
			List<Map<String,Object>> list = runner.query(conn, sql, listHandler, 18);
			list.forEach(System.out::println);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
			
		}
			
	}
	
	/*
	 * ScalarHandler:  用于查询特殊值
	 */
	@Test
	public void testQuery4() {
		
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			
			conn = JDBCUtils.getConnection1();
			String sql = "select count(*) from customers";
			
			ScalarHandler handler = new ScalarHandler();
			
			long count = (long)runner.query(conn, sql, handler);
			System.out.println(count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
			
		}
			
	}
	
	@Test
	public void testQuery5() {
		
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			
			conn = JDBCUtils.getConnection1();
			String sql = "select max(birth) from customers";
			
			ScalarHandler handler = new ScalarHandler();
			
			Date maxBirth = (Date)runner.query(conn, sql, handler);
			System.out.println(maxBirth);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
			
		}
			
	}

}
