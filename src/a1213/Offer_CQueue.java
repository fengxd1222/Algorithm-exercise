package a1213;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 */
public class Offer_CQueue {
    Stack<Integer> stack_A;
    Stack<Integer> stack_B;

    public Offer_CQueue() {
        stack_A = new Stack<>();
        stack_B = new Stack<>();
    }

    public void appendTail(int value) {
        stack_A.push(value);
    }

    public int deleteHead() {
        if(stack_A.isEmpty()){
            return -1;
        }
        while (!stack_A.isEmpty()){
            Integer pop = stack_A.pop();

            stack_B.push(pop);
        }
        int res = stack_B.pop();
        //放回a中
        while (!stack_B.isEmpty()){
            stack_A.push(stack_B.pop());
        }
        return res;
    }
}
