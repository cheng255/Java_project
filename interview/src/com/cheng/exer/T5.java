package com.cheng.exer;

import java.util.Scanner;

/**
 * 密码验证合格程序
 * @author nuonuo
 * @create 2021-01-28 19:21
 */
public class T5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String words = in.nextLine();
            if (words.length() <= 8) {
                System.out.println("NG");
                continue;
            }
            boolean a = false, b = false, c = false, d = false;
            for (int i = 0; i < words.length(); i++) {
                if (Character.isDigit(words.charAt(i))) {
                    a = true;
                } else if (Character.isLowerCase(words.charAt(i))) {
                    b = true;
                } else if (Character.isUpperCase(words.charAt(i))) {
                    c = true;
                } else {
                    d = true;
                }
            }
            int num = 0;
            if (a) num++;
            if (b) num++;
            if (c) num++;
            if (d) num++;
            if (num >= 3) {
                //再判断是否有重复超过2个字符
                int i = 0;
                for (; i < words.length()-2; i++) {
                    //依次选择三个字符   判断后面的串里包不包含该两个字符
                    String sub = words.substring(i, i+3);
                    if (words.substring(i+3).contains(sub)) {
                        System.out.println("NG");
                        break;
                    }
                }
                if (i >= words.length()-2)
                    System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }
}
