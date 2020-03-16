package com.atguigu.java1;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一： 缓冲流的使用
 * <p>
 * 1. 缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 * <p>
 * 2.作用： 提升流的读取，写入的速度
 *      原因：内部提供了一个缓冲区
 *
 * @author nuonuo
 * @create 2020-03-16 15:37
 */
public class BufferedTest {
    @Test
    public void testBufferedStream() {
        //1.造文件
        File srcFile = new File("图片1.jpeg");
        File destFile = new File("图片3.jpeg");
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //2.造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3. 复制的细节：读取，写入
            byte[] buffer = new byte[5];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer,0,len);

//                bos.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭： 要求先关闭外层的流，再关闭内层的流
            if(bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        //说明：在关闭外层流的同时，内层流也会自动的关闭，所以可以省略内层流的关闭操作
//        fos.close();
//        fis.close();

    }
    @Test
    public void testBufferStream(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("hello1.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello3.txt")));

            //读写操作
            //方式一：使用char[]数组
//            char[] cbuf = new char[1024];
//            int len;
//            while ((len = br.read(cbuf)) != -1) {
//                bw.write(cbuf,0,len);
//    //            bw.flush();
//
//            }
            //方式二：使用String
            String data;
            while ((data = br.readLine()) != null){
                bw.write(data + '\n');//data中不包含换行符
                //或者使用bw.newLine()换行
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
