package com.cheng.test3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// stream —— 流式用法
public class StreamDemo {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7 };
        List<Integer> list = arrayToList(array);
        System.out.println(list);
    }

    private static List<Integer> arrayToList(int[] array) {
        return Arrays.stream(array).boxed().map(i -> 2 * i).collect(Collectors.toList());
    }

    private static List<Integer> arrayToList2(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                list.add(array[i]);
            }
        }
        return list;
    }
}
