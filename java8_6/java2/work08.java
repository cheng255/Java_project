package com.cheng.java2;

/**
 * @author nuonuo
 * @create 2020-08-28 13:22
 */
class HelloA {
    static {
        System.out.println("static A");
    }
    public HelloA() {
        System.out.println("HelloA");
    }
    {
        System.out.println("i am A class");
    }


}

public class work08 extends HelloA {



    static {
        System.out.println("static TestClass");
    }

    {
        System.out.println("i am TestClass");
    }

    public work08() {
        System.out.println("TestClass");
    }

    public static void main(String[] args) {
        new work08();
    }
}

