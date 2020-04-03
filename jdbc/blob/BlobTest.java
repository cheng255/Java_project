package com.atguigu4.blob;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.atguigu3.bean.Customer;
import com.atguigu3.util.JDBCUtils;

/**
 * 
 * 测试使用PreparedStatement操作Blob类型的数据
 * 
 * @author 86182
 *
 */
public class BlobTest {
	// 向数据表中插入Blob类型的字段
	@Test
	public void testInsert() throws Exception {
		Connection connection = JDBCUtils.getConnection();
		String sql = "insert into customers(name,email,birth,photo)values(?,?,?,?)";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setObject(1, "张三");
		ps.setObject(2, "zhangsan@qq.com");
		ps.setObject(3, "1999-10-04");
		FileInputStream fis = new FileInputStream(new File("图片1.jpeg"));
		ps.setBlob(4, fis);
		
		ps.execute();
		
		JDBCUtils.closeResource(connection, ps);
		
		
	}
	
	
	//查询数据表customers中Blob类型的字段
	@Test
	public void testQuery() {
		
		FileOutputStream fos= null;
		InputStream is = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = JDBCUtils.getConnection();
			String sql = "select id,name,email,birth,photo from customers where id = ?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, 27);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date birth = rs.getDate("birth");
				
				Customer cust = new Customer(id, name, email, birth);
				System.out.println(cust);
				//将Blob类型的字段下载下来保存在本地
				Blob photo = rs.getBlob("photo");
				is = photo.getBinaryStream();
				fos = new FileOutputStream("图片2.jpeg");
				
				byte[] buffer = new byte[1024];
				int len;
				while((len = is.read(buffer)) != -1) {
					fos.write(buffer, 0, len);
				}
					
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(is != null)
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if(fos != null)
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			JDBCUtils.closeResource(connection, ps, rs);
			
		}
		
		
		
		
	}

}
