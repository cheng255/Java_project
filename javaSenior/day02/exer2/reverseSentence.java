package com.cheng.exer2;

import java.util.Scanner;

/**
 *
 * @author nuonuo
 * @create 2021-03-18 23:00
 */
public class reverseSentence {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine(); // 使用正则表达式作为分割符.
            String[] strArray = str.split("[^a-zA-Z]+");
            for (int i = strArray.length - 1; i >= 2; i--) {
                System.out.print(strArray[i] + ' ');
            }
            if (strArray[0].length() == 0)
                //如果字符串数组的第一个元素是空串，那么下标为1的元素就是最后一个 要输出的元素，末尾不要再加空格
                System.out.println(strArray[1]);
            else
                System.out.println(strArray[1] + ' ' + strArray[0]);
        }
    }
}