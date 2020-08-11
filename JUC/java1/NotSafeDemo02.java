package com.cheng.book.java1;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author nuonuo
 * @create 2020-05-07 19:07
 * <p>
 * ArrayList HashSet HashMap 线程不安全
 * 1.故障现象
 * java.util.ConcurrentModificationException
 * 2.导致原因
 * 3.解决方法
 * 3.1 new Vector<>()
 * 3.2 Collections.synchronizedList(new ArrayList<>())
 * 3.3（建议使用）
 * 4.优化建议
 */
public class NotSafeDemo02 {
    public static void main(String[] args) {

        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
