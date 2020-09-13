package com.cheng.java3;

/**
 * @author nuonuo
 * @create 2020-09-10 21:40
 */

class A {
    public void a() {
        System.out.println("a");
    }

    public void b() {
        System.out.println("b");
    }

    public void c() {
        System.out.println("c");
    }
}
class B extends A {
    @Override
    public void a() {
        System.out.println("aa");
    }
    @Override
    public void b() {
        System.out.println("bb");
    }
    public void d() {
        System.out.println("d");
    }

    public void e() {
        System.out.println("e");
    }
}

public class Test02 {
    public static void main(String[] args) {
        A a = new B();
        a.a();
        a.b();
        a.c();
        ((B) a).d();
        ((B) a).e();
        A a1 = new A();
        a1.a(); //a
    }
}
