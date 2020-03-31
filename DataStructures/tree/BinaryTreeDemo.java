package com.atguigu.tree;


/*
 * 一：分析二叉树的前序，中序，后序遍历
 * 
 * 1.创建二叉树
 * 
 * 2.前序遍历
 * 	2.1 先输出当前节点（初始时为root节点）
 *  2.2如果左子节点不为空，则递归继续前序遍历
 *  2.3如果右子节点不为空，则递归继续前序遍历 	
 * 
 * 3.中序遍历
 *  3.1如果当前节点的左子节点不为空，则递归中序遍历
 *  3.2输出当前节点
 *  3.3如果点前节点的右子节点不为空，则递归中序遍历
 *  
 * 4.中序遍历
 *  4.1如果当前节点的右子节点不为空，则递归中序遍历
 *  4.2输出当前节点
 *  4.3如果点前节点的左子节点不为空，则递归中序遍历
 *  
 *  
 * 二：查找和遍历类似，需要创建一个临时节点用做赋值返回
 * 
 * 
 * 三：删除结点：思路：判断当前结点的子节点是否为要删除的结点
 * 
 * （暂时先规定删除某子结点时，将该子树整个删除，比如 if(root.id == id) 
 * 													root = null;
 * 
 */
public class BinaryTreeDemo {
	
	public static void main(String[] args) {
		//实例化二叉树
		BinaryTree binaryTree = new BinaryTree();
		
		Node root = new Node(1,"张三");
		Node node2 = new Node(2,"李四");
		Node node3 = new Node(3,"王五");
		Node node4 = new Node(4,"黄六");
		Node node5 = new Node(5,"赵七");
		
		//暂时手动创建二叉树
		root.setLeft(node2);
		root.setRight(node3);
		node3.setRight(node4);
		node3.setLeft(node5);
		binaryTree.setRoot(root);
		
		//测试遍历操作
		System.out.println("前序：");
		binaryTree.preOrder();
//		System.out.println("中序：");
//		binaryTree.infixOrder();
//		System.out.println("后序：");
//		binaryTree.postOrder();
//		//测试查找操作
//		System.out.println("前序：");
//		System.out.println(binaryTree.preOrderSearch(5));
//		System.out.println("中序：");
//		System.out.println(binaryTree.infixOrderSearch(3));
//		System.out.println("后序：");
//		System.out.println(binaryTree.postOrderSearch(2));
		//测试删除结点
		binaryTree.delNode(5);
		System.out.println("删除后");
		binaryTree.preOrder();
		
		
		
	}
	
	


}

//定义二叉树类
class BinaryTree {
	private Node root;
	
	public void setRoot(Node root) {
		this.root = root;
	}
	
	//删除结点
	public void delNode(int id) {
		if(root == null) {
			System.out.println("二叉树为空，无法删除");
		} else if (root.getId() == id) {
			root = null;
		} else {
			root.delNode(id);
		}
	}
	
	
	//前序遍历
	public void preOrder() {
		if(this.root != null) {
			this.root.preOrder();
		} else {
			System.out.println("当前二叉树为空，无法遍历");
		}
	}
	//中序遍历
	public void infixOrder() {
		if(this.root != null) {
			this.root.infixOrder();
		} else {
			System.out.println("当前二叉树为空，无法遍历");
		}
	}
	//后序遍历
	public void postOrder() {
		if(this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("当前二叉树为空，无法遍历");
		}
	}
	//前序遍历查找
	public Node preOrderSearch(int id) {
		if(root != null) {
			return root.preOrderSearch(id); 
		} else {
			return null;
		}
	}
	//中序遍历查找
	public Node infixOrderSearch(int id) {
		if(root != null) {
			return root.infixOrderSearch(id); 
		} else {
			return null;
		}
	}
	//后序遍历查找
	public Node postOrderSearch(int id) {
		if(root != null) {
			return root.postOrderSearch(id); 
		} else {
			return null;
		}
	}
	
	
}



//先创建节点类
class Node {
	private int id;//编号
	private String name;//姓名
	private Node left;//指向左子节点 
	private Node right;//指向右子节点
	public Node(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Node() {
		super();
	}
	
	@Override
	public String toString() {
		return "Node [id=" + id + ", name=" + name + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	
	//删除结点
	public void delNode(int id) {
		if(this.left != null && this.left.id == id) {
			this.left = null;
			return;
		}
		
		if(this.right != null && this.right.id == id) {
			this.right = null;
			return;
		}
		//如果当前结点的左右子节点都不为空，则分别向左右递归
		if(this.left != null) {
			this.left.delNode(id);
		}
		
		if(this.right != null) {
			this.right.delNode(id);
		}
		
		
	}
	
	
	//编写前序遍历的方法
	public void preOrder() {
		System.out.println(this);//先输出父节点
		if(this.left != null) {
			this.left.preOrder();
		}
		if(this.right != null) {
			this.right.preOrder();
		}
		
	}
	//中序遍历
	public void infixOrder() {
		if(this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if(this.right != null) {
			this.right.infixOrder();
		}
	}
	//后序遍历
	public void postOrder() {
		if(this.left != null) {
			this.left.postOrder();
		}
		if(this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}
	
	//编写前序查找的方法
	public Node preOrderSearch(int id) {
		if (this.id == id)// 判断当前
			return this;

		Node resNode = null;
		
		if (this.left != null) // 向左递归
			resNode = this.left.preOrderSearch(id);
		
		if(resNode != null) {//左边找到则返回,不需要再向右查找
			return resNode;
		}

		if (this.right != null) // 向右递归
			resNode = this.right.preOrderSearch(id);
		
		return resNode;

	}
	//中序遍历查找
	public Node infixOrderSearch(int id) {
		Node resNode = null;
		if(this.left != null) {
			resNode = this.left.infixOrderSearch(id);
		}
		if(resNode != null) {
			return resNode;
		}
		if(this.id == id) {
			return this;
		}
		if(this.right != null) {
			resNode = this.right.infixOrderSearch(id);
		}
		return resNode;		
	}
	//后序遍历查找
	public Node postOrderSearch(int id) {
		Node resNode = null;
		if(this.left != null) {
			resNode = this.left.postOrderSearch(id);
		}
		if(resNode != null) {
			return resNode;
		}
		if(this.right != null) {
			resNode = this.right.postOrderSearch(id);
		}
		if(resNode != null) {
			return resNode;
		}
		
		if(this.id == id) {
			return this;
		}
		return resNode;
	}
	
	
}





