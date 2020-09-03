package com.cheng.java2;

/**
 * @author nuonuo
 * @create 2020-08-30 18:49
 */
public class work11 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.next();
//        System.out.println(NumberOfDigit(str));
        System.out.println(getOneTimeNumber(new int[]{3, 2, 6, 3, 1, 9, 2, 6, 1}));

    }
    //    输入一行字符，统计字符串中数字个数.【不限语言】
//    示例："bit666keji123" 数字的个数为：6个

    private static int NumberOfDigit(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int sum = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                sum++;
            }
        }
        return sum;

    }

/*    找出一组数字中的不重复的数字，数字构成为：1到n的序列，n是数组长度。只有一个不重复的数字，【空间复杂
    度O(1),时间O(n)平方，不能修改数组内容。不能对数组进行排序】【不限语言】*/
//    示例：int[] array = {3,2,6,3,1,9,2,6,1}; 出现1次的数字就是 9。

//    时间O(n)平方解法 ： 每遍历到一个数时，向左和右分别遍历，寻找有无相同的数
    private static int getOneTimeNumber(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int j = 0, k = i + 1; boolean flag = false;
            while (j < i) {
                if (array[j++] == array[i]) {
                    flag = true;
                    break;
                }
            }
            while (k < array.length) {
                if (array[k++] == array[i]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) { // 找到了不重复的数字
                return array[i];
            }
        }
        return Integer.MIN_VALUE;
    }

}
