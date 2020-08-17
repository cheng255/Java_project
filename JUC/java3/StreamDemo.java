package com.cheng.book.java3;

import java.util.Arrays;
import java.util.List;

/**
 * @author nuonuo
 * @create 2020-05-22 9:18
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 10, 8);


        System.out.println("count=" + list.stream().count());

        list.stream().filter(t -> {
            return t % 2 == 0;
        }).filter(u -> {
            return u % 5 == 0;
        }).forEach(System.out::println);


    }
}
