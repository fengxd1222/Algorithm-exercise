package a1208;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class IsValid {
    public static boolean isValid(String s) {
        if(s.length()<2){
            return false;
        }
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if(aChar=='(' || aChar=='[' || aChar=='{'){
                stack.push(aChar);
            }else if(aChar==')' || aChar==']' || aChar=='}'){
                if(stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                if(!((aChar==')' && '(' == pop)||(aChar==']' && '[' == pop)||(aChar=='}' && '{' == pop))){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid(")(){}"));
        System.out.println(isValid("()[()]{}"));
        System.out.println(isValid("()[(()]{}"));
    }
}
