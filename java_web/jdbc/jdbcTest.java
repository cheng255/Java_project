package com.cheng.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * 查询“计算机系2019级1班”所有同学的成绩 要求显示班级信息，学生信息，课程信息，分数
 *select stu.id 'id', stu.sn '学号', stu.name '姓名', cls.name '班级', cou.name '课程', sco.score '成绩'
 * from student stu left join score sco on stu.id = sco.student_id
 * join classes cls on stu.classes_id = cls.id
 * join course cou on sco.course_id = cou.id
 * order by stu.id;
 * @author nuonuo
 * @create 2020-11-16 13:11
 */
// select stu.id 'id', stu.sn '学号', stu.name '姓名', cls.name '班级', cou.name '课程', sco.score '成绩'from student stu left join score sco on stu.id = sco.student_id join classes cls on stu.classes_id = cls.id and cls.name = '计算机系2019级1班' join course cou on sco.course_id = cou.id order by stu.id;
public class jdbcTest {
    public static void main(String[] args) {
        InputStream is = null;
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //1.读取配置信息
            Properties pros = new Properties();
            is = jdbcTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
            pros.load(is);
            String driverClass = pros.getProperty("driverClass");
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");

            //2.加载jdbc驱动
            Class.forName(driverClass);
            //3.连接数据库
            conn = DriverManager.getConnection(url,user,password);
            statement = conn.createStatement();
            String sql = "select stu.id 'id', stu.sn '学号', stu.name '姓名', " +
                    "cls.name '班级', cou.name '课程', sco.score '成绩'" +
                    "from student stu " +
                    "left join score sco on stu.id = sco.student_id " +
                    "join classes cls on stu.classes_id = cls.id " +
                    "and cls.name = '计算机系2019级1班' " +
                    "join course cou on sco.course_id = cou.id order by stu.id ";
            //4.执行查询操作，并且处理结果集
            resultSet = statement.executeQuery(sql);
            List<Inf> list = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int sn = resultSet.getInt("学号");
                String name = resultSet.getString("姓名");
                String classesName = resultSet.getString("班级");
                String course = resultSet.getString("课程");
                BigDecimal score = resultSet.getBigDecimal("成绩");
                Inf inf = new Inf(id, sn, name, classesName, course, score);
                list.add(inf);
            }
            Iterator<Inf> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                conn.close();
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
