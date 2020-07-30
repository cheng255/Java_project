package Test01;

/**
 * 不带头的单向链表
 * @author nuonuo
 * @create 2020-07-28 9:39
 */
public class MyLinkedList {
    private Node head;
    private int size;

    public MyLinkedList() {
        size = 0;
        head = null;
    }
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }
    //增加节点
    //头插,将当前节点的next指向head节点的next，再将head的next指向当前节点
    public void addFirst(int value){
        Node curNode = new Node(value);
        curNode.setNext(head);
        head = curNode;
        size++;
    }
    //尾插
    public void addLast(int value){
        size++;
        Node curNode = new Node(value);
        if(head == null){//第一次插入
            head = curNode;
            return;
        }
        Node temp = head;//帮助循环
        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(curNode);
    }
    //任意位置插入
    public void addIndex(int index, int value){
        if(index < 0 || index > this.getSize()){
            System.out.println("插入位置不合法");
            return;
        }
        if(index == 0){
            addFirst(value);
            return;
        }
        Node curNode = new Node(value);
        //找到要插入的前一个位置
        Node preNode = searchPerv(index);
        curNode.setNext(preNode.getNext());
        preNode.setNext(curNode);
        size++;
    }
    //找到当前下标的前一个结点
    public Node searchPerv(int index){
        if(index <= 0 || index > this.getSize()){
            return null;
        }
        Node preNode = head;
        for(int i = 1; i < index; i++){//找到要插入的前一个位置
            preNode = preNode.getNext();
        }
        return preNode;
    }
    public boolean contains(int value){
        if(head == null){
            return false;
        }
        Node temp = head;
        while(temp != null){
            if(temp.getValue() == value){
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    /**
     * 删除所有的value
     * @param value
     */
    public void removeAll(int value){
        if (head == null) {
            return;
        }
        Node pre = head, cur = head.getNext();
        while(cur != null){
            if(cur.getValue() == value){//如果当前结点是要删除的结点，删除后移动cur
                pre.setNext(cur.getNext());
                cur = cur.getNext();
            }else{//如果当前结点不是要删除的结点，删除后移动cur和pre
                pre = pre.getNext();
                cur = cur.getNext();
            }
        }
        if(head.getValue() == value){
            head = head.getNext();
        }
    }
    //删除节点  该方法只能删除一个结点
    public void remove(int value) {
        if (head == null) {
            System.out.println("当前链表为空");
            return;
        }
        if (head.getValue() == value) {//头结点是要删的结点
            head = null;
            size--;
            return;
        }
        boolean flag = false;//记录是否找到该节点
        Node temp = head;
        while (temp.getNext() != null) {
            if (temp.getNext().getValue() == value) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {//找到了
            temp.setNext(temp.getNext().getNext());
            size--;
        } else {
            System.out.println("无法找到该结点");
        }
    }
    //显示节点
    public void display(){
        if(head == null){
            System.out.println("链表为空");
        }
        Node temp = head;
        while(temp != null){
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

}


class Node{
    private int value;
    private Node next;

    public Node(int value) {
        this.value = value;
        next = null;
    }
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
