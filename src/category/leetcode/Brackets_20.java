package category.leetcode;

import java.util.Stack;

/**
 * @author songshiyu
 * @date 2020/8/6 16:13
 **/
public class Brackets_20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                char pop = stack.pop();
                if (c == ')' && pop != '(') {
                    return false;
                } else if (c == '}' && pop != '{') {
                    return false;
                } else if (c == ']' && pop != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
