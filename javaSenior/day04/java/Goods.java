package com.atguigu.java;

/**
 * @author nuonuo
 * @create 2020-03-11 18:30
 */
public class Goods implements Comparable{
    private int price;
    private String name;

    public Goods(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }




    //先按价格从低到高排序,再按照商品名称从低到高排序
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods)o;
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            }else{
//                return 0;
                return this.name.compareTo(goods.name); // 再按照商品名称从低到高排序
            }

        }
        throw new RuntimeException("传入的数据类型不一致");

    }
}
