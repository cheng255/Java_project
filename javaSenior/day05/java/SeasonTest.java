package com.atguigu.java;

/**
 * 一：枚举类的使用：
 * <p>
 * 1.枚举类的对象只有有限个，确定的
 * 2.当需要定义一组常量时，强烈建议使用枚举类
 * 3.如果枚举类中只有一个对象，则可以作为单例模式的实现方式
 * <p>
 * 二：如何定义枚举类
 * <p>
 * 方式一：自定义枚举类
 * <p>
 * 方式二：JKD5.0后，可以使用enum关键字定义枚举类
 *
 * 方式三：Enum类中的常用方法：
 *
 *      values():返回枚举类型的对象数组。该方法可以很方便的遍历所有的枚举值
 *      valueOf(String str):可以把一个字符串转为相应的枚举类对象。要求字符串必须是枚举类对象
 *      toString():返回当前枚举类对象常量的名称
 *
 * 四：使用enum关键字定义的枚举类实现接口的情况
 *
 *     情况一：实现接口，在enum类中实现抽象方法
 *     情况二：
 *
 *
 * @author nuonuo
 * @create 2020-03-12 11:02
 */
public class SeasonTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }
}

//自定义枚举类
class Season {

    //1.声明Season对象的属性:private final
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器,并给对象属性赋值

    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }


    //3.提供当前枚举类的多个对象
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMU = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","冰天雪地");

    //4.其他需求


    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
