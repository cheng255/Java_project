package com.atguigu.exer2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author nuonuo
 * @create 2020-09-25 11:04
 */
//方法1
class Solution1 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        //从第二个元素开始遍历popA，并找到当前元素在pushA中的下标
        int index = pushA.length;//上一次pop的元素在pushA中的下标
        for(int i = 0; i < popA.length; i++){
            int j = findNumber(pushA, popA[i]);
            if(j == -1) return false;
            //第一次pop不做处理,只记录在pushA中的下标
            //如果push序列中当前pop的数在上次pop的数的上面，不做处理
            if(i != 0 && j + 1 < index){
                return false;
            }
            if(index > j){
                index = j;
            }
        }
        return true;
    }
    public int findNumber(int[] arr, int n){
        int index = -1;
        for(int j = 0; j < arr.length; j++){
            if(arr[j] == n){
                index = j;
                break;
            }
        }
        return index;
    }

}
public class StackTest1 {
    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {5,1,2,3,4};
        System.out.println(func(pushA, popA));
    }
    /*
    判断是否为正确的出栈顺序
     */
    //方法2
    private static boolean func(int[] pushA, int[] popA) {
        Deque<Integer> stack = new LinkedList<>();
        int i = 0, j = 0;
        while (true) {
            if (stack.isEmpty() || popA[j] != stack.peek() && i < pushA.length) {
                stack.push(pushA[i]);
                i++;
            } else {
                stack.pop();
                j++;
            }
            if (j == popA.length) {
                return true;
            }
            if (i == pushA.length && popA[j] != stack.peek()) {
                return false;
            }
        }
    }
}


