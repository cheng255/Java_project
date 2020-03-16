package com.atguigu.java1;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之三：对象流
 * <p>
 * <p>
 * 重点：对象序列化机制
 * <p>
 *     1.
 * ObjectInputStream （序列化，保存）
 * ObjectOutputStream （反序列化，读取）
 *
 * 注意：自定义类需要满足如下要求，才能序列化
 * 见Person类
 *
 * @author nuonuo
 * @create 2020-03-16 17:37
 */
public class ObjectInputOutputStreamTest {
    /*
    序列化过程：将内存中的java对象保存到磁盘中或者通过网络传输出去
    使用ObjectOutputStream实现
     */
    @Test
    public void testObjectOutputStream() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            oos.writeObject(new String("我爱中国"));

            oos.flush();

            oos.writeObject(new Person("慧慧",10));

            oos.flush();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    /*
    反序列化过程: 将磁盘文件中的对象还原为内存中的一个java对象
     */
    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object object = ois.readObject();
            String str = (String) object;
            Person p = (Person)ois.readObject();

            System.out.println(str);
            System.out.println(p);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }



}
