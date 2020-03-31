package com.atguigu.tree;

/*
 * 
 * 顺序存储二叉树
 * 
 * 特点：
 * 	1.顺序二叉树通常只考虑完全二叉树 
 *  2.第n个元素的左子结点为：2 * n + 1
 *  3.第n个元素的右子结点为：2 * n + 2
 *  4.第n个元素的父结点为：(n - 1) / 2
 *  5.n 表示二叉树中的第几个元素（按 0 开始编号）既root结点编号为0
 * 
 */
public class ArrBinaryTreeDemo {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		
		ArrBinaryTree arrBinaryTree = new  ArrBinaryTree(arr);
		arrBinaryTree.preOrder();
		
	}
	
}


//编写一个类， 实现顺序存储二叉树遍历
class ArrBinaryTree {
	private int[] arr;

	public ArrBinaryTree(int[] arr) {
		this.arr = arr;
	}
	
	//重载preOrder()
	public void preOrder() {
		this.preOrder(0);
	}
	
	
	//完成顺序存储二叉树的前序遍历方法
	public void preOrder(int index) {
		if(arr == null || arr.length == 0) {
			System.out.println("数组为空");
			return;
		}
		//输出当前元素
		System.out.println(arr[index]);
		//向左递归遍历
		if((index * 2 + 1) < arr.length) {
			preOrder(index * 2 + 1);
		}
		//向右递归遍历
		if((index * 2 + 2) < arr.length) {
			preOrder(index * 2 + 2);
		}
		
	}
	
	//完成顺序存储二叉树的中序遍历方法
	public void infixOrder(int index) {
		if(arr == null || arr.length == 0) {
			System.out.println("数组为空");
			return;
		}
		//向左递归遍历
		if((index * 2 + 1) < arr.length) {
			infixOrder(index * 2 + 1);
		}
		//输出当前元素
		System.out.println(arr[index]);
		//向右递归遍历
		if((index * 2 + 2) < arr.length) {
			infixOrder(index * 2 + 2);
		}
		
	}
	
	//完成顺序存储二叉树的后序遍历方法
	public void postOrder(int index) {
		if(arr == null || arr.length == 0) {
			System.out.println("数组为空");
			return;
		}
		//向左递归遍历
		if((index * 2 + 1) < arr.length) {
			postOrder(index * 2 + 1);
		}
		//向右递归遍历
		if((index * 2 + 2) < arr.length) {
			postOrder(index * 2 + 2);
		}
		//输出当前元素
		System.out.println(arr[index]);
		
	}
	
	
}








