package com.cheng.exer2;

import java.util.Scanner;

/**
 * 计算日期到天数转换
 * @author nuonuo
 * @create 2021-03-14 20:50
 */
public class CalculateAateToAay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            //1.算month
            int res = getBeforeDay(year,month);
            System.out.println(res + day);
        }
    }
    private static int getBeforeDay(int year,int month) {
        int res = 0;
        month-=1;
        while (month > 0) {
            switch(month) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    res+=31;
                    break;
                case 2:
                    res+=28;
                    break;
                case 4: case 6: case 9: case 11:
                    res+=30;
                    break;
            }
            month--;
        }
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            ++res;
        }
        return res;
    }
}
