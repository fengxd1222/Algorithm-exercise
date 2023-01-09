package a2023.a0108;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 * <a href="https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_MaxQueue {

    Deque<Integer> normalQ = new LinkedList<>();
    Deque<Integer> maxQ = new LinkedList<>();

    public Offer_MaxQueue() {

    }
    public int max_value() {
        if(!maxQ.isEmpty()){
            return maxQ.peekFirst();
        }
        return -1;
    }

    public void push_back(int value) {
        normalQ.addLast(value);
        while (!maxQ.isEmpty()&&maxQ.peekLast()<value){
            maxQ.pollLast();
        }
        maxQ.addLast(value);
    }

    public int pop_front() {
        if(!normalQ.isEmpty()&&!maxQ.isEmpty()){
            Integer front = normalQ.pollFirst();
            if(Objects.equals(front, maxQ.peekFirst())){
                maxQ.pollFirst();
            }
            return front;
        }
        return -1;
    }
}
