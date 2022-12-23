package a1223;

import common.ListNode;

import java.util.Stack;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 *
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 * <a href="https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_GetKthFromEnd {
    ListNode target = null;
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null)return head;

        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
        while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        ListNode temp = null;
        for (int i = 0; i < k; i++) {
            temp = stack.pop();
        }
        return temp;
    }

    public ListNode getKthFromEnd1(ListNode head, int k) {
        if(head==null)return head;

        process(head,k);
        return target;
    }

    private int process(ListNode head, int k) {
        if(head==null){
            return 0;
        }

        int i = 1 + process(head.next, k);
        if(i==k){
            target = head;
            return i+1;
        }
        if(i>k){
            return i;
        }
        return i;
    }

}
