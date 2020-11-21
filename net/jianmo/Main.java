package com.cheng.jianmo;

import java.io.*;
import java.util.*;

/**
 * 1.首先假设拥有一定的客户量，将客户存入manList 和 womanList，客户信息由客户填写问题表单的答案决定
 * 2.新来的客户拥有一套个人信息，包括年龄 性别 姓名     外貌测试的分值 收入的分值 性格测试的结果 爱好列表
 * 3.算法需要 得到 客户的 A.外貌分值 B.收入分值 C.对于9种性格的匹配度 D. ③个重要性格和对应比重 E. 爱好列表
 * 4.匹配操作
 * 4.1 根据用户的A 匹配所有异性的A1   默契度 a = 1 - (A - A1) / (A + A1);
 * 4.2 根据用户的B 匹配所有异性的B1   默契度 b = 1 - (B - B1) / (B + B1);
 * 4.3 根据用户的C 匹配所有异性的D    默契度 c = (求和)D1[i]*C[i]
 * 4.4 根据用户的E 匹配所有异性的E    默契度 e = 相同的爱好/所有选中的爱好
 * 4.5 根据用户设置的权值来最后计算与异性的默契度，得到该客户与所有异性的契合度列表
 */

public class Main {
    //维护着一个女客户信息表和男客户信息表
    private static final List<Woman> womanList = new ArrayList<>();
    private static final List<Man> manList = new ArrayList<>();
    private static final int AGE_DIFFERENCE = 10;

    public static void main(String[] args) {
        init();
        //匹配的权值分配
        Man man = manList.get(0);
        double[] weight = new double[]{0.1, 0.5, 0.2, 0.2};
        HashMap<Woman, Double> match = match(man, weight, womanList);//按照匹配分数排序后的异性列表
        //遍历
        Set<Map.Entry<Woman, Double>> entries = match.entrySet();
        for (Map.Entry<Woman, Double> entry : entries) {
            System.out.println(entry);
        }

    }

    //初始化客户表
    private static void init() {
        initManList();
        initWomanList();
    }


    /**
     * 匹配度算法 （男）
     * 分为四步匹配
     *
     * @return
     */
    private static HashMap<Woman, Double> match(Man m, double[] weight, List<Woman> womanList) {
        HashMap<Woman, Double> matchs = new HashMap<>();
        //得到客户m的权值分布weight  分别是外貌 收入 性格 爱好

        for (Woman wm : womanList) {
            //1.外貌三角模糊数 -> 外貌契合度
            double a = getLooksMatch(m.looks, wm.looks) * weight[0];

            //2.收入分值 -> 收入契合度  （默契度 b = 1 - (B - B1) / (B + B1)）
            double b = getIncomeMatch(m.income, wm.income) * weight[1];

            //3.对于9种性格的匹配度  +  异性性格分布 -> 性格匹配度
            double c = getCharacterMatch(m.nineCharacterSuit, wm.character) * weight[2];
            //4.爱好列表 -> 爱好匹配度
            double d = getHobbyMatch(m.hobby, wm.hobby) * weight[3];
            //5.最终的契合度
            double finalMatch = a + b + c + d;
            if (Math.abs(wm.age - m.age) > AGE_DIFFERENCE) {//如果年龄超过AGE_DIFFERENCE限制，就不给与匹配
                matchs.put(wm, 0.0);
            } else {
                matchs.put(wm, finalMatch);//将 异性-契合度 存入容器
            }
        }
        //将异性列表按照契合度排序后返回
        return getMatchWomen(matchs);
    }

    /**
     * 匹配度算法 （女）
     * 分为四步匹配
     *
     * @return
     */
    private static HashMap<Man, Double> match(Woman wm, double[] weight, List<Man> manList) {
        HashMap<Man, Double> matchs = new HashMap<>();
        //得到客户m的权值分布weight  分别是外貌 收入 性格 爱好

        for (Man m : manList) {
            //1.外貌三角模糊数 -> 外貌契合度
            double a = getLooksMatch(m.looks, wm.looks) * weight[0];

            //2.收入分值 -> 收入契合度  （默契度 b = 1 - (B - B1) / (B + B1)）
            double b = getIncomeMatch(m.income, wm.income) * weight[1];

            //3.对于9种性格的匹配度  +  异性性格分布 -> 性格匹配度
            double c = getCharacterMatch(wm.nineCharacterSuit, m.character) * weight[2];

            //4.爱好列表 -> 爱好匹配度
            double d = getHobbyMatch(m.hobby, wm.hobby) * weight[3];
            //5.最终的契合度
            double finalMatch = a + b + c + d;
            if (Math.abs(wm.age - m.age) > AGE_DIFFERENCE) {//如果年龄超过AGE_DIFFERENCE限制，就不给与匹配
                matchs.put(m, 0.0);
            } else {
                matchs.put(m, finalMatch);//将 异性-契合度 存入容器
            }
        }
        //将异性列表按照契合度排序后返回
        return getMatchMen(matchs);
    }


    /**
     * 将女生列表按照契合度排序后返回
     *
     * @return
     */
    private static HashMap<Woman, Double> getMatchWomen(HashMap<Woman, Double> matchs) {
        Set<Map.Entry<Woman, Double>> set = matchs.entrySet();
        List<Map.Entry<Woman, Double>> list = new ArrayList<>(set);
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        Iterator<Map.Entry<Woman, Double>> iterator = list.iterator();
        HashMap<Woman, Double> res = new LinkedHashMap<>();
        for (Map.Entry<Woman, Double> womanDoubleEntry : list) {
            res.put(womanDoubleEntry.getKey(), womanDoubleEntry.getValue());
        }
        return res;

    }

    /**
     * 将男生列表按照契合度排序后返回
     *
     * @return
     */
    private static HashMap<Man, Double> getMatchMen(HashMap<Man, Double> matchs) {
        Set<Map.Entry<Man, Double>> set = matchs.entrySet();
        List<Map.Entry<Man, Double>> list = (List) set;
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        HashMap<Man, Double> res = new LinkedHashMap<>();
        for (Map.Entry<Man, Double> manDoubleEntry : list) {
            res.put(manDoubleEntry.getKey(), manDoubleEntry.getValue());
        }
        return res;
    }


    /**
     * @param m  男生的爱好
     * @param wm 女生的爱好
     * @return 爱好契合度 百分制
     */
    private static double getHobbyMatch(String[] m, String[] wm) {
        double sum = wm.length;//一共有的爱好个数
        double same = 0;//相同的爱好个数
        for (String b1 : m) {
            boolean flag = false;
            for (String b2 : wm) {
                if (b1.equals(b2)) {
                    flag = true;
                    same += 1;
                }
            }
            if (!flag) {//表示m的这个爱好在wm中没有
                sum += 1;
            }
        }
        double res = same / sum * 100;
        return res;
    }

    /**
     * 对于9种性格的匹配度  +  异性性格分布 -> 性格匹配度
     *
     * @param nineCharacterSuit 对于9种性格的匹配度
     * @param character         异性性格分布
     * @return 性格匹配度 百分制
     */
    private static double getCharacterMatch(double[] nineCharacterSuit, double[] character) {
        double res = 0;
        for (int i = 0; i < nineCharacterSuit.length; i++) {
            res += nineCharacterSuit[i] * character[i];
        }
        return res * 100;
    }

    /**
     * 计算收入的契合度 百分制
     *
     * @param m  男生的收入分值
     * @param wm 女生的收入分值
     * @return 收入的契合度
     */
    private static double getIncomeMatch(double m, double wm) {
        double res = 1 - Math.abs(m - wm) / (m + wm);
        return res * 100;
    }

    /**
     * 计算外貌的契合度 百分制
     *
     * @param m  男生的外貌三角模糊数
     * @param wm 女生的外貌三角模糊数
     * @return 外貌的契合度
     */
    private static double getLooksMatch(double[] m, double[] wm) {
        double res = Math.pow((m[0] - wm[0]), 2) + Math.pow((m[1] - wm[1]), 2) + Math.pow((m[2] - wm[2]), 2);
        res = Math.sqrt(Math.pow(res, 2) / 3);
        return res * 100;
    }


    private static void initWomanList() {
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader reader1 = null;
        try {
            File file = new File("D:\\workspace_idea\\javaSenior\\net\\woman.txt");
            fis = new FileInputStream(file);
            reader = new InputStreamReader(fis);
            reader1 = new BufferedReader(reader);

            while (true) {
                String s = reader1.readLine();//一个人数据
                if (s == null) {
                    break;
                }
                String[] split = s.split("\t");
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
                Woman woman = new Woman(age, name, looks, income, character, hobby);
                womanList.add(woman);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader1 != null) {
                    reader1.close();
                }
                if (reader != null) {
                    reader.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    private static void initManList() {
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader reader1 = null;
        try {
            File file = new File("D:\\workspace_idea\\javaSenior\\net\\man.txt");
            fis = new FileInputStream(file);
            reader = new InputStreamReader(fis);
            reader1 = new BufferedReader(reader);

            while (true) {
                String s = reader1.readLine();//一个人数据
                if (s == null) {
                    break;
                }
                String[] split = s.split("\t");
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
                Man man = new Man(age, name, looks, income, character, hobby);
                manList.add(man);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader1 != null) {
                    reader1.close();
                }
                if (reader != null) {
                    reader.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


}
