package com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nuonuo
 * @create 2020-03-15 12:44
 */
public class Order<T> {

    String orderName;
    int orderId;

    //类的内部结构就可以使用类的泛型
    T orderT;

    public Order(){

    }
    public Order(String orderName,int orderId,T orderT){
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;

    }
    public T getOrderT(){
        return orderT;
    }
    public void setOrderT(T orderT){
        this.orderT = orderT;
    }

    //静态方法中不能使用类的泛型
//    public static void show(){
//        System.out.println(orderT);
//    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    //泛型方法： 在方法中出现的泛型类狗，泛型方法所处的类是不是泛型类无所谓

    public <E>List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();

        for(E e : arr){
            list.add(e);
        }
        return list;


    }




}
