package com.atguigu.lickedlist;

import java.util.Stack;

/*
 * 单链表的应用实例
 * 
 * 使用带head头的单向链表实现 水浒英雄排行榜管理
 * 1.完成对英雄人物的增删改查操作
 * 2.第一种方法，在添加英雄时，直接添加到英雄的尾部
 * 3.第二种方法，根据英雄排名，将英雄插入到指定位置
 * (如果有这个排名，则添加失败，并给出提示)
 */
public class SingleLinkedListDemo {

	public static void main(String[] args) {
		//测试
		//先创建节点
		HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode hero2 = new HeroNode(4, "卢俊义", "玉麒麟");
		HeroNode hero3 = new HeroNode(5, "吴用", "智多星");
		HeroNode hero4 = new HeroNode(7, "林冲", "豹子头");
		HeroNode hero5 = new HeroNode(8, "杨雄", "拼命三郎");
		HeroNode hero6 = new HeroNode(2, "鲁智深", "花和尚");
		HeroNode hero7 = new HeroNode(3, "孙悟空", "斗战胜佛");
		HeroNode hero8 = new HeroNode(6, "沙和尚", "卷帘大将");
		
		// 创建一个链表
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		//A添加
//		singleLinkedList.add(hero1);
//		singleLinkedList.add(hero2);
//		singleLinkedList.add(hero3);
//		singleLinkedList.add(hero4);

		//B按照编号顺序添加
		
		singleLinkedList.addByOrder(hero3);
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero2);
		
//		显示
		System.out.println("原始单链表");
		singleLinkedList.show();
		
	
		// 创建一个新链表
		SingleLinkedList singleLinkedList1 = new SingleLinkedList();
		//B按照编号顺序添加
		
		singleLinkedList1.addByOrder(hero5);
		singleLinkedList1.addByOrder(hero6);
		singleLinkedList1.addByOrder(hero7);
		singleLinkedList1.addByOrder(hero8);
		System.out.println("新单链表");
		singleLinkedList1.show();
		
		//测试合并两个单链表(不会)
//		HeroNode res = merge(singleLinkedList.getHead(),singleLinkedList1.getHead());
//		System.out.println("合并后");
//		while(res.next != null) {
//			System.out.println(res.next.toString());
//			res = res.next;
//		}
		
//		//测试修改节点的代码
//		HeroNode newHeroNode = new HeroNode(2, "哈哈", "haha");
//		singleLinkedList.update(newHeroNode);
//		System.out.println("修改后的！");
//		singleLinkedList.show();
//		
//		
//		//测试删除节点的代码
//		singleLinkedList.delete(2);
//		System.out.println("删除后的！");
//		singleLinkedList.show();
//		
//
//		//测试求单链表中有效节点的个数
//		System.out.println(getLength(singleLinkedList.getHead()));
//		
//		//测试是否得到倒数第k个节点
//		HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 1);
//		System.out.println("倒数第" + 1 + "个\n" + res);
//		
//		// 测试链表反转
//		reverseList(singleLinkedList.getHead());
//		System.out.println("反转后的！");
//		singleLinkedList.show();
//
//		// 逆序打印测试
//		System.out.println("逆序打印");
//		reversePrint(singleLinkedList.getHead());
		
	}
	
	//题1：获取到单链表的节点的个数（不统计头节点）
	/**
	 * 
	 * @param head:链表的头节点
	 * @return 有效节点的个数
	 */
	public static int getLength(HeroNode head) {
		if(head.next == null) {//空链表
			return 0;
		}
		
		int length = 0;
		//定义一个辅助变量
		HeroNode cur = head.next;
		while(cur != null) {
			length++;
			cur = cur.next;
		}
		return length;
	}
	
	
	//题2：查找链表中倒数第k个节点
	//编写一个方法，接收head节点，同时接收index
	//index表示是倒数第index个节点
	//先通过遍历找到链表的长度length既有效节点的个数
	//然后遍历到length - index个，就可以得到
	//如果找到了，则返回该节点，否则返回null
	public static HeroNode findLastIndexNode(HeroNode head, int index) {
		if(head.next == null) {//空链表
			return null;
		}
		//得到长度
		int size =  getLength(head);
		//index校验
		if(index <= 0 || index > size) {
			return null;//找不到
		}
		
		HeroNode temp = head.next;

		//for循环定位
		for(int i = 0; i < size-index; i++) {
			
			temp = temp.next;
		}
		return temp;
	}
	
	//题三：反转链表
	//思路：将原始链表的每个节点取出，依次放到新创建的链表reverseHead的最前端
	//最后将head.next = reverseHead.next
	//
	public static void reverseList(HeroNode head) {
		if(head.next == null || head.next.next == null) {
			return;
		}
		
		//定义一个辅助指针（变量），帮助遍历原来的链表
		HeroNode temp = head.next;
		HeroNode next = null;//指向temp的下一个节点
		//定义一个新的链表头节点
		HeroNode reverseHead = new HeroNode(0, "", "");

		while(temp != null) {
			next = temp.next;//先将当前节点的下一个节点保存起来
			//头插法
			temp.next = reverseHead.next;
			reverseHead.next = temp;
			temp = next;	
		}
		head.next = reverseHead.next;
		
	}
	
	//题四：逆序打印单链表
	//利用栈这个数据结构，将各个节点压入栈中，然后利用先进后出的特点，逆序打印
	public static void reversePrint(HeroNode head) {
		if(head.next == null) {
			return;
		}

		Stack<HeroNode> stack = new Stack<HeroNode>(); 
		HeroNode temp = head.next;
		while(temp != null) {//入栈
			stack.push(temp);//push或者add
			temp = temp.next;
		}
		while(stack.size() > 0) {//出栈
			System.out.println(stack.pop());
		}
	
		
	}
	
	
	//题五：合并两个有序的单链表，合并之后的链表依然有序(不会)
//	public static HeroNode merge(HeroNode head1, HeroNode head2) {
//		// 判断空链表
//		if (head1.next == null) {
//			return head2;
//		}
//		if (head2.next == null) {
//			return head1;
//		}
//		// 将两个链表第一个节点比较，较小的节点给head
//		HeroNode head = new HeroNode(0, "", "");
//	       // 选出最小值作为合并后的新链表的头结点
//        if(head1.next.no <= head2.next.no) {
//            head.next = head1.next;
//            // 后移节点
//            head1 = head1.next;
//        } else {
//            head.next = head2.next;
//            // 后移节点
//            head2 = head2.next;
//        }
//		 //临时变量，用来链接合并链表的节点
//		HeroNode temp = head;
//		HeroNode next1 = null;
//		HeroNode next2 = null;
//		HeroNode next = null;
//		
//		
//		while (head1.next != null && head2.next != null) {
//			next1 = head1.next;
//			next2 = head2.next;
//			next = temp.next;
//			
//			if (head1.next.no >= head2.next.no) {
//				temp.next = head2.next;
//				head2 = next2;
//			} else {
//				temp.next = head1.next;
//				head1 = next1;
//			}
//			temp = next;
//
//		}
//
//		if (head1.next == null) {
//			temp.next = head2.next;
//		}
//		if (head2.next == null) {
//			temp.next = head2.next;
//		}
//
//		return head;
//	}	
	
}	
	
	


	//定义SingleLinkedList类 管理我们的英雄
	class SingleLinkedList{
		//先初始化一个头节点，头节点不要动，不存放具体的数据
		private HeroNode head = new HeroNode(0, " ", "");
		
		
		public HeroNode getHead() {
			return head;
		}
		//添加节点到单向链表
		//第一种添加方法，在添加英雄时，直接添加到英雄的尾部
		//思路：当不考虑编号的顺序时，
		//1.找到当前这个链表的最后节点
		//2.将最后这个节点的next 指向新的节点
		public void add(HeroNode heroNode) {
			
			//因为head节点不能动，因此我们需要一个辅助变量temp
			HeroNode temp = head;
			while(true) {
				
				if(temp.next == null) {//找到了
					break;
				}
				//如果没有找到，temp 后移
				temp = temp.next;
						
			}
			//当退出while循环，说明temp指向了链表的最后
			//然后将最后这个节点的next指向新的节点
			temp.next = heroNode;
		
		}
		//第二种添加方法，根据英雄排名，将英雄插入到指定位置
		public void addByOrder(HeroNode heroNode) {
			//因为head节点不能动，因此我们仍需要一个辅助变量temp
			HeroNode temp = head;
			//找到temp为要插入的位置的前一个节点
			boolean flag = false;//表示英雄添加的编号是否存在，默认false
			while (true) {

				if (temp.next == null) {//说明temp已经在链表的最后
					break;
				}
				if(temp.next.no > heroNode.no) {//说明位置找到了
					break;
				}else if(temp.next.no == heroNode.no) {//说明想添加的编号已经存在
					flag = true;
				}
				// 如果没有找到，temp 后移
				temp = temp.next;
			}
			if(flag == true) {//说明编号存在，不能存在
				System.out.println("待插入的英雄编号" + heroNode.no + "已经存在");
				
			}else {//可以添加
				heroNode.next = temp.next;
				temp.next = heroNode;
			}
			
		}
		
		
		//显示链表[遍历]
		public void show() {
			//先判断链表是否为空
			if(head.next == null) {
				System.out.println("链表为空");
				return;
			}
			HeroNode temp = head.next;
			while(true) {
				//判断是否到最后
				if(temp == null) {
					break;
				}
				//输出节点信息
				System.out.println(temp);	
				//将temp后移！
				temp = temp.next;
			}
				
		}
		
		//修改节点信息，根据编号来修改，既no不能改
		public void update(HeroNode newHeroNode) {
			if (head == null) {// 判断链表是否为空
				System.out.println("链表为空");
				return;
			}
			// 遍历找到需要修改的节点
			HeroNode temp = head.next;
			boolean flag = false;// 判断是否找到
			while (true) {
				// 判断是否到最后
				if (temp == null) {
					break;
				}
				if (temp.no == newHeroNode.no) {// 找到了
					flag = true;
					break;
				}

				// 将temp后移！
				temp = temp.next;

			}
			if (flag == true) {
				temp.name = newHeroNode.name;
				temp.nickname = newHeroNode.nickname;
			} else {// 没有找到
				System.out.println("没有找到编号为" + newHeroNode.no + "的英雄");
			}
		
		}
		
		//删除节点
		/*思路：
		 * 找到需要删除的节点的前一个节点
		 */
		public void delete(int no) {
			if (head == null) {// 判断链表是否为空
				System.out.println("链表为空");
				return;
			}
			HeroNode temp = head;
			boolean flag = false;// 判断是否找到
			while(true) {
				if (temp.next == null) {
					break;
				}
				if(temp.next.no == no) {//找到了
					flag = true;
					break;
				}
				//将temp后移！
				temp = temp.next;
			}
			if (flag == true) {

				temp.next = temp.next.next;
				
			} else {// 没有找到
				System.out.println("没有找到编号为" + no + "的英雄");
			}
			
		}
		
		
		
		
		
		
		
		
	}

//定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode{
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;//指向下一个节点  
	//构造器
	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
			
	}
	//为了显示方便，重写toString方法
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	

}
