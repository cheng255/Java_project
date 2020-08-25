package com.cheng.java2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author nuonuo
 * @create 2020-08-25 10:51
 */
public class work03 {

    public static void main(String[] args) {
        HashSet hashSet = new HashSet();

        Iterator it = hashSet.iterator();

        int a = 10;
        a += a *= a -= a / 3;
        System.out.println(a); //80

        int[] towNumber = getTowNumber2(new int[]{1, 2, 3, 4, 4, 5, 6, 7}, 7);
        System.out.println(Arrays.toString(towNumber));

    }
//    求一个有序数组中，两个值相加为key的数字，返回这两个数字的下标。时间复杂度是O(n)【不限语言】
//    示例：int[] array = {1,2,3,4,5,7,7,8}; key = 8 找到下标为：(0,6) 返回这两个值。

    // 方法一：定义HashMap   第一次遍历将元素和下标存入map， 第二次遍历
    private static int[] getTowNumber1(int[] arr, int n) {

    }

    // 方法二 定义前后指针， 依次判断两数之和
    private static int[] getTowNumber2(int[] arr, int n) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            if (arr[l] + arr[r] == n) {
                return new int[]{l , r};
            } else if (arr[l] + arr[r] < n) {
                l++;
            } else {
                r--;
            }
        }
        return new int[2];
    }
}

class Student implements Comparable{
    int age;
    String name;

    public Student() {
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Student) {
            Student o1 = (Student) o;
            return this.age - o1.age;
        }
        return -1;
    }
}
