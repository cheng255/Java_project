package com.atguigu.exer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nuonuo
 * @create 2021-01-19 9:28
 */
public class FileText {
    public static void main(String[] args) {
        File dir = new File("D:\\program\\api");
        List<File> files = listDir(dir);
        //jdk1.8集合框架使用stream操作 可以lambda表达式
        files.stream().forEach(System.out::println);
    }

    //打印文件夹下所有文件（不包含文件夹）
    public static List<File> listDir(File dir) {
        List<File> list = new ArrayList<>();
        File[] children = dir.listFiles();
        if (children != null) {
            for (File child : children) {
                if (child.isDirectory()) {
                    list.addAll(listDir(child));
                } else {
                    list.add(child);
                }
            }
        }
        return list;
    }
}
