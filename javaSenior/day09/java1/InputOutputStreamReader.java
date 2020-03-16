package com.atguigu.java1;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 处理流之二：转换流的作用
 *
 * 1.转换流：属于字符流
 *      InputStreamReader ：将一个字节的输入流转化为字符的输入流
 *      OutputStreamWriter ：将一个字符的输出流转化为字节的输出流
 *
 * 2.作用：提供字节流和字符流之间的转换
 *
 * 3.编码解码
 *
 *
 * 4.字符集
 *
 *
 *
 * @author nuonuo
 * @create 2020-03-16 16:38
 */
public class InputOutputStreamReader {
    @Test
    public void test(){
        InputStreamReader isr = null;//使用系统默认的字符集
        try {
            FileInputStream fis = new FileInputStream("hello.txt");
            isr = new InputStreamReader(fis);
            //指明了字符集,具体使用哪个字符集，取决于文件保存时使用的字符集
            //InputStreamReader isr = new InputStreamReader(fis,"UTF-8");

            char[] cbuf = new char[5];
            int len;
            while ((len = isr.read(cbuf)) != -1){
                String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
