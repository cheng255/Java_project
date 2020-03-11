package com.atguigu.exer;

/**
 * @author nuonuo
 * @create 2020-03-11 13:13
 */
public class StringDemo {

    /*
    将一个字符串进行反转。将指定部分进行反转，不如"abcdefg" --> "abfedcg"。
     */
    public static String reverse(String str, int startIndex, int endIndex){
        if (str == null) {
            return null;
        }
        if (startIndex > str.length() || startIndex < 0 || endIndex > str.length() || endIndex < 0) {
            return null;
        }
        char[] arr = str.toCharArray();
        for(int i = 0; i < (endIndex - startIndex + 1)/2; i++){
            char temp = arr[startIndex + i];
            arr[startIndex + i] = arr[endIndex - i];
            arr[endIndex - i] = temp;
        }
        String str1 = new String(arr);

        return str1;

    }


    public static void main(String[] args) {
        String str = "abcdefg";
        String str1 = reverse(str, 1, 5);
        System.out.println(str1);
    }
}
