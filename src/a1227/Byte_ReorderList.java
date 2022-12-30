package a1227;

import common.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 *
 * <a href="https://leetcode.cn/problems/reorder-list/?envType=study-plan&id=zijie&plan=7d_zijie&plan_progress=yg0e3md">...</a>
 */
public class Byte_ReorderList {

    public static void reorderList(ListNode head) {
        if(head==null){
            return;
        }

        Deque<ListNode> deque = new LinkedList<>();
        ListNode cur = head;
        while (cur!=null){
            deque.offer(cur);
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }

        ListNode root = new ListNode(0);
        cur = root;
        while (!deque.isEmpty()){
            ListNode first = deque.pollFirst();
            ListNode last = deque.pollLast();
            cur.next = first;
            first.next = last;
            cur = last;
        }
        head = root.next;
    }

    public static void recorderList2(ListNode head){
        //寻找中间节点
        ListNode mid = findMid(head);
        //翻转mid及其之后的链表
        ListNode last = reverseNode(mid);

        while (last!=null){
            ListNode next = head.next;
            ListNode next1 = last.next;

            head.next = last;
            last.next = next;

            head = next;
            last = next1;
        }

    }

    private static ListNode reverseNode(ListNode mid) {
        ListNode pre = null,cur = mid;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private static ListNode findMid(ListNode head) {
        ListNode slow = head,fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        a1.next = a2;a2.next = a3;a3.next = a4;
//        Byte_ReorderList.reorderList(a1);
        Byte_ReorderList.recorderList2(a1);
    }
}
