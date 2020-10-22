package com.cheng.exer;

/**
 * @author nuonuo
 * @create 2020-10-13 18:47
 */

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}

class MyLinkedList {
    Node root;

    public MyLinkedList() {
        this.root = null;
    }

    /*
    头插
     */
    public void insertFrist(int val) {
        if (root == null) {
            root = new Node(val);
            return;
        }
        Node node = new Node(val);
        node.next = root;
        root = node;
    }

    /*
    尾插
     */
    public void insertLast(int val) {
        if (root == null) {
            root = new Node(val);
            return;
        }
        Node cur = root;
        while (cur.next != null) {
            cur = cur.next;
        }
        //此时cur是最后
        cur.next = new Node(val);
    }

    public void show() {
        if (root == null) {
            System.out.println("链表为空");
            return;
        }
        for (Node cur = root; cur != null; cur = cur.next) {
            System.out.println(cur);
        }

    }

}

public class somePros {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.insertFrist(1);
        list.insertLast(2);
        list.insertFrist(3);
        list.insertFrist(4);
        list.insertFrist(5);
        list.show();
    }


}
