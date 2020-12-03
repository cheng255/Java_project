package com.cheng.exer1;

import java.util.*;

/**
 * n个数中最小的k个
 *
 * 用容量为k的大根堆
 * @author nuonuo
 * @create 2020-12-01 22:38
 */
public class T7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scan.hasNext()) {
            list.add(scan.nextInt());
        }
        int k = list.remove(list.size() - 1);
        Queue<Integer> heap = new PriorityQueue<>(k, (o1, o2)-> o2 - o1);
        int i = 0;
        for (; i < k; i++) {
            heap.add(list.get(i));
        }
        for (; i < list.size(); i++) {
            if (list.get(i) < heap.peek()) {
                heap.poll();
                heap.add(list.get(i));
            }
        }
        int[] res = new int[k];
        for (int j = k - 1; j >= 0; j--) {
            res[j] = heap.poll();
        }
        for (int j = 0; j < k; j++) {
            System.out.print(res[j] + " ");
        }
    }
}
