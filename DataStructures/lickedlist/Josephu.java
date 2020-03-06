package com.atguigu.lickedlist;


//创建一个环形的单向链表
class CircleSingleLinkedList{
	//创建一个first节点，当前没有编号
	private Boy first = null;
	//添加小孩节点，构建成一个环形的链表
	public void addBoy(int nums) {
		// nums 校验
		if (nums < 1) {
			System.out.println("nums的值不正确");
			return;
		}
		Boy curBoy = null;// 辅助指针，帮助构建环形链表
		// 使用for循环来创建环形链表
		for (int i = 1; i <= nums; i++) {
			// 根据编号，创建小孩节点
			Boy boy = new Boy(i);
			// 如果是第一个小孩
			if (i == 1) {
				first = boy;
				first.setNext(first);// 构成第一个环
				curBoy = first;// 让curBoy指向第一个小孩，帮助循环
			} else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;// 循环操作
			}
		}
	}
	
	//显示操作（遍历）
	public void showBoy() {
		if (first == null) {//判断是否空链表
			System.out.println("没有任何小孩");
			return;
		}
		
		Boy curBoy = first;
		while (true) {
			System.out.printf("小孩的编号 %d\n", curBoy.getNo());
			if (curBoy.getNext() == first) {// 说明遍历完毕
				break;
			}
			curBoy = curBoy.getNext();
		}
		
	}
	
	

	/**
	 *
	 * 小孩出圈操作：根据用户的输入， 生成一个小孩子出圈的顺序
	 * 先first = first.next,再helper.next = first
	 * 1.需要创建一个辅助指针helper,事先应该指向环形链表的最后这个节点
	 * 补充：小孩报数前，先让first和helper 移动startNo-1次 
	 * 2.当小孩报数时，让helper和first指针同时移动 m-1 次
	 * 3.这时，就可以将first指向的小孩节点出圈：
	 * @param startNo 表示从第几个小孩开始数数
	 * @param countNo 表示数几下
	 * @param nums 表示最初有多少小孩在圈中
	 */
	public void countBoy(int startNo, int countNum, int nums) {
		//先对数据进行校验
		if(first == null || startNo < 1 || startNo > nums) {
			System.out.println("你的参数输入有误，请重新输入");
			return;
		}
		
		Boy helper = first;
		while(true) {//辅助指针helper,事先应该指向环形链表的最后这个节点
			if(helper.getNext() == first) {
				break;
			}
			helper = helper.getNext();
		}
		//小孩报数前，先让first和first移动startNo-1次
		for (int j = 0; j < startNo - 1; j++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		
		//当小孩报数时，让helper和first指针同时移动 m-1 次
		//这时，就可以将first指向的小孩节点出圈：

		while(true) {
			if(helper == first) {//说明圈中只有一人
				break;
			}
			//让 first 和 helper 指针同时移动 countNum - 1
			for(int j = 0; j <countNum - 1; j++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			//这时first指向的节点，就是要出圈的小孩节点
			System.out.printf("小孩%d出圈\n", first.getNo());
			first = first.getNext();
			helper.setNext(first);
			
		}
		System.out.printf("最后小孩%d留在圈中\n", helper.getNo());
		
		
	}
	
	
}






//先创建一个boy类，表示一个节点
class Boy{
	
	private int no;//编号
	private Boy next;//指向下一个节点，默认null
	
	public Boy(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}
	
}



public class Josephu {

	public static void main(String[] args) {
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(5);
		circleSingleLinkedList.showBoy();
		
		//测试小孩出圈
		circleSingleLinkedList.countBoy(1, 2, 5);//2 4 1 5 3
	}
}