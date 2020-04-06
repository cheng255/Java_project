package com.atguigu.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph<E> {
	
	private ArrayList<String> vertexList; // 存储顶点集合
	private int[][] edges; //存储图对应的邻接矩阵
	private int numOfEdges; //表示边的数目
	private boolean[] isVisited;//记录结点是否被访问过
	
	public static void main(String[] args) {
		//测试图的创建
		int n = 5;//结点个数
		String vertexs[] = {"A","B","C","D","E"};
		//创建图对象
		Graph graph = new Graph(n);
		//循环添加顶点
		for(String vertex: vertexs) {
			graph.insertVertex(vertex);
		}
		//添加边
		graph.insertEdge(0, 1, 1); // A-B
		graph.insertEdge(0, 2, 1);
		graph.insertEdge(1, 2, 1);
		graph.insertEdge(1, 3, 1);
		graph.insertEdge(1, 4, 1);
		
		graph.showGraph();
		
		//测试深度优先dfs
		System.out.println("深度遍历");
//		graph.dfs();
		
		//测试广度优先bfs
		System.out.println("广度优先");
		graph.bfs();
		
	}
	
	//构造器
	public Graph(int n) {
		// 初始化矩阵和 vertexList
		edges = new int[n][n];
		vertexList = new ArrayList<String>(n);
		numOfEdges = 0;
		isVisited = new boolean[n];
		
	}
	//返回第一个邻接结点的下标
	/**
	 * 
	 * @param index
	 * @return 如果存在就返回对应下标，如果不存在，返回-1
	 */
	public int getFirstNeighbor(int index) {
		for(int j = 0; j < vertexList.size(); j++) {
			if(edges[index][j] > 0) {
				return j;
			}
		}
		return -1;
	}
	//根据前一个邻接结点的下标返回下一个邻接结点的下标
	/**
	 * 
	 * @param index
	 * @return 如果存在就返回对应下标，如果不存在，返回-1
	 */
	public int getNextNeighbor(int v1, int v2) {
		for(int j = v2 + 1; j < vertexList.size(); j++) {
			if(edges[v1][j] > 0) {
				return j;
			}
		}
		return -1;
	}
	
	//深度优先遍历算法
	// i 第一次就是0
	private void dfs(boolean[] isVisited, int i) {
		//首先访问第一个节点
		System.out.print(getValueByIndex(i) + "->");
		//将当前结点设置为已访问
		isVisited[i] = true;
		//查找结点i的第一个邻接结点
		int w = getFirstNeighbor(i);
		while(w != -1) {//说明有该临接结点
			if(!isVisited[w]) {
				dfs(isVisited, w);
			}
			//如果w已经被访问过
			w = getNextNeighbor(i, w);
		}
	}
	
	//对dfs 进行重载,遍历所有的结点，并进行dfs
	public void dfs() {
		for(int i = 0; i < getNumOfVertes(); i++) {
			if(!isVisited[i]) {
				dfs(isVisited, i);
			}
		}
	}
	
	//对一个结点进行广度优先遍历的方法
	private void bfs(boolean[] isVisited, int i) {
		int u; // 表示队列的头结点对应下标
		int w; // 临接结点下标
		//队列，记录结点访问的顺序
		LinkedList queue = new LinkedList();
		//访问结点
		System.out.print(getValueByIndex(i) + "->");
		//标记为已访问
		isVisited[i] = true;
		//将节点加入队列
		queue.add(i);
		
		while(! queue.isEmpty()) {
			//取出队列的头结点下标
			u = (Integer)queue.removeFirst();
			//得到第一个临界点下标
			w = getFirstNeighbor(u);
			while(w != -1) {//找到
				//是否访问过
				if(!isVisited[w]) {
					System.out.print(getValueByIndex(w) + "->");
					//标记已访问
					isVisited[w] = true;
					//入队列
					queue.addLast(w);
				}
				//访问过,找下一个邻接结点
				w = getNextNeighbor(u, w);
				
			}
		}
	}
	
	//遍历所有的结点，都进行广度优先搜索
	public void bfs() {
		for(int i = 0; i < getNumOfVertes(); i++) {
			if(! isVisited[i]) {
				bfs(isVisited, i);
			}
		}
	}
	
	
	
	//图中常用的方法
	//返回结点的个数
	public int getNumOfVertes() {
		return vertexList.size();
	}
	//得到边的个数
	public int getNumOfEdges() {
		return numOfEdges;
	}
	//返回结点i（下标）对应的数据
	public String getValueByIndex(int i) {
		return vertexList.get(i);
	}
	//返回v1和v2的权值
	public int getWeight(int v1, int v2) {
		return edges[v1][v2];
	}
	//显示图对应的矩阵
	public void showGraph() {
		for(int[] link : edges) {
			System.out.println(Arrays.toString(link));
		}
	}
	
	
	//插入结点
	public void insertVertex(String vertex) {
		vertexList.add(vertex);
	}
	
	//添加边
	/**
	 * 
	 * @param v1 点的下标
	 * @param v2 第二个点的下标 
	 * @param weight
	 */
	public void insertEdge(int v1, int v2, int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}
	
	
	
	
	
	
	
	
	
	
	

}
