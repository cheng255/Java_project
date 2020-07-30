package Test01;

import org.junit.Test;

/**
 * @author nuonuo
 * @create 2020-07-28 10:05
 */
public class TestLinkedList {

    @Test
    public void Test01(){

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(4);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(1);
//        myLinkedList.addLast(4);
//        myLinkedList.addLast(3);
//        myLinkedList.addLast(2);
//        myLinkedList.addLast(1);
        myLinkedList.addIndex(0,1);
        System.out.println(myLinkedList.getSize());

//        myLinkedList.setHead(reserveLinkedList(myLinkedList.getHead()));
//        System.out.println("反转");
//        myLinkedList.display();
//        func(myLinkedList.getHead());
//        System.out.println(myLinkedList.getHead());
//        System.out.println("sadas" + getNodeFromLast(myLinkedList.getHead(), 1));
        myLinkedList.display();
        System.out.println("!!!!!!!!!!!!!!!!!");
        myLinkedList.setHead(removeRepeatedNode(myLinkedList.getHead()));
//        myLinkedList.setHead(partition(myLinkedList.getHead(), 3));
        myLinkedList.display();
    }

    //删除重复的指针
    private static Node removeRepeatedNode(Node head){
        if(head == null){
            return null;
        }
        //定义两个变量，其中一个帮助遍历相同结点达到删除目的
        Node pre = head, cur = head;
        while(cur != null){
            while(cur.getNext() != null && cur.getNext().getValue() == pre.getValue()){
                //发现值相同的结点,就继续遍历,直到cur的下一个结点不相同或为空
                cur = cur.getNext();
            }
            pre.setNext(cur.getNext());//将head的next指向这个不同的结点
            //然后head和cur都指向这个节点,准备下一轮遍历
            pre = cur.getNext();
            cur = cur.getNext();
        }
        return head;
    }

    //返回链表中倒数第k个节点
    private static Node getNodeFromLast(Node head, int k){
        if(head == null || k <= 0){
            return null;
        }
        Node l = head, r = head;
        //r先走到k-1位置，然后l和r一起走
        int i = 0;
        for(; r != null; r = r.getNext()){
            if(i++ < k){
                continue;
            }
            l = l.getNext();
        }
        //如果不足k项
        if(i < k){
            return null;
        }
        return l;
    }

    //反转链表
    private static Node reserveLinkedList(Node head){
        if(head == null){
            return head;
        }
        Node pre = head, cur = head.getNext();
        pre.setNext(null);
        while(cur != null){
            Node temp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    //将链表中所有比x的结点放到前面，大于等于x的结点放到后面，且保持稳定性
    private static Node partition(Node head, int x){
        if(head == null){
            return null;
        }
        //定义两个范围，一个小于的范围和一个大于等于的范围
        Node less = null, more = null, cur = head;
        Node moreHead = null;//记录more范围的头节点，至少有一个且为head
        Node lessHead = null;//记录less范围的头节点，可能为null
        for(; cur != null; cur = cur.getNext()){
            if(cur.getValue() < x){//小于x
                if(less == null){//第一次
                    lessHead = cur;
                    less = cur;
                    continue;
                }
                //不是第一次，将cur和less连接， 并且更新less指针
                less.setNext(cur);
                less = less.getNext();
            }else{//大于等于x
                if(more == null){//第一次
                    more = cur;
                    moreHead = cur;//将more范围的头节点记录下来
                    continue;
                }
                //不是第一次，将cur和more连接， 并且更新more指针
                more.setNext(cur);
                more = more.getNext();
            }
        }
        more.setNext(null);
        if(less == null){//如果没有小于x的结点
            return moreHead;
        }
        //否则连接两个范围并返回
        less.setNext(moreHead);
        return lessHead;
    }
}
