package com.atguigu.sparsearray;

/*
以后的要求！
1.将稀疏数组保存到磁盘上，比如map.data
2.恢复原来的数组时，读取map.data进行恢复
 */
public class SparseArray {
	
public static void main(String[] args) {
	//创建一个原始的二维数组11*11
	//0表示没有棋子，1表示黑子，2表示蓝子。
	int chessArr1[][] = new int[11][11];
	chessArr1[1][2] = 1;
	chessArr1[2][3] = 2;
	chessArr1[4][5] = 2;
	//输出原始的二维数组
	System.out.println("原始的二维数组：");
	for(int[] row : chessArr1) {
		for(int data : row) {
			System.out.printf("%d\t", data);
		}
		System.out.println();
	}
	
	//二维数组转稀疏数组的思路
	 
	 //1.遍历原来的二维数组，得到要保存的有效数据的个数sum
	
	int sum = 0;
	for(int i = 0; i < 11; i++) {
		for(int j = 0; j < 11; j++) {
			if(chessArr1[i][j] != 0) {
				sum++;
			}
		}
	}
	 //2.根据sum就可以创建稀疏数组sparseArray，int[sum + 1][3]
	
	int sparseArr[][] = new int[sum + 1][3];
	//给稀疏数组赋值
	sparseArr[0][0] = 11;
	sparseArr[0][1] = 11;
	sparseArr[0][2] = sum;
	
	 //3.将二维数组的有效数据存入到稀疏数组中
	
	int count = 0;//count用于记录是第几个非0数据
	for(int i = 0; i < 11; i++) {
		for(int j = 0; j < 11; j++) {
			if(chessArr1[i][j] != 0) {
				count++;
				sparseArr[count][0] = i;
				sparseArr[count][1] = j;
				sparseArr[count][2] = chessArr1[i][j];
			}
		}
	}
	
	//输出稀疏数组的形式
	System.out.println();
	System.out.println("得到的稀疏数组为：");
	for(int i = 0; i < sparseArr.length; i++) {
		System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
	}
	
	 // 稀疏数组转二位数组的思路
	 
	 //1.先读取到稀疏数组的第一行，根据第一行的数据创建原始的二维数组
	int chessArr2[][] = new int [sparseArr[0][0]][sparseArr[0][1]];
	 //2.再读取稀疏数组后几行的数组，并赋给二维数组

	for(int i = 1; i < sparseArr.length; i++) {
		chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
	}
	
	
	//输出恢复后的二维数组
	System.out.println();
	System.out.println("恢复后的二维数组：");
	for(int[] row : chessArr2) {
		for(int data : row) {
			System.out.printf("%d\t", data);
		}
		System.out.println();
	}
	
}





}
