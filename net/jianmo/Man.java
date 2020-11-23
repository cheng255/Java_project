package com.cheng.jianmo;

/**
 * 男生
 * @author nuonuo
 * @create 2020-11-14 19:51
 */
public class Man implements CharacterSuitable{
    int age;//年龄
    String name;//姓名
    double[] looks;//外貌三角模糊数
    double income;//收入分值
    double[] nineCharacterSuit;//对于9种性格的匹配度
    double[] character;//性格分布
    String[] hobby;//爱好

    private int[][] characterSuits;

    /**
     * 初始化男生的性格契合表
     */
    private void initCharacterSuits() {
        characterSuits = new int[][] {
                {70,70,80,70,90,80,80,80,100},
                {80,70,80,70,100,80,80,80,100},
                {100,70,70,70,90,80,90,80,100},
                {80,70,80,70,80,90,90,90,100},
                {80,80,70,70,100,90,80,80,90},
                {80,70,80,80,80,90,80,80,100},
                {80,70,90,70,90,90,80,80,100},
                {70,70,70,70,100,100,90,80,100},
                {80,70,90,70,80,90,90,80,90}
        };
    }

    public Man() {
        initCharacterSuits();
    }

    public Man(int age, String name, double[] looks, double income, double[] character, String[] hobby) {
        this.age = age;
        this.name = name;
        this.looks = looks;
        this.income = income;
        this.character = character;
        this.hobby = hobby;
        initCharacterSuits();
        getNineCharacterSuit();//内部初始化该属性
    }

    /**
     * 找到男生对于女生九种性格的契合分布 等于该性格的占比 * 该性格在契合表中的分值
     * @return
     */
    @Override
    public void getNineCharacterSuit() {
        if (this.character == null) {
            new RuntimeException("暂无性格，无法分析性格契合度");
        }
        nineCharacterSuit = new double[character.length];

        for (int i = 0; i < character.length; i++) {
            for (int j = 0; j < character.length; j++) {
                nineCharacterSuit[j] += character[i] * characterSuits[i][j]/100;
            }
        }
        return;
    }

    @Override
    public String toString() {
        return name + "\t" + age;
    }
}
