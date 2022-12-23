package a1222;

import a1214.Offer_ReverseList;
import common.ListNode;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 *
 *
 *
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 *
 * <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/?envType=study-plan&id=zijie&plan=7d_zijie&plan_progress=yg0e3md">...</a>
 */
public class ByteDance_ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return null;
        }
        if(k==1){
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode left = newHead;
        ListNode right = newHead;
        while (right.next!=null){
            for (int i = 0; i < k && right!=null; i++) {
                right = right.next;
            }
            if(right==null){
                break;
            }
            //取尾结点的next
            ListNode next = right.next;
            //尾结点next指向null。也就是断开链表，进行翻转
            right.next=null;
            //取出头结点，也就是left的next，因为left是头结点的父节点
            ListNode start = left.next;
            //断开链表
            left.next=null;
            //翻转断开的这一部分，同时返回的是翻转后的头结点，并赋值给left的next节点
            left.next = reverse(start);
            //start节点其实是翻转后的尾结点，尾结点与之前断开的尾结点的next节点相连
            start.next = next;
            //翻转后的尾结点相当于下一次的left right，看做重置游标
            left = start;
            right = left;

        }
        return newHead.next;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
