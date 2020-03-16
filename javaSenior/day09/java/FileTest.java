package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File类的使用
 *
 * 1. File类的一个对象，代表一个文件或一个文件目录（俗称文件夹）
 * 2. File类是生命在java.io包下
 * 3. File类中涉及到相关文件或文件目录的创建，删除，重命名，修改时间，文件大小等方法。
 *    并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流来完成
 * 4. 后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的“终点”
 *
 *
 * @author nuonuo
 * @create 2020-03-16 10:03
 */
public class FileTest {
    /*
    1.如何创建File类的示例

    File(File parent, String child) 从父抽象路径名和子路径名字符串创建新的 File实例。
    File​(String pathname) 通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
    File​(String parent, String child) 从父路径名字符串和子路径名字符串创建新的 File实例。


    2.
    相对路径：相较于某个路径下，指明的路径
    绝对路径：包含盘符在内的文件或文件目录的路径

    3.路径分隔符
    windows:\\
    unix:/

     */

    /*

    常用方法
    1.获取功能
     */
    @Test
    public void test2(){
        File file = new File("hello.txt");
        File file1 = new File("d:\\io\\hi.txt");
        File file2 = new File("D:\\workspace_idea\\javaSenior");

        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(file.lastModified());
        System.out.println(new Date(file.lastModified()));

        System.out.println();

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());
        System.out.println();

        String[] list = file2.list();//返回一个字符串数组，用于命名此抽象路径名表示的目录中的文件和目录。
        for(String s : list){
            System.out.println(s);
        }
        System.out.println();
        File[] listFiles = file2.listFiles();//返回一个抽象路径名数组，表示此抽象路径名表示的目录中的文件。
        for(File f : listFiles){
            System.out.println(f);
        }


    }
    /*
    2.重命名
    boolean renameTo​(File dest) 重命名此抽象路径名表示的文件。

    比如：file.renameTo(file1)为例
       要想保证返回true,需要file在硬盘中是存在的，且file2不能存在

     */
    @Test
    public void test3(){
        File file = new File("hello.txt");
        File file1 = new File("D:\\io\\hi.txt");

        boolean renameTo = file.renameTo(file1);
        boolean renameTo1 = file1.renameTo(file);
        System.out.println(renameTo);
    }
    /*
    3.判断功能
     */
    @Test
    public void test4(){
        File file = new File("hello.txt");
        file = new File("hello1.txt");

        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
    }
    /*
    4.创建硬盘中对应的文件或文件目录
    boolean createNewFile() 当且仅当具有此名称的文件尚不存在时，创建文件
    boolean mkdir() 创建目录,如果上层目录不存在就不创建
    boolean mkdirs() 创建目录，包括任何必需但不存在的父目录，如果上层目录不存在，仍创建


    5.删除硬盘中的文件或文件目录

    删除注意事项：
    Java中的删除不走回收站
     */
    @Test
    public void test5() throws IOException {
        File file = new File("hi.txt");
        if(!file.exists()){
            file.createNewFile();
            System.out.println("创建成功");
        } else{//文件存在
            file.delete();
            System.out.println("删除成功");
        }
    }
    @Test
    public void test6(){
        //文件目录的创建
        File file = new File("d:\\io\\io1");
        boolean mkdir = file.mkdir();
        if (mkdir) {
            System.out.println("创建成功");
        }


    }

    @Test
    public void test1(){
        //构造器1
        File file = new File("hello.txt");//相对于当前module
        File file1 = new File("D:\\workspace_idea\\javaSenior\\day09\\hey.txt");

        System.out.println(file);
        System.out.println(file1);

        //构造器2:
        File file2 = new File("D:\\workspace_idea", "javaSenior");
        System.out.println(file2);

        //构造器3：
        File file3 = new File(file2,"hi.txt");
        System.out.println(file3);


    }
}

