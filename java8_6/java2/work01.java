package com.cheng.java2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author nuonuo
 * @create 2020-08-17 10:14
 */
public class work01 {
    @Test
    public void test01() {
        int i = 15;
        i = i++;
        System.out.println("i:" + i);
        int i1 = 2;
        int j1 = i1++ * 3;
        System.out.println(j1);
        int i2 = 2;
        int j2 = ++i2 * 3;
        System.out.println(j2);
    }
    //在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个
//函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。时间复杂度小于O(n) ,空间复杂度O(1).
    private static boolean findNumber(int arr[][], int n) {
        //定义两个指针，刚开始指向arr[0][arr[0].length]
        //如果比n大就往左移动， 如果比n小就往下移动
        int i = 0, j = arr[0].length;
        boolean res = false;
        while (i < arr.length && j >= 0) {
            if (arr[i][j] > n) {
                j--;
            } else if (arr[i][j] < n) {
                i++;
            } else {
                res = true;
            }
        }
        return res;
    }

    @Test
    public void test02(){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        oddBeforeEven(arr);
        System.out.println(Arrays.toString(arr));
    }

    //调整数组中元素的位置，使得奇数位于偶数之前.
    private static void oddBeforeEven(int[] arr) {
        int l = 0,r = arr.length - 1;
        while (l < r) {
            while (l < r && (arr[l] + 1) % 2 == 0) {
                //找到偶数停
                l++;
            }
            while (l < r && (arr[r] + 1) % 2 != 0) {
                //找到奇数停
                r--;
            }
            if (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
    }
}



/*        四. 智力题
        有 1000 瓶药物，但是其中有一瓶是有毒的，小白鼠吃了一个星期以后就会死掉！请问，在一个星期内找出有毒的
        药物，最少需要多少只小白鼠？*/

//用二进制0和1表示小白鼠的生死，从而判断毒药水的编号
//1000的二进制是1111101000  有10位， 所以最少需要10个小白鼠




