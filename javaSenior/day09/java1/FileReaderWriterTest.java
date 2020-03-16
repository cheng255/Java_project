package com.atguigu.java1;

import org.junit.Test;

import java.io.*;

/**
 * 一：流的分类   按照：
 * 1. 操作数据单位：字节流，字符流
 * 2. 数据流向：输入流，输出流
 * 3. 流的角色：节点流，处理流
 *
 * 二：流的体系结构：
 * 抽象基类              节点流(或文件流)              缓冲流（处理流的一种）
 * InputStream          FileInputStream             BufferedInputStream
 * OutputStream         FileOutputStream            BufferedOutputStream
 * Reader               FileReader                  BufferedReader
 * Writer               FileWriter                  BufferedWriter
 *
 *
 *
 * 测试FileReader和FileWriter
 *
 * @author nuonuo
 * @create 2020-03-16 12:01
 */
public class FileReaderWriterTest {

    /*
    将day09下的hello.txt文件内容读入程序中，并输出到控制台



    说明知识点：
    1. read()的理解：返回读入的一个字符，如果达到文件末尾，返回-1
    2.异常的处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理

    字符流不能处理图片

     */
    @Test
    public void testFileReader() {
        //1.实例化File类的对象，指明要操作的文件
        File file = new File("hello1.txt");//相较于当前Module
        FileReader fr = null;

        try {
            //2.提供具体的流
            fr = new FileReader(file);

            //3.数据的读入
            //read():返回读入的一个字符。如果达到文件末尾，返回-1
            //方式一
//        int data = fr.read();
//        while (data != -1) {
//            System.out.print((char) data);
//            data = fr.read();
//        }
            //方式二:语法上修改
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭操作
            try {
                if(fr != null)//防止NullPointerException
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //对read()操作升级： 使用read()的重载方法
    @Test
    public void testFileReader1() {
        FileReader fr = null;
        try {
            //1.file类的实例化
            File file = new File("hello.txt");
            //2.FileReader流的实例化
            fr = new FileReader(file);
            //3.读入操作
            //read(char[] cbuf):返回每次读入cbuf数组中的字符个数，如果达到文件末尾返回-1
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                //方式一：
//                for(int i = 0; i < len; i++){
//                    System.out.print(cbuf[i]);
//                }
                //方式二：
                String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                //4.资源的关闭
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    /*
    从内存中写出数据到硬盘的文件


    说明：
    1. 输出操作，对应的File可以不存在的
    2.
       File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件
            如果存在:
                根据构造器可以选择覆盖原有文件或是在原有文件上追加内容
     */

    @Test
    public void testFileWriter() {
        //1.提供File类的对象,指明写出到的文件
        File file = new File("hello1.txt");
        FileWriter fw = null;

        try {
            //2.提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file,true);

            //3.写出的操作
            fw.write("I have a dream!\n");
            fw.write("you need to have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

    @Test
    public void testFileReaderWriter() {
        //1. 创建File类的对象，指明读入和写出的文件
        File srcFile = new File("hello1.txt");
        File destFile = new File("hello2.txt");
        FileReader fr = null;
        FileWriter fw = null;

        try {
            //2. 创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            //3. 数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (fw != null) {

                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
