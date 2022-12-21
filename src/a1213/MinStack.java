package a1213;

import java.util.Objects;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 */
public class MinStack {
    /** initialize your data structure here. */
    Stack<Integer> stack_A;
    Stack<Integer> stack_B;
    public MinStack() {
        stack_A = new Stack<>();
        stack_B = new Stack<>();
    }

    public void push(int x) {
        if(stack_A.isEmpty() || stack_A.peek()>=x){
            stack_A.push(x);
        }
        stack_B.push(x);
    }

    public void pop() {
        if(!stack_A.isEmpty()){
            Integer pop = stack_B.pop();
            if(Objects.equals(stack_A.peek(), pop)){
                stack_A.pop();
            }
        }
    }

    public int top() {
        if(!stack_A.isEmpty()){
            Integer peek = stack_B.peek();
            if(Objects.equals(stack_A.peek(), peek)){
                stack_A.peek();
            }
            return peek;
        }
        return -1;
    }

    public int min() {
        if(!stack_A.isEmpty()){
            return stack_A.peek();
        }
        return -1;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
//        minStack.push(1);
//        minStack.push(2);
//        minStack.top();
//        minStack.min();
//        minStack.pop();
//        minStack.min();
//        minStack.top();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        minStack.min();
        minStack.pop();
        minStack.min();

    }
}
