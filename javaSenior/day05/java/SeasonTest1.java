package com.atguigu.java;

/**
 *
 * 使用enum定义枚举类
 *
 *
 * @author nuonuo
 * @create 2020-03-12 11:19
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
        //toString
        System.out.println(spring);
//        System.out.println(Season1.class.getSuperclass());//class java.lang.Enum

        //values()
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        System.out.println("*******");

        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }

        //valueOf(String objName):返回枚举类中对象名为objName的对象
        Season1 autumn = Season1.valueOf("AUTUMN");
        System.out.println(autumn);
        //如果没有objName的枚举类对象，则抛出异常：IllegalArgumentException
//        System.out.println(Season1.valueOf("Winter"));

        //实现接口测试
        for (int i = 0; i < values.length; i++) {
            values[i].show();
            
        }



    }
}
interface Info{
    void show();

}

//enum定义枚举类
enum Season1 implements Info{//继承于class java.lang.Enum
    //1.提供当前枚举类的多个对象
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天到了");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天到了");
        }
    },
    AUTUMN("秋天","秋高气爽"),
    WINTER("冬天","冰天雪地");

    //2.声明Season对象的属性:private final
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化类的构造器,并给对象属性赋值


    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }


    //4.其他需求

    //不需要重写toString


    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public void show() {
        System.out.println("其他季节");
    }

    //    @Override
//    public String toString() {
//        return "Season1{" +
//                "season1Name='" + seasonName + '\'' +
//                ", season1Desc='" + seasonDesc + '\'' +
//                '}';
//    }
}

