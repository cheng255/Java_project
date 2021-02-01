package com.cheng.exer;

import java.util.Scanner;

/**
 * 牛客网  说反话
 * @author nuonuo
 * @create 2021-02-01 19:17
 */
public class T7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            String[] split = s.split(" ");
            for (int i = 0; i < split.length; i++) {
                if (i != 0) {
                    sb.append(" ");
                }
                sb.append(new StringBuilder(split[i]).reverse());
            }
            sb.reverse();
            System.out.println(sb.toString());
        }

    }
}
