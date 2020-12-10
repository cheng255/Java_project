package org.example.test;

/**
 * 体现字段属性没有多态性
 * @author nuonuo
 * @create 2020-12-09 14:45
 */
public class FieldHasNoPolymorphic {
    /*** 字段不参与多态 * @author zzm */
    public static void main(String[] args) {
        Father gay = new Son();
        System.out.println("This gay has $" + gay.money);
    }

    static class Father {
        public int money = 1;

        public Father() {
            money = 2;
            showMeTheMoney();
        }

        public void showMeTheMoney() {
            System.out.println("I am Father, i have $" + money);
        }
    }

    static class Son extends Father {
        public int money = 3;

        public Son() {
            money = 4;
            showMeTheMoney();
        }

        public void showMeTheMoney() {
            System.out.println("I am Son, i have $" + money);
        }
    }

}
