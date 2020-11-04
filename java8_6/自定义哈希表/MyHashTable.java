package com.cheng.自定义哈希表;

// 元素类型，使用 Integer
// 使用拉链法解决冲突
public class MyHashTable {
    // 1. 数组
    private Node[] array = new Node[11];
    // 2. 维护哈希表中的有的元素个数
    private int size;

    // true: key 之前不在哈希表中
    // false: key 之前已经在哈希表中
    public boolean insert(Integer key) {

        // 1. 把对象转成 int 类型
        // hashCode() 方法的调用是核心
        int hashValue = key.hashCode();
        // 2. 把 hashValue 转成合法的下标
        int index = hashValue % array.length;
        // 3. 遍历 index 位置处的链表，确定 key 在不在元素中
        Node current = array[index];
        while (current != null) {
            // equals() 方法的调用是核心
            if (key.equals(current.key)) {
                return false;
            }
            current = current.next;
        }
        // 4. 把 key 装入节点中，并插入到对应的链表中
        // 头插尾插都可以，头插相对简单
        Node node = new Node(key);
        node.next = array[index];
        array[index] = node;

        // 5. 维护 元素个数
        size++;

        // 6. 通过维护负载因子，进而维护较低的冲突率
        if (size / array.length * 100 >= 75) {
            扩容();
        }

        return true;
    }

    public boolean remove(Integer key) {
        int hashValue = key.hashCode();
        int index = hashValue % array.length;
        if (array[index] == null) {
            return false;//删除失败
        }
        if (key.equals(array[index].key)) {
            array[index] = null;
            size--;
            return true;
        }
        Node pre = array[index];
        while (pre.next != null) {
            if (pre.next.key.equals(key)) {
                pre.next = pre.next.next;
                size--;
                return true;
            }
            pre = pre.next;
        }
        return false;



//        // hashCode()
//        int hashValue = key.hashCode();
//        // 得到合法下标
//        int index = hashValue % array.length;
//
//        Node preivous = null;
//        Node current = array[index];
//        while (current != null) {
//            if (key.equals(current.key)) {
//                // 删除
//                if (preivous != null) {
//                    preivous.next = current.next;
//                } else {
//                    // current 是这条链表的头节点
//                    array[index] = current.next;
//                }
//
//                size--;
//                return true;
//            }
//
//            preivous = current;
//            current = current.next;
//        }
//
//        return false;
    }

    public boolean contains(Integer key) {
        int hashValue = key.hashCode();
        int index = hashValue % array.length;
        Node cur = array[index];
        while (cur != null) {
            if (key.equals(cur.key)) {
                return true;
            }
            cur = cur.next;
        }
        return false;



//        int hashValue = key.hashCode();
//        int index = hashValue % array.length;
//
//        Node current = array[index];
//        while (current != null) {
//            if (key.equals(current.key)) {
//                return true;
//            }
//
//            current = current.next;
//        }
//
//        return false;
    }

    // O(n)
    private void 扩容() {
        Node[] newArray = new Node[array.length * 2];

        // 搬原来的元素过来
        // 不能直接按链表搬运，因为元素保存的下标和数组长度有关
        // 数组长度变了，下标也会变
        // 所以，需要把每个元素重新计算一次

        // 遍历整个数组
        for (int i = 0; i < array.length; i++) {
            // 遍历每条链表
            Node current = array[i];
            while (current != null) {
                // 高效的办法是搬节点，写起来麻烦
                // 我们采用复制节点，简单一点
                Integer key = current.key;
                int hashValue = key.hashCode();
                int index = hashValue % newArray.length;

                // 头插尾插都可以，头插简单
                Node node = new Node(key);
                node.next = newArray[index];
                newArray[index] = node;

                current = current.next;
            }
        }

        array = newArray;
    }
}
