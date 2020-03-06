package com.atguigu.sparsearray;

public class SparseArray1 {

	public static void main(String[] args) {
		int chessArr1[][] = new int[11][11];
		
		//初始化棋盘 ,1表示黑棋，2表示蓝棋，0表示没有棋子
		chessArr1[2][3] = 1;
		chessArr1[4][2] = 2;
		
		//遍历原始的二维数组
		System.out.println("原始的二维数组：");
		for(int[] row : chessArr1) {
			for(int data : row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
		//遍历原始二维数组，找出非0的数的个数sum;
		int sum = 0;
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 11; j++) {
				if(chessArr1[i][j] != 0) {
					sum++;
				}
			}
		}
		
		//创建一个稀疏数组
		int sparseArr[][] = new int[sum+1][3];
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = sum;
		
		//通过遍历原始二维数组，来为稀疏数组
		int temp = 1;//用于表示第几个非0的数
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 11; j++) {

				if(chessArr1[i][j] != 0) {
					sparseArr[temp][0] = i;
					sparseArr[temp][1] = j;
					sparseArr[temp][2] = chessArr1[i][j];
					temp++;
				}

			}
		}
		
		//遍历稀疏数组
		System.out.println("稀疏数组：");
		for(int i = 0; i < sum+1; i++) {
			for(int j = 0; j < 3; j++) {
			
				System.out.printf("%d\t",sparseArr[i][j]);
			}
			System.out.println();
		}
	
		
		//恢复二维数组
		
		int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
		
		//给二维数组赋值
		for(int i = 1; i < sparseArr.length; i++) {		
			chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
		
		//遍历二维数组
		System.out.println("恢复的二维数组：");
		for(int[] row : chessArr2) {
			for(int data : row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
			
	}
	
		
}
