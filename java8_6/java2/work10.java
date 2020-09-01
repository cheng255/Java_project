package com.cheng.java2;

/**
 * @author nuonuo
 * @create 2020-08-29 19:19
 */
public class work10 {
/*    请你写一个函数 StrToInt ，实现把字符串转换成整数(int)这个功能。 不能使用 Integer.valueOf() 函数。要求不
    能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0，如果转换后的数字，超过了
    整形的最大值或者最小值，那么函数只需 返回最大值或者最小值。【不限语言】*/
/*    示例一： "2147483647"==》2147483647
      示例二：超过了整形的最大值 用int的最大值表示 "2147483648"==》2147483647
    示例三：数值不合法 "123abcd"==》 0*/

//思路： 用long类型的变量

    public static void main(String[] args) {
        System.out.println(StrToInt("-21474"));
    }

    private static int StrToInt(String str) {
        if (str.length() > 11) { //最多为-2147483648，有11位
            return 0;
        }
        boolean flag = true; //默认正数
        if (str.charAt(0) == '-') {
            flag = false;
            str = str.substring(1);
        }
        long n = 0;
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (!Character.isDigit(temp)) {
                return 0;
            }
            //小知识点： char类型的数字转化为int类型的数字   不能直接转换  可以使用 a - '0' 减去‘0’的方式
            n += (temp - '0') * Math.pow(10, str.length() - i - 1);


        }
        if (flag) {
            // 正数
            return n < Integer.MAX_VALUE ? (int) n : Integer.MAX_VALUE;
        }
        return -n > Integer.MIN_VALUE ? (int) -n : Integer.MIN_VALUE;
    }


}
