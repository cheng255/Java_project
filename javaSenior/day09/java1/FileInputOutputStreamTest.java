package com.atguigu.java1;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * 测试 FileInputStream和FileOutputStream
 *
 *
 * 结论：
 * 1.对于文本文件（.txt .java .c .cpp），使用字符流处理
 * 2.对于非文本文件(.jpg .mp3 .mp4 .avi .doc .ppt)，使用字节流处理
 * 3.如果文本文件使用字节流不在内存层面读取，也可以使用
 *
 *
 * @author nuonuo
 * @create 2020-03-16 14:37
 */
public class FileInputOutputStreamTest {

    //字节流处理文本文件演示
    @Test
    public void testFileInputStream() {

        File file = new File("hello.txt");

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);

            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                String str = new String(buffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    字节流处理非文本文件
        实现图片复制
     */
    @Test
    public void test2(){
        File file = new File("图片1.jpeg");
        File file1 = new File("图片2.jpeg");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
    public void copyFile(String scrPath, String destPath){
        File file = new File(scrPath);
        File file1 = new File(destPath);
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Test
    public void testCopyFile(){

        long start = System.currentTimeMillis();

        copyFile("hello.txt","hello3.txt");

        long end = System.currentTimeMillis();

        System.out.println("赋值操作花费的时间为" + (end - start));
    }




}
