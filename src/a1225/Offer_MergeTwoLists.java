package a1225;

import common.ListNode;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * <a href="https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode curLeft = l1;
        ListNode curRight = l2;

        ListNode root = new ListNode(-1);
        ListNode cur = root;
        while (curLeft!=null && curRight!=null){
            ListNode leftNext = curLeft.next;
            ListNode rightNext = curRight.next;
            if(curLeft.val<=curRight.val){
                curLeft.next=null;
                cur.next = curLeft;
                cur = curLeft;
                curLeft = leftNext;
            }else {
                curRight.next=null;
                cur.next = curRight;
                cur = curRight;
                curRight = rightNext;
            }
        }

        while (curLeft!=null){
            cur.next = curLeft;
            cur = curLeft;
            curLeft = curLeft.next;
        }
        while (curRight!=null){
            cur.next = curRight;
            cur = curRight;
            curRight = curRight.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a4 = new ListNode(4);
        a1.next = a2;a2.next = a4;

        ListNode b1 = new ListNode(1);
        ListNode b3 = new ListNode(3);
        ListNode b4 = new ListNode(4);
        b1.next = b3;b3.next = b4;

        System.out.println(Offer_MergeTwoLists.mergeTwoLists(a1,b1));
    }

}
