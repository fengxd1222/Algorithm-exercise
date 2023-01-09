package a2023.a0106;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 * <a href="https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_validateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed==null || popped==null||pushed.length!= popped.length)return false;
        if(pushed.length == 0)return true;
        Stack<Integer> stack = new Stack<>();

        int pushIndex=1;
        int popIndex=0;
        stack.push(pushed[0]);
        while (popIndex<=popped.length-1){
            if((stack.isEmpty()||stack.peek()!=popped[popIndex]) && pushIndex<=pushed.length-1){
                stack.push(pushed[pushIndex++]);
            }else if(pushIndex>=pushed.length && stack.peek()!=popped[popIndex]){
                return false;
            } else {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Offer_validateStackSequences a = new Offer_validateStackSequences();
        System.out.println(a.validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
        System.out.println(a.validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2}));
    }
}
