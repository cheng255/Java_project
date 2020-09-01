package com.cheng.java2;

/**
 * @author nuonuo
 * @create 2020-08-28 13:29
 */
public class work09 {

    public static void main(String[] args) {
        System.out.println(compression("aabbccdaa"));
    }

    //    将用户输入的字符串转化（压缩）。 【不限语言】
//    例如： "aabbccdaa" -> "a2b2c2d1a2" 或者 例如："abbcccffr" -> "a1b2c3f2r1"
    //思路：
    private static String compression(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int n = 0;
        for (int i = 0; i < str.length();i += n) {
            char temp = str.charAt(i);
            sb.append(temp);
            n = charNumber(temp, i, str);
            sb.append(n);
        }
        return sb.toString();
    }
    private static int charNumber(char c, int index, String str) {
        int n = 0;
        for (int i = index; i < str.length(); i++) {
            if (str.charAt(i) != c) {
                break;
            }
            n++;
        }
        return n;
    }
}
