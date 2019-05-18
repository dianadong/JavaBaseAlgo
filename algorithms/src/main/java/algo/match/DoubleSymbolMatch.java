package algo.match;

import java.util.Stack;

public class DoubleSymbolMatch {
    /**
     * description: 括号匹配
     * create time: 2019/5/16 22:29
     */
    public static boolean match(char[] inputArray) {
//        数组长度是否是偶数
        if (inputArray.length % 2 == 1) {
            return false;
        }

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < inputArray.length; i++) {
            if (stack.empty()) {
                stack.push(String.valueOf(inputArray[i]));
            } else {
                if ((stack.peek().equals("(") && String.valueOf(inputArray[i]).equals(")"))
                        || (stack.peek().equals("[") && String.valueOf(inputArray[i]).equals("]"))
                        || (stack.peek().equals("{") && String.valueOf(inputArray[i]).equals("}"))) {
                    stack.pop();
                } else {
                    stack.push(String.valueOf(inputArray[i]));
                }
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String inputStr = "(()){[(]})";
        char[] inputArray = inputStr.toCharArray();
        System.out.println(match(inputArray));
    }
}
