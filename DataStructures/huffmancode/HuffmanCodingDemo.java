package com.atguigu.huffmancode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 
 * 赫夫曼编码（压缩）
 * 
 * 思路：
 * 		1.先记录字符串中各个字符出现的次数
 * 		2.按照字符出现的次数构建一个赫夫曼树，次数作为权值
 * 		3.根据赫夫曼树，给各个字符，规定编码，向左的路径为0，向右的路径为1
 * 			说明：
 * 			（如此的编码是前缀编码，即任何一个编码都不会是其他编码的前缀，不会造成匹配的多义性）
 * 			（赫夫曼编码是无损处理方案）
 * 		4.最后将编码转化为byte[]后发送
 * 
 * 注意：不同的排序方法，也可能使对应的赫夫曼编码不同，但wpl是相同的，都是最小的
 * 
 * 
 * 总结：赫夫曼编码适用于文本文件的压缩，对右很多重复内容的文件才有明显压缩效果
 * 
 */
public class HuffmanCodingDemo {

	public static void main(String[] args) {
		
		/*
		 * 
		 * 压缩.jpg文件时，可能会出现最后一个字节出错 OptionalDataExcption
		 */
		//压缩文件
//		String srcFile = "src.jpeg";
//		String dstFile = "dst.zip";		
		
//		zipFile(srcFile, dstFile);
//		System.out.println("压缩文件成功");
		
		
		//解压文件
//		String zipFile = "dst.zip";
//		String dstFile = "src2.jpeg";
//		
//		unZipFile(zipFile, dstFile);
//		System.out.println("解压成功");
		
		
		//压缩字符串
//		String content = "i like like like java do you like a java";
//		byte[] contentBytes = content.getBytes();
//		System.out.println(contentBytes.length); //40
//		
//		
//		byte[] huffmanBytes = huffmanZip(contentBytes);
//		System.out.println("压缩后的结果：" + Arrays.toString(huffmanBytes));
//		System.out.println("压缩后的长度：" + huffmanBytes.length);
//		
		//解压
//		byte[] sourceBytes = decode(huffmanCodes, huffmanBytes);
//		System.out.println("原始的字符串 = " + new String(sourceBytes).toString());
		
		//分步过程
////		System.out.println(contentBytes[0]);//105
//		List<Node> nodes = getNodes(contentBytes);
//		System.out.println(nodes);
//		
//		//测试赫夫曼树
//		System.out.println("赫夫曼树");
//		Node huffmanTreeRoot = createHuffmanTree(nodes);	
//		System.out.println("前序遍历");
//		preOrder(huffmanTreeRoot);
//		 
//		//测试是否生成了赫夫曼编码
//		Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
//		System.out.println("生成的赫夫曼编码表 :" + huffmanCodes);
//		//{32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101,
//		//121=11010, 106=0010, 107=1111, 108=000, 111=0011}
//		
//		//测试
//		byte[] zipBytes = zip(contentBytes,huffmanCodes);
//		System.out.println("zipBytes = " + Arrays.toString(zipBytes));
//		System.out.println(zipBytes.length);//17
		
		//发送

	}
	//编写方法：对文件解压
	/**
	 * 
	 * @param zipFile 准备解压的文件路径
	 * @param dstFile 解压到的路径
	 */
	public static void unZipFile(String zipFile, String dstFile) {
		//定义文件输入流
		FileInputStream fis = null;
		//定义一个对象输入流
		ObjectInputStream ois = null;
		//定义文件的输出流
		FileOutputStream fos = null;
		
		try {
			//创建文件输入流
			fis = new FileInputStream(zipFile);
			//创建一个与文件输入流关联的对象输入流
			ois = new ObjectInputStream(fis);
			//读取huffmanBytes数组
			byte[] huffmanBytes = (byte[]) ois.readObject();
///
			//读取赫夫曼编码表
			Map<Byte,String> huffmanCodes = (Map<Byte, String>) ois.readObject();
			//解码
			byte[] bytes = decode(huffmanCodes,huffmanBytes);
			//将bytes数组写入到目标文件
			fos = new FileOutputStream(dstFile);
			//写数据到文件中
			fos.write(bytes);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {		
				if(fos != null)
				fos.close();			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(ois != null)
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			try {
				if(fis != null)
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	//编写方法：将一个文件进行压缩
	/**
	 * 
	 * @param srcFile 传入的希望压缩的文件的全路径
	 * @param dstFile 压缩后将压缩文件放到那个目录
	 * @throws Exception 
	 * 
	 */
	public static void zipFile(String srcFile, String dstFile) {
		//创建输出流
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		//创建文件的输入流
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(srcFile);
			//创建一个和原文件大小一样的byte[]
			byte[] b = new byte[fis.available()];//available()返回文件字节大小
			//读取文件
			fis.read(b);
			//压缩
			byte[] huffmanBytes = huffmanZip(b);
			//创建文件输出流，存放压缩文件
			fos = new FileOutputStream(dstFile);
			//创建一个和文件输出流相关的ObjectOutputStream
			oos = new ObjectOutputStream(fos);
			// 把赫夫曼编码后的字节数组写入压缩文件
			oos.write(huffmanBytes); //
			
			//这里我们以对象流的方式写入赫夫曼编码，是为了以后恢复解压时使用
			//注意一定要把赫夫曼编码表 写入压缩文件， 因为以后解压时需要huffmanCodes做参数
			oos.writeObject(huffmanCodes);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				fis.close();
				oos.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	
	/*
	 * 完成数据的解压
	 * 思路：
	 * 1.先将压缩后的字节数组转成二进制字符串
	 * 2.对照赫夫曼编码=》初始字符串
	 * 
	 * 
	 * 
	 */
	//编写一个方法，完成对压缩数据的解码
	/**
	 * 
	 * @param huffmanCodes 赫夫曼编码表Map
	 * @param huffmanBytes 赫夫曼编码得到的字节数组
	 * @return 原来的字符串对应的byte数组
	 */
	private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
		
		//1.先得到huffmanBytes 对应的 二进制字符串
		StringBuilder stringBuilder = new StringBuilder();
		//将byte数组转成二进制的字符串
		for(int i = 0; i < huffmanBytes.length; i++) {	
			boolean flag = (i == huffmanBytes.length - 1);//判断是否为最后一个字节，是的话则不许补高位0
			stringBuilder.append(ByteToBitString(!flag, huffmanBytes[i]));
		}
		
		//2.把字符串按照指定的赫夫曼编码进行解码
		Map<String, Byte> map = new HashMap<String, Byte>();
		for(Map.Entry<Byte, String> entry: huffmanCodes.entrySet()) {
			map.put(entry.getValue(), entry.getKey());//获得反向的赫夫曼编码表
		}
		
		//创建一个集合，存放byte
		List<Byte> list = new ArrayList<>();
		//扫描stringBuilder
		for(int i = 0; i < stringBuilder.length();) {
			int count = 1;//帮助i遍历匹配字符
			boolean flag = true;
			Byte b = null;
			
			while(flag) {
				//取出一个'1'或'0'
				String key = stringBuilder.substring(i, i + count);//count在while内用作便利，
				b = map.get(key);									//是其匹配到字符再退出循环
				if (b != null) {//说明匹配到了一个byte
					break;
				} else {
					count++;
				}
			}
			list.add(b);
			i += count;//让i直接移动到count位置
			
		}
		
		//当for循环接收后，list里就存放了所有的字符
//		System.out.println(list);
		//将list 中的数据放入到byte[] 并返回
		byte[] b = new byte[list.size()];
		for(int i = 0; i < b.length; i++) {
			b[i] = list.get(i);
		}
		return b;
		
	}
	
	
	/**
	 * 将一个byte转成二进制的8位字符串
	 * @param b
	 * @param flag 标志是否需要补高位，如果是true，表示需要补高位，如果是false表示不补,最后一个byte不用补高位
	 * @return 该b 对应的二进制字符串（注意是按补码返回）
	 */
	private static String ByteToBitString(boolean flag, byte b) {
		
		//使用一个变量保存b
		int temp = b;// 将吧转成 int
		if (flag) {

			temp |= 256;// 如果是正数，需要补高位0
		}

		String str = Integer.toBinaryString(temp);// 返回的是temp对应的二进制的补码

		if (flag) {
			return str.substring(str.length() - 8);
		} else {
			return str;
		}
		
		
	}
	
	
	/**
	 * 将前面所有方法封装起来
	 * 
	 * 
	 * @param bytes：原始的字符串对应的字节数组
	 * @return：经过 赫夫曼编码处理后的字节数组（压缩后的数组）
	 */
	private static byte[] huffmanZip(byte[] bytes) {
		// 拿到Node对象集合
		List<Node> nodes = getNodes(bytes);
		// 创建赫夫曼树
		Node huffmanTreeRoot = createHuffmanTree(nodes);
		// 根据赫夫曼树创建赫夫曼编码表
		Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
		// 根据赫夫曼编码表生成赫夫曼编码并压缩为byte[]
		byte[] zipBytes = zip(bytes, huffmanCodes);

		return zipBytes;
	}
	
	
	
	//编写一个方法，将一个字符串对应的byte[] 数组，通过生成的赫夫曼编码表，
	//返回一个赫夫曼编码 压缩后的byte[]
	/**
	 * 
	 * @param bytes:原始字符串对应的byte[]
	 * @param huffmanCodes：生成的赫夫曼编码Map
	 * @return
	 */
	private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
		// 1.先 利用huffmanCodes 将 bytes 转成 赫夫曼编码对应的字符串
		StringBuilder stringBuilder = new StringBuilder();
		// 遍历bytes数组
		for (byte b : bytes) {
			stringBuilder.append(huffmanCodes.get(b));//根据data值找对应的weight，并拼接
		}
		// 此时得到的就是由赫夫曼编码表对原始字符串的编码字符串
//		System.out.println("测试stringBuilder" + stringBuilder);

		// 将这个字符串压缩成byte[],当作二进制将8位转换成1位

		// 首先统计 byte[] huffmanCodeBytes 长度
		int len = (stringBuilder.length() + 7) / 8;

		// 创建 存储压缩后的byte数组
		byte[] huffmanCodeBytes = new byte[len];

		int index = 0;// 记录是第几个byte
		for (int i = 0; i < stringBuilder.length(); i += 8) {// 每八位对应一个byte
			String strByte;
			if (i + 8 > stringBuilder.length()) {
				// 剩余字符不够八位
				strByte = stringBuilder.substring(i);
			} else {
				strByte = stringBuilder.substring(i, i + 8);
			}
			// 将strByte 转成一个byte，放入到huffmanCodeBytes
			huffmanCodeBytes[index++] = (byte) Integer.parseInt(strByte, 2);
		}
		
		return huffmanCodeBytes;

	}
	
	
	/*
	 * 生成赫夫曼树对应的赫夫曼编码表（重点）
	 * 思路：
	 * 1.将赫夫曼编码表存放在Map<Byte,String>中
	 *  形式如：   32->01  97->100  100->11000等等，具体与树的真实存放结构有关
	 *  2.在生成赫夫曼编码表时，需要去拼接路径，定义一个StringBuilder 存储某个叶子节点的路径
	 */
	static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
	
	static StringBuilder stringBuilder = new StringBuilder();
	
	/**
	 * 为了调用方便，重载getCodes
	 * 
	 */
	private static Map<Byte, String> getCodes(Node root){
	
		if(root == null) {
			return null;
		}
		//处理root的左子树
		getCodes(root.left,"0",stringBuilder);
		//处理root的右子树
		getCodes(root.right,"1",stringBuilder);
		
		return huffmanCodes;
		
	}
	
	/**
	 * 
	 * 功能：将传入的node结点的所有叶子节点的赫夫曼编码得到，并放入到huffmanCodes集合
	 * 
	 * @param node：传入的节点
	 * @param code：路径：左子结点是0，右子结点是1
	 * @param stringBuilder：做路径拼接
	 */
	private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
		StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
		//将传入的code加入到StringBuilder2
		stringBuilder2.append(code);
		if(node != null) {
			//判断当前这个node是否为叶子结点
			if(node.data == null) {//非叶子节点
				//向左递归
				getCodes(node.left, "0", stringBuilder2);
				//向右递归
				getCodes(node.right, "1", stringBuilder2);
			} else {//叶子节点
				//就表示找到了这个叶子节点的路径
				huffmanCodes.put(node.data, stringBuilder2.toString());
			}
			
		}
	}
	
	
	/**
	 * 
	 * @param bytes:接收字节数组
	 * @return：返回Node的集合
	 */
	private static List<Node> getNodes(byte[] bytes){
		
		//1.创建一个ArrayList
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		//遍历bytes，统计每个byte出现的次数->map[kay,value]
		HashMap<Byte, Integer> map = new HashMap<>();
		for (byte b : bytes) {
			Integer count = map.get(b);
			if (count == null) {// Map里还没有这个字符
				map.put(b, 1);
			} else {
				map.put(b, count + 1);
			}
		}
		
		//遍历Map，把每个键值对转成Node对象，并加入到nodes集合
		for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
			nodes.add(new Node(entry.getKey(), entry.getValue()));
		}
		return nodes;
	}
/**
 * 	通过List创建对应的赫夫曼树
 * @param nodes
 */
	private static Node createHuffmanTree(List<Node> nodes) {
		
		while(nodes.size() > 1) {
			//排序
			Collections.sort(nodes);
			
			//选出最小树和次小树
			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);
			
			//创建新的二叉树,他的根节点没有data，只有权值
			Node parent = new Node(null, leftNode.weight + rightNode.weight);
			parent.left = leftNode;
			parent.right = rightNode;
			
			//删除已经处理过的节点
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			
			//将新的二叉树，加入到nodes
			nodes.add(parent);
		
		}
		//返回处理好的赫夫曼树的跟结点
		return nodes.get(0);

	}
	/**
	 * 前序遍历
	 */
	public static void preOrder(Node root) {
		if(root != null) {
			root.preOrder();
		}else {
			System.out.println("赫夫曼树为空");
		}
	}
	
	
}

/*
 * 
 * 功能：根据赫夫曼殊编码压缩数据的原理，需要创建 "i like like like java do you like a java"
 * 	   	 对应的赫夫曼树
 * 思路：1.Node{data(存放字符数据)，weight(权重)， left, right}
 * 		2.得到"i like like like java do you like a java"对应的byte[]
 * 		3.编写方法：将准备构成赫夫曼树的Node节点放到List中 。 例如： {Node[data = 97,weight = 5], ...}
 * 					体现d:1 y:1 u:1 j:2 v:2 o:2 i:4 k:4 e:4 i:5 a:5  :9
 * 		4.可以通过List创建对应的赫夫曼树
 * 
 */
//1.创建Node，待数据和权值
class Node implements Comparable<Node>{
	Byte data; //存放数据（字符）本身，比如'a' => 97  ' ' => 32
	int weight; // 权值，即表示字符出现的次数
	Node left;
	Node right;
	public Node(Byte data, int weight) {
		this.data = data;
		this.weight = weight;
	}
	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;//从小到大排序
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", weight=" + weight + "]";
	}
	
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
	

}





