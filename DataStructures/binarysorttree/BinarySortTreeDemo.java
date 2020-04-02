package com.atguigu.binarysorttree;

/*
 * 
 * 二叉排序树
 */
public class BinarySortTreeDemo {

	public static void main(String[] args) {
		int[] arr = { 7, 3, 10, 12, 5, 1, 9 };
		BinarySortTree binarySortTree = new BinarySortTree();
		// 循环来添加结点到二叉排序树
		for (int i = 0; i < arr.length; i++) {
			binarySortTree.add(new Node(arr[i]));
		}

		// 中序遍历二叉排序树
		binarySortTree.infixOrder();

		// 测试删除
		System.out.println("删除结点后");
//		binarySortTree.delNode(2);
		binarySortTree.delNode(7);
		binarySortTree.delNode(5);
		binarySortTree.delNode(3);
		binarySortTree.infixOrder();
		System.out.println();
//		System.out.println("root = " + binarySortTree.getRoot());
		binarySortTree.delNode(9);
		binarySortTree.delNode(12);
		binarySortTree.delNode(10);
		binarySortTree.delNode(1);
		binarySortTree.infixOrder();
//		System.out.println("root = " + binarySortTree.getRoot());

	}
}

//二叉排序树类
class BinarySortTree {
	private Node root;

	/*
	 * 删除结点
	 * 
	 * 三种情况：一：删除叶子结点 思路：1.找到要删除的结点 targetNode 2.再找到该节点的父节点 parentNode 3.判断targetNode
	 * 是parentNode 的左子结点还是右子结点 4.对应删除 二：删除只有一个子树的结点 思路：1.找到要删除的结点 targetNode
	 * 2.再找到该节点的父节点 parentNode 3.确定targetNode的子结点是左节点还是右节点
	 * 4.确定targetNode是parentNode的左子结点还是右子结点 5.的对应四种情况删除 三：删除有两个子树的结点 思路：1.找到要删除的结点
	 * targetNode 2.再找到该节点的父节点 parentNode 3.从targetNode的右子树中找到最小的结点 4.用临时变量temp
	 * 将这个最小的结点的值保存 5.删除这个最小的结点 6.将target赋给targetNode
	 * 
	 */

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