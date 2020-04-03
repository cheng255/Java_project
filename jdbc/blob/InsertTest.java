package com.atguigu4.blob;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.atguigu3.util.JDBCUtils;

/*
 * 使用PreparedStatement实现批量数据的操作
 * 
 * update delete本身就有批量操作的效果
 * 
 * 此时的批量操作，主要是指批量插入，使用PreparedStatement如何实现更高效的批量插入
 * 
 * 
 * 优化操作：使用批处理：1：addBatch()  executeBatch()  clearBatch()
 * 			2.mysql服务器默认是关闭批处理的，我们需要通过一个参数，让mysql开启批处理的支持
 * 					?rewriteBatchedStatements=true 写在配置文件的url后面
 * 			3.使用更新的mysql驱动，mysql-connector-java-5.1.37-bin.jar
 */
public class InsertTest {

	@Test
	public void testInsert() {
		
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			long start = System.currentTimeMillis();
			connection = JDBCUtils.getConnection();
			//优化：设置不允许自动提交数据
			connection.setAutoCommit(false);
			
			String sql = "insert into goods(name)values(?)";
			ps = connection.prepareStatement(sql);
			for(int i = 1; i <= 20000; i++) {
				ps.setObject(1, "name_" + 1);
				
				//1.攒
				ps.addBatch();
				
				if(i % 500 == 0) {
					//2.执行
					ps.executeBatch();
					
					//3.清空
					ps.clearBatch();
				}
			}
			
			//统一提交
			connection.commit();
			
			long end = System.currentTimeMillis();
			
			System.out.println(end-start);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			JDBCUtils.closeResource(connection, ps);
		}
		
		
	}

}
