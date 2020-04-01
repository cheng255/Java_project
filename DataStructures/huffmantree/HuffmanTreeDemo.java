package com.atguigu.huffmantree;

import java.util.ArrayList;
import java.util.Collections;

/*
 * 赫夫曼树
 * 	简介：给定n个权值作为n个叶子结点，构造一棵二叉树，
 * 	若该树的带权路径长度达到最小，称这样的二叉树为最优二叉树，也称为哈夫曼树(Huffman Tree)。
 * 	哈夫曼树是带权路径长度最短的树，权值较大的结点离根较近。
 * 					（WPL(树的带权路径最小)最小的就是赫夫曼树）				
 * 
 * 构成赫夫曼树的步骤
 * 
 * 1. 从小到大进行排序，将每一个数据就是一个结点，可以看成是一个最简单的二叉树
 * 2.取出跟结点权值最小的两个树。
 * 3.组成一个新的二叉树，该新二叉树的跟结点的权值是前两个二叉树跟结点权值的和
 * 4.再将这个新的二叉树，以新的跟结点的大小再次排序，不断重复1,2,3,4步骤，直到
 * 		所有的数据都被处理，就得到一个赫夫曼树
 * 
 */
public class HuffmanTreeDemo {
	public static void main(String[] args) {
		int arr[] = {13,7,8,3,29,6,1};
		createHuffmanTree(arr);
		
		//测试
		Node root = createHuffmanTree(arr);
		preOrder(root);
		
	}
	
	
	//编写一个前序遍历的方法
	public static void preOrder(Node root) {
		if(root != null) {
			root.preOrder();
		}else {
			System.out.println("是空树，不能遍历");
		}
	}
	
	//创建赫夫曼树的方法
	public static Node createHuffmanTree(int[] arr) {
		// 1.将arr的每个元素封装成Node
		// 2.将Node放入到ArrayList中
		ArrayList<Node> nodes = new ArrayList<Node>();
		for (int value : arr) {
			nodes.add(new Node(value));
		}

		// 处理过程循环
		while (nodes.size() > 1) {

			// 3.排序
			Collections.sort(nodes);


			// 4.1取出跟结点权值最小的二叉树
			Node leftNode = nodes.get(0);
			// 4.2.取出此小的
			Node rightNode = nodes.get(1);
			// 4.3将这两个二叉树构建一个二叉树
			Node parent = new Node(leftNode.value + rightNode.value);
			parent.left = leftNode;
			parent.right = rightNode;
			// 4.4从ArrayList中删除处理过的两个节点
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			// 4.5将新跟结点加入到nodes
			nodes.add(parent);

		}

		//返回最终的跟结点
		return nodes.get(0);
	}

}


//创建结点类
//为了让node对象支持集合排序，需要实现comparable接口
class Node implements Comparable<Node>{
	int value;//结点权值
	Node left;//指向左子结点
	Node right;//指向右子结点
	
	//前序遍历
	public void preOrder() {
		System.out.println(this);
		if(this.left != null) {
			this.left.preOrder();
		}
		if(this.right != null) {
			this.right.preOrder();
		}
		
	}
	
	
	
	public Node(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	@Override
	public int compareTo(Node o) {
		return this.value - o.value;//表示从小到大排序
	}
	
	
	
	
	
}











