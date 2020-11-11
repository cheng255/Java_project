package com.cheng.jianmo;

/**
 *
 * 根据不同高度下的送风口（既y1的变化）下，找出满足条件的 y1区间
 * 送风口A：位置（x,y1） 送风速率 送风温度
 * 发热源B: 位置（x,y2） 发热速率 发热温度
 * 两者温度融合使得融合后的温度T在一定位置范围△X内 >= T0(温度需求量)
 *
 * @author nuonuo
 * @create 2020-11-08 16:53
 */


//送风口
class A {
    double y;//高度
    double speed;//风速
    double tele;//风温

    public A(double y, double speed, double tele) {
        this.y = y;
        this.speed = speed;
        this.tele = tele;
    }
}
//发热源
class B {
    double y;//高度
    double speed;//风速
    double tele;//风温

    public B(double y, double speed, double tele) {
        this.y = y;
        this.speed = speed;
        this.tele = tele;
    }
}

public class Test1 {
    private static double T0 = 23.0;//温度需求量每秒
    public static void main(String[] args) {
        A a = new A(10, 1, 18.0);
        B b = new B(0, 1, 29.0);
        a.tele = func1(a.y, b.y, a.tele,24);//到发热源时的冷风温度
        double T = (a.tele * a.speed + b.speed * b.tele) / 2;
        if (T > T0) {
            //如果每秒融合的温度高于T0
            System.out.println("当前高度不行" + a.y);
        } else if (func1(3, 0, T, 24) > T0) {
            //热扩散到边界的温度高于T0
            System.out.println("当前高度不行" + a.y);
        } else {
            System.out.println("当前高度ok" + a.y);
        }
    }


    /**
     *
     * @param x1 初始位置
     * @param x2 结束位置
     * @param t1 初始温度
     * @param t2 周围温度
     */
    public static double func1(double x1, double x2, double t1, double t2) {
         //1.周围温度大于初始温度
        //假设他每1单位长度融合一次，降低一次温度
        double step = 1;//步长表示假设每多少距离温度假定变化一次
        for (double i = x1; i <= x2; i -= step) {
            t1 = (t1 + t2) / 2;
        }
        return t1;
    }
}
