package com.cheng.jianmo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author nuonuo
 * @create 2020-11-21 21:06
 */
public class test {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\workspace_idea\\javaSenior\\net\\woman.txt");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(fis);
        BufferedReader reader1 = new BufferedReader(reader);

        while (true) {
            String s = reader1.readLine();//一个人数据
            if (s == null) {
                break;
            }
            String[] split = s.split("\t");
            System.out.println(Arrays.toString(split));
            int index = 0;
            String name = split[index++];
            int age = Integer.parseInt(split[index++]);
            String[] triangularFuzzyNumber = split[index++].split(" ");
            double[] looks = new double[3];
            looks[0] = Double.parseDouble(triangularFuzzyNumber[0]);
            looks[1] = Double.parseDouble(triangularFuzzyNumber[1]);
            looks[2] = Double.parseDouble(triangularFuzzyNumber[2]);
            double income = Double.parseDouble(split[index++]);
            double[] character = new double[9];
            for (int i = 0; i < 9; i++) {
                character[i] = Double.parseDouble(split[index++]);
            }
            String[] hobby = new String[7];//爱好7个
            for (int i = 0; i < hobby.length; i++) {
                hobby[i] = split[index++];
            }
//            System.out.print(name + " " + age + " " + Arrays.toString(looks) + " " + income + " " + Arrays.toString(character)
//            + " " + Arrays.toString(hobby) + "\n");
            Woman woman = new Woman(age, name, looks, income, character, hobby);
            System.out.println(woman);

        }

    }
}
