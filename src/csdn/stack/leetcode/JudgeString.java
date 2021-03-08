package csdn.stack.leetcode;

import java.util.Stack;

/**
 * @description: leetcode-给定一个只包括'(',')','{','}','[',']'的字符串，半段字符串是否有效
 * @create: 2021/3/8 08:32:38
 **/
public class JudgeString {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    Character stackTop = stack.pop();
                    if (c == ')' && stackTop != '(') {
                        return false;
                    } else if (c == ']' && stackTop != '[') {
                        return false;
                    } else if (c == '}' && stackTop != '{') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "(){}[]";
        boolean valid = isValid(str);
        System.out.println(valid);
    }
}
