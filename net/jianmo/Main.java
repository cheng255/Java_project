package com.cheng.jianmo;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.首先假设拥有一定的客户量，将客户存入manList 和 womanList，客户信息由客户填写问题表单的答案决定
 * 2.新来的客户拥有一套个人信息，包括年龄 性别 姓名     外貌测试的分值 收入的分值 性格测试的结果 爱好列表
 * 3.算法需要 得到 客户的 A.外貌分值 B.收入分值 C.对于9种性格的匹配度 D. ③个重要性格和对应比重 E. 爱好列表
 * 4.匹配操作
 *      4.1 根据用户的A 匹配所有异性的A1   默契度 a = 1 - (A - A1) / (A + A1);
 *      4.2 根据用户的B 匹配所有异性的B1   默契度 b = 1 - (B - B1) / (B + B1);
 *      4.3 根据用户的C 匹配所有异性的D    默契度 c = (求和)D1[i]*C[i]
 *      4.4 根据用户的E 匹配所有异性的E    默契度 e = 相同的爱好/所有选中的爱好
 *      4.5 根据用户设置的权值来最后计算与异性的默契度，得到该客户与所有异性的契合度列表
 */

public class Main {

    public static void main(String[] args) {
        List<Woman> womanList = new ArrayList<>();
        Man m1 = new Man();//有一位男性客户，准备匹配
        init(m1);
        List<Woman> match = match(m1, womanList);
    }

    /**
     * 匹配算法
     * 分为四步匹配
     * @return
     */
    private static List<Woman> match(Man m1, List<Woman> womanList) {
        List<Double> matchs = new ArrayList<>();
        //1.外貌 根据公式     ==>  外貌权重 *



        return womanList;
    }

    private static void init(Man m1) {
        m1.name = "小明";
        m1.age = 18;
        m1.sex = 1;//男
        m1.looks = new double[]{1,2,3};//外貌
        m1.income = 70;//收入
        m1.hobby = new String[]{"A", "B", "C"};
        m1.character = new double[]{0.1,0.4,0,0.05,0.23,0.07,0,0.05,0.1};//性格分布
        m1.getNineCharacterSuit();//对于9种性格的匹配度
    }


}
