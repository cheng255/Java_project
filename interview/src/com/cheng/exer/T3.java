package com.cheng.exer;

/**
 * @author nuonuo
 * @create 2021-01-20 12:52
 */
public class T3 {
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(8);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(9);
        System.out.println(partition(node, 3));
    }
    private static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "val=" + val + next;
        }
    }
    public static ListNode partition(ListNode pHead, int x) {
        // write code here
        //定义4个变量 分别是小于x的节点头尾  和大于等于x结点头尾
        ListNode preS = new ListNode(-1), lastS = preS, preB = new ListNode(-1), lastB = preB;
        while (pHead != null) {
            if (pHead.val < x) {
                lastS.next = pHead;
                lastS = pHead;
            } else {
                lastB.next = pHead;
                lastB = pHead;
            }
            pHead = pHead.next;
        }
        lastS.next = preB.next;
        return preS.next;
    }
}
