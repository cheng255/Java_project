package com.cheng.jianmo;

/**
 * @author nuonuo
 * @create 2020-11-19 21:23
 */
public class Woman {
    int age;//年龄
    String name;//姓名

    double looks;//外貌
    double income;//收入
    double[] nineCharacterSuit;//对于9种性格的匹配度
    double[] character;//性格分布
    String[] hobby;//爱好

    public Woman() {
    }

    public Woman(int age, String name, double looks, double income, double[] nineCharacterSuit, double[] character, String[] hobby) {
        this.age = age;
        this.name = name;
        this.looks = looks;
        this.income = income;
        this.nineCharacterSuit = nineCharacterSuit;
        this.character = character;
        this.hobby = hobby;
    }
}
