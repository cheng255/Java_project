package com.cheng.exer1;

import java.util.Stack;

/**
 * 括号字符串正确性检查
 * @author nuonuo
 * @create 2020-11-26 14:12
 */
public class T4 {
    public boolean chkParenthesis(String A, int n) {
        // write code here
        if ((n & 1) == 1) {//奇数个括号不可能成立
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char temp = A.charAt(i);
            if (temp == '(') {//1.左括号入栈
                stack.push(temp);
            } else if (temp == ')') {//2.右括号与栈顶左括号抵消
                if (stack.isEmpty()) {//没有左括号对应
                    return false;
                }
                stack.pop();
            } else {
                //3.如果不是括号
                return false;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
