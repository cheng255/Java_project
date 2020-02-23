package com.atguigu.exer1;

public class EcmDef {

	public static void main(String[] args) {
		
		try {
			int i = Integer.parseInt(args[0]);
			int j = Integer.parseInt(args[1]);
			
			int result = ecn(i, j);
			System.out.println(result);
		} catch (NumberFormatException e) {
			System.out.println("数据类型不一致");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("缺少命令行参数");
		} catch (ArithmeticException e) {
			System.out.println("除0");
		} catch (EcDef e) {//Unreachable catch block for EcDef. This exception is never thrown from the try statement body
			System.out.println(e.getMessage());
		}
	
		
		
	} 
	
	
	
	public static int ecn(int i, int j) throws EcDef {
		
		if(i < 0 || j < 0) {
			throw new EcDef("分子分母为负数了");
		}
		return i / j;
	}
	
	
	
}
