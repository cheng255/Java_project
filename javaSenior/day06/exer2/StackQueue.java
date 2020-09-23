package com.atguigu.exer2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author nuonuo
 * @create 2020-09-23 20:49
 */
public class StackQueue {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

}


class MyQueue {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void offer(int val) {
        stack2.push(val);
    }
    public int poll() {
        if (!stack1.isEmpty()) {
            return stack1.pop();
        }
        if (stack2.isEmpty()) {
            throw new RuntimeException("没有元素了");
        }
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return stack1.pop();
    }
}
