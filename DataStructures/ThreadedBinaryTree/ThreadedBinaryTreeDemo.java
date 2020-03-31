package ThreadedBinaryTree;
/*
 * 实现了  中序线索化   的二叉树类
 */

public class ThreadedBinaryTreeDemo {

	public static void main(String[] args) {

		
		Node root = new Node(1,"张三");
		Node node2 = new Node(2,"李四");
		Node node3 = new Node(3,"王五");
		Node node4 = new Node(4,"黄六");
		Node node5 = new Node(5,"赵七");
		Node node6 = new Node(6,"杨八");
		//暂时手动创建二叉树
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		
		//测试中序线索化二叉树的功能
		ThreadedBinaryTree binaryTree = new ThreadedBinaryTree();
		binaryTree.setRoot(root);
		binaryTree.threadedNodes();
		
//		System.out.println(node5.getLeft());
		
		//使用线索化的方式遍历线索化二叉树
		binaryTree.threadedList();
		
		
		
	}
	
}

//定义实现了  线索化功能   的二叉树类
class ThreadedBinaryTree {
	private Node root;
	
	//为了实现线索化，需要创建指向当前结点的前驱结点的指针
	private Node pre = null;
	
	public void setRoot(Node root) {
		this.root = root;
	}
	
	//重载线索化方法
	public void threadedNodes() {
		this.threadedNodes(root);
	}
	
	//遍历线索化二叉树
	public void threadedList() {
		//定义一个变量，存储当前遍历的结点，从root开始
		Node node = root;
		while(node != null) {//node随循环变化
			
			while(node.getLeftType() == 0) {
				node = node.getLeft();
			}
			
			System.out.println(node);//打印当前结点
			while(node.getRightType() == 1) {//如果当前结点的右指针指向后继结点，就一直输出
				node = node.getRight();
				System.out.println(node);
			}
			//替换遍历的结点
			node = node.getRight();
			
		}
	}
	
	
	
	/**
	 * 编写对二叉树进行中序线索化的方法
	 * @param node: 对当前node结点线索化
	 */
	public void threadedNodes(Node node) {
		if(node == null) {
			return;
		}
		
		//1.先线索化左子树  
		threadedNodes(node.getLeft());
		
		//2. 再线索化当前结点      (难点！)
		
		//先处理当前结点的前驱结点
		if(node.getLeft() == null) {
			node.setLeft(pre);//将当前结点指向前驱结点
			node.setLeftType(1);
		}
		/*
		 * 再处理当前结点的后驱结点
		 * 原理：当前结点即为递归一次后的结点的前驱结点
		 */
		if(pre != null && pre.getRight() == null) {
			pre.setRight(node);
			pre.setRightType(1);
		}
		
		pre = node;//每处理一个结点后，让当前结点是下一个结点的前驱结点
	
		//3. 再线索化右子树
		threadedNodes(node.getRight());
	
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


//结点类
class Node {
	private int id;// 编号
	private String name;// 姓名
	private Node left;// 指向左子节点
	private Node right;// 指向右子节点
	
	//说明：
	//1.如果leftType == 0 表示指向的是左子树，如果 1 则代表指向前驱结点
	//2.如果rightType == 0 表示指向的是右子树，如果 1 则代表指向后驱结点
	private int leftType;
	private int rightType;
	
	

	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}

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

	// 删除结点
	public void delNode(int id) {
		if (this.left != null && this.left.id == id) {
			this.left = null;
			return;
		}

		if (this.right != null && this.right.id == id) {
			this.right = null;
			return;
		}
		// 如果当前结点的左右子节点都不为空，则分别向左右递归
		if (this.left != null) {
			this.left.delNode(id);
		}

		if (this.right != null) {
			this.right.delNode(id);
		}

	}

	// 编写前序遍历的方法
	public void preOrder() {
		System.out.println(this);// 先输出父节点
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
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

	// 后序遍历
	public void postOrder() {
		if (this.left != null) {
			this.left.postOrder();
		}
		if (this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}

	// 编写前序查找的方法
	public Node preOrderSearch(int id) {
		if (this.id == id)// 判断当前
			return this;

		Node resNode = null;

		if (this.left != null) // 向左递归
			resNode = this.left.preOrderSearch(id);

		if (resNode != null) {// 左边找到则返回,不需要再向右查找
			return resNode;
		}

		if (this.right != null) // 向右递归
			resNode = this.right.preOrderSearch(id);

		return resNode;

	}

	// 中序遍历查找
	public Node infixOrderSearch(int id) {
		Node resNode = null;
		if (this.left != null) {
			resNode = this.left.infixOrderSearch(id);
		}
		if (resNode != null) {
			return resNode;
		}
		if (this.id == id) {
			return this;
		}
		if (this.right != null) {
			resNode = this.right.infixOrderSearch(id);
		}
		return resNode;
	}

	// 后序遍历查找
	public Node postOrderSearch(int id) {
		Node resNode = null;
		if (this.left != null) {
			resNode = this.left.postOrderSearch(id);
		}
		if (resNode != null) {
			return resNode;
		}
		if (this.right != null) {
			resNode = this.right.postOrderSearch(id);
		}
		if (resNode != null) {
			return resNode;
		}

		if (this.id == id) {
			return this;
		}
		return resNode;
	}

}

