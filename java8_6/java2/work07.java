package com.cheng.java2;

/**
 * @author nuonuo
 * @create 2020-08-28 12:48
 */
public class work07 {

    public static void main(String[] args) {
        System.out.println(reverseString1("I am a student"));
    }

//    将一个数组从左开始前k个字符进行旋转：左旋数组 。【不限语言】
//    如：将"abcdef"当k等于2时，进行旋转，得到结果为："cdefab"

    // 思路: 1.将字符串整体反转
//            2.将0~2的字串反转
//            3.将剩余的字符串反转

    private static String reverseString(String str, int k) {
        if (str == null || str.length() == 0 || k > str.length()) {
            return str;
        }
        StringBuilder sb1 = new StringBuilder(str.substring(0,k));
        StringBuilder sb2 = new StringBuilder(str.substring(k,str.length()));
        sb1.reverse();
        sb2.reverse();
        sb1.append(sb2);
        sb1.reverse();
        return sb1.toString();
    }

//    字符串逆置，如 "I am a student" 逆置为 "student a am I" 。【不限语言】
private static String reverseString1(String str) {
    if (str == null || str.length() == 0) {
        return str;
    }
    String[] split = str.split(" ");
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < split.length; i++) {
        StringBuilder sb = new StringBuilder(split[i]);
        sb.reverse();
        res.append(sb).append(' ');
    }
    res.deleteCharAt(res.length()-1).reverse();
    return res.toString();
}

}
