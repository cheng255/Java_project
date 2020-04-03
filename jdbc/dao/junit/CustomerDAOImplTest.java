package com.atguigu2.dao.junit;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Date;

import org.junit.Test;

import com.atguigu1.util.JDBCUtils;
import com.atguigu2.bean.Customer;
import com.atguigu2.dao.CustomerDAOImpl;

public class CustomerDAOImplTest {
	private CustomerDAOImpl dao = new CustomerDAOImpl();
	
	
	@Test
	public void testInsert() {
		Connection conn = null; 
		try {
			conn = JDBCUtils.getConnection();
			Customer cust = new Customer(1,"王五","wangwu@qq.com",new Date(551165333L));
			dao.insert(conn, cust);
			System.out.println("添加成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			JDBCUtils.closeResource(conn, null);
		}
	}

	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateConnectionCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCustomerById() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			
			Customer cust = dao.getCustomerById(conn, 1);
			System.out.println(cust);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			JDBCUtils.closeResource(conn, null);
			
		}
		
		
	}

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMaxBirth() {
		fail("Not yet implemented");
	}

}
