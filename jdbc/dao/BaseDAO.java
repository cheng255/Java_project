package com.atguigu2.dao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atguigu1.util.JDBCUtils;

/*
 * DAO:data(base) access object
 * 封装了针对于数据表的通用的操作
 * 
 */
public abstract class BaseDAO<T> {
	
	private Class<T> clazz = null;
	
//	public BaseDAO() {
//	}
	
	{
		//获取当前BaseDAO的子类继承的父类的泛型
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		ParameterizedType paramType = (ParameterizedType) genericSuperclass;
		Type[] typeArguments = paramType.getActualTypeArguments();//获取父类的泛型参数
		clazz = (Class<T>) typeArguments[0];//泛型的第一个参数
	}
	
	
	// 使用事务以后的通用的增删改操作（version 2.0）
	public void update(Connection conn, String sql, Object... args) {
		PreparedStatement ps = null;
		try {
			// 1.获取PreparedStatement的实例 (或：预编译sql语句)
			ps = conn.prepareStatement(sql);
			// 2.填充占位符
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			// 3.执行sql语句
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4.关闭资源
			JDBCUtils.closeResource(null, ps);

		}

	}

	/*
	 * 针对于不同的表的通用的查询操作，返回表中的一条记录（考虑事务）
	 * 
	 */
	public T getInstance(Connection conn, String sql, Object... args) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}

			// 执行，获取结果集
			rs = ps.executeQuery();
			// 获取结果集的元数据
			ResultSetMetaData rsmd = rs.getMetaData();
			// 获取列数
			int columnCount = rsmd.getColumnCount();
			if (rs.next()) {
				T t = clazz.newInstance();
				for (int i = 0; i < columnCount; i++) {
					// 获取每个列的值
					Object columnValue = rs.getObject(i + 1);
					// 获取每个列的列名
					// 获取列的列名：getColumnName()
					// 获取列的别名：getColumnLabel()
//					String columnName = rsmd.getColumnName(i+1); //不推荐使用
					String columnName = rsmd.getColumnLabel(i + 1);

					// 通过反射将t对象的指定列名的属性附上指定的列值
					Field field = clazz.getDeclaredField(columnName);
					field.setAccessible(true);
					field.set(t, columnValue);
				}

				return t;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			JDBCUtils.closeResource(null, ps, rs);
		}
		return null;

	}

	/*
	 * 
	 * 通用的查询操作，用于返回数据表中的多条数据记录构成的集合 （考虑事务）
	 */
	public List<T> getForList(Connection conn, String sql, Object... args) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}

			// 执行，获取结果集
			rs = ps.executeQuery();
			// 获取结果集的元数据
			ResultSetMetaData rsmd = rs.getMetaData();
			// 获取列数
			int columnCount = rsmd.getColumnCount();
			// 创建集合对象
			ArrayList<T> list = new ArrayList<T>();
			while (rs.next()) {
				T t = clazz.newInstance();
				// 处理结果集每一行数据中的每一个列：给t对象指定的属性赋值的过程
				for (int i = 0; i < columnCount; i++) {
					// 获取每个列的值
					Object columnValue = rs.getObject(i + 1);
					// 获取每个列的列名
					// 获取列的列名：getColumnName()
					// 获取列的别名：getColumnLabel()
//					String columnName = rsmd.getColumnName(i+1); //不推荐使用
					String columnName = rsmd.getColumnLabel(i + 1);

					// 通过反射将t对象的指定列名的属性附上指定的列值
					Field field = clazz.getDeclaredField(columnName);
					field.setAccessible(true);
					field.set(t, columnValue);

				}
				list.add(t);
			}

			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			JDBCUtils.closeResource(null, ps, rs);
		}
		return null;
	}
	/*
	 * 用于查询特殊值的通用方法
	 * 
	 */
	@SuppressWarnings("unchecked")
	public<E> E getValue(Connection conn,String sql,Object...args) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
			
			rs = ps.executeQuery();
			if(rs.next()) {
				return (E)rs.getObject(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			JDBCUtils.closeResource(null, ps, rs);
		}
		
		return null;
	}
	
	
	
	
	
	
}
