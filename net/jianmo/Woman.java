package com.cheng.jianmo;

/**
 * @author nuonuo
 * @create 2020-11-19 21:23
 */
public class Woman implements CharacterSuitable {
    int age;//年龄
    String name;//姓名
    double[] looks;//外貌
    double income;//收入
    double[] nineCharacterSuit;//对于9种性格的匹配度
    double[] character;//性格分布
    String[] hobby;//爱好

    private int[][] characterSuits;

    public Woman() {
        initCharacterSuits();
    }

    public Woman(int age, String name, double[] looks, double income, double[] character, String[] hobby) {
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
     * 初始化女生的性格契合表
     */
    private void initCharacterSuits() {
        characterSuits = new int[][]{
                {80, 100, 90, 90, 70, 90, 80, 70, 80},
                {90, 100, 90, 90, 90, 80, 70, 70, 70},
                {100, 100, 70, 90, 70, 90, 80, 70, 90},
                {90, 100, 70, 80, 70, 100, 70, 70, 80},
                {90, 100, 80, 80, 80, 80, 80, 80, 80},
                {90, 100, 70, 100, 80, 90, 80, 80, 80},
                {80, 100, 80, 100, 70, 80, 80, 70, 90},
                {100, 100, 70, 100, 70, 90, 70, 70, 80},
                {90, 100, 80, 100, 70, 90, 80, 70, 80}
        };
    }

    @Override
    public String toString() {
        return name + "\t" + age;
    }

    /**
     * 找到女生对于男生九种性格的契合分布 等于该性格的占比 * 该性格在契合表中的分值
     *
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
                nineCharacterSuit[j] += character[i] * characterSuits[i][j] / 100;
            }
        }
        return;
    }
}
