package com.atguigu.lickedlist;

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
		HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
		HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
		
		// 创建一个链表
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		//添加
//		singleLinkedList.add(hero1);
//		singleLinkedList.add(hero2);
//		singleLinkedList.add(hero3);
//		singleLinkedList.add(hero4);

		//按照编号顺序添加
		
		singleLinkedList.addByOrder(hero3);
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero2);
		
//		显示
		singleLinkedList.show();
		
		
		//测试修改节点的代码
		HeroNode newHeroNode = new HeroNode(2, "哈哈", "haha");
		singleLinkedList.update(newHeroNode);
		System.out.println("修改后的！");
		singleLinkedList.show();
		
		
		//测试删除节点的代码
		singleLinkedList.delete(2);
		System.out.println("删除后的！");
		singleLinkedList.show();
		

		//测试求单链表中有效节点的个数
		System.out.println(getLength(singleLinkedList.getHead()));
		
		//测试是否得到倒数第k个节点
		HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 1);
		System.out.println("倒数第" + 1 + "个\n" + res);
		
		//测试是否反转成功

		
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
	//思路
	//



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
				System.out.println();
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
