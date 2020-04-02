package com.atguigu.avltree;


/*
 * 平衡二叉树（Self-balancing binary search tree）
 * 
 * 称为AVL树，可以保证查询效率较高
 * 
 * 	特点：它是一颗空树或者它的左右两个子树的高度差的绝对值不超过1，
 * 		   并且左右两个子树都是一颗平衡二叉树。
 * 	平衡二叉树的常用实现方法有红黑树，AVL，替罪羊树，Treap ，伸展树等。
 * 
 * 
 * 实现：在二叉排序树的基础上增加左旋转，右旋转方法
 */
public class AVLTreeDemo {

	public static void main(String[] args) {
//		int[] arr = {4,3,6,5,7,8};
//		int[] arr = {10,12,8,9,7,6};
		int[] arr = {10,11,7,6,8,9};
		
		AVLTree avlTree = new AVLTree();
		//添加结点
		for(int i = 0; i < arr.length; i++) {
			avlTree.add(new Node(arr[i]));
		}
		//遍历
		System.out.println("中序遍历");
		avlTree.infixOrder();
		System.out.println("处理平衡后树的高度 = " + avlTree.getRoot().height());
		System.out.println("左子树高度 = " + avlTree.getRoot().leftHeight());
		System.out.println("右子树高度 = " + avlTree.getRoot().rightHeight());
		
		
	}
}

//创建AVL树
class AVLTree{
	private Node root;

	public Node getRoot() {
		return root;
	}


	// 查找要删除的结点
	public Node search(int value) {
		if (root == null) {
			return null;
		} else {
			return root.search(value);
		}
	}

	// 查找要删除的结点的父结点
	public Node searchParent(int value) {
		if (root == null) {
			return null;
		} else {
			return root.searchParent(value);
		}
	}

	// 编写方法
	/**
	 * 功能：删除以node为跟结点的二叉排序树的最小结点的值并返回该值
	 *
	 * @param node 传入的结点
	 * @return 返回以node为跟结点的二叉排序树的最小结点的值
	 */
	public int delRightTreeMin(Node node) {
		Node target = node;
		// 循环的查找左节点，找到最小值
		while (target.left != null) {
			target = target.left;
		}
		delNode(target.value);
		return target.value;
	}

	// 删除叶子结点
	public void delNode(int value) {
		if (root == null) {
			return;
		} else {
			// 1.找到要删除的结点 targetNode
			Node targetNode = search(value);
			if (targetNode == null) {
				return;
			}
			// 如果当前这颗二叉排序树只有一个结点
			if (root.left == null && root.right == null) {
				root = null;
				return;
			}
			// 2.再找到该节点的父节点 parentNode
			Node parentNode = searchParent(value);
			if (targetNode.left == null && targetNode.right == null) {// 一：叶子结点
				// 3.判断targetNode 是parentNode 的左子结点还是右子结点
				// 4.删除定义结点
				if (parentNode.left != null && parentNode.left.value == value) {
					parentNode.left = null;
				} else if (parentNode.right != null && parentNode.right.value == value) {
					parentNode.right = null;
				}
			} else if (targetNode.left != null && targetNode.right != null) {// 三：有两棵子树的结点
				// 3.从targetNode的右子树中找到最小的结点
				// 4.用临时变量temp 将这个最小的结点的值保存 5.删除这个最小的结点
				int minVal = delRightTreeMin(targetNode.right);
				// 6.将target赋给targetNode
				targetNode.value = minVal;

			} else {// 二：只有一颗子树的结点

				// 3.确定targetNode的子结点是左节点还是右节点
				if (targetNode.left != null) {// 左

					if (parentNode != null) {// 处理targetNode没有父结点的情况

						// 4.删除
						if (parentNode.left.value == value) {
							parentNode.left = targetNode.left;
						} else {
							parentNode.right = targetNode.left;
						}

					} else {
						root = targetNode.left;
					}
				} else {// 右
					if (parentNode != null) {// 处理targetNode没有父结点的情况

						if (parentNode.left.value == value) {
							parentNode.left = targetNode.right;
						} else {
							parentNode.right = targetNode.right;
						}
					} else {
						root = targetNode.right;
					}
				}
			}

		}
	}

	// 添加结点
	public void add(Node node) {
		if (root == null) {// 空树 =》直接root赋值
			root = node;
		} else {
			root.add(node);
		}
	}

	// 中序遍历
	public void infixOrder() {
		if (root != null) {
			root.infixOrder();
		} else {
			System.out.println("二叉排序树为空");
		}
	}

	
}


//结点类
class Node {
	int value;
	Node left;
	Node right;

	public Node(int value) {
		this.value = value;
	}
	
	// 返回左子树高度
	public int leftHeight() {
		if (left == null) {
			return 0;
		}
		return left.height();
	}

	// 返回右子树高度
	public int rightHeight() {
		if (right == null) {
			return 0;
		}
		return right.height();
	}

	/**
	 * 
	 * @return 返回以当前结点为跟结点的树的高度
	 */
	public int height() {
		return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
	}

	// 左旋转方法
	private void leftRotate() {
		// 1.以当前跟结点的值创建新的结点
		Node newNode = new Node(value);
		// 2.将新的结点的左子树设置成当前结点的左子树
		newNode.left = left;
		// 3.把新的结点的右子树设置成当前结点的右子树的左子树
		newNode.right = right.left;
		// 4.把当前结点的值替换成右子树的值
		value = right.value;
		// 5.把当前结点的右子树设置成当前结点的右子树的右子树
		right = right.right;
		// 6.把当前结点的左子节点设置成新的节点
		left = newNode;
	}

	// 右旋转方法
	private void rightRotate() {
		Node newNode = new Node(value);
		newNode.right = right;
		newNode.left = left.right;
		value = left.value;
		left = left.left;
		right = newNode;
	}
	


	// 添加结点(递归) 需要满足二叉排序树
	public void add(Node node) {
		if (node == null) {
			return;
		}
		// 判断传入的结点的值和当前子树的跟结点的值大小
		if (node.value < this.value) {
			if (this.left == null) {// 左边为空直接添加
				this.left = node;
			} else {// 不为空比较下一个结点
				this.left.add(node);
			}

		} else {// 添加结点的值大于等于当前结点的值
			if (this.right == null) {
				this.right = node;
			} else {
				this.right.add(node);
			}

		}
		
		// 当添加完一个结点后，如果 (右子树的高度 - 左子树的高度) > 1 => 左旋转
		if (rightHeight() - leftHeight() > 1) {
			// 如果当前结点的右子树的左子树高度大于当前结点的右子树的右子树
			if (right != null && right.rightHeight() > right.leftHeight()) {
				// 需要对当前这个节点的右节点进行右旋转，然后再对当前结点进行左旋转
				right.rightRotate();
			}
			leftRotate(); // 左旋转
			return;
		}
		// 当添加完一个结点后，如果 (左子树的高度 - 右子树的高度) > 1 => 右旋转
		if (leftHeight() - rightHeight() > 1) {
			// 如果当前结点的左子树的右子树高度大于当前结点的左子树的左子树
			if (left != null && left.rightHeight() > left.leftHeight()) {
				// 需要对当前这个节点的左节点进行左旋转，然后再对当前结点进行右旋转
				left.leftRotate();
			}
			rightRotate(); // 右旋转
		}
		/*
		 * 问题分析（已解决）
		 * 在右旋转之前
		 * 如果当前结点的左子树的右子树高度大于当前结点的左子树的左子树，
		 * 需要对当前这个节点的左节点进行左旋转，然后再对当前结点进行右旋转
		 * 不然无法达到右旋转应有的效果
		 * 
		 */
		

	}

	// 查找要删除的结点
	/**
	 * 
	 * @param value 希望删除的结点的值
	 * @return 如果找到返回该结点，否则返回null
	 */
	public Node search(int value) {
		if (value == this.value) {
			return this;
		} else if (value < this.value) {// 向左
			if (this.left == null) {
				return null;
			}
			return this.left.search(value);
		} else {// 向右
			if (this.right == null) {
				return null;
			}
			return this.right.search(value);
		}
	}

	// 查找要删除结点的父结点
	/**
	 * 
	 * @param value 要找到的结点的值
	 * @return 返回的是要删除的结点的父结点，如果没有找到返回null
	 */
	public Node searchParent(int value) {
		// 如果当前结点就是要删除的结点的父结点，就返回
		if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
			return this;
		} else {
			if (value < this.value && this.left != null) {
				return this.left.searchParent(value);// 向左递归
			} else if (value >= this.value && this.right != null) {
				return this.right.searchParent(value);// 向右递归
			} else {
				return null;
			}
		}
	}

	// 中序遍历
	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOrder();
		}

	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	
	
}
