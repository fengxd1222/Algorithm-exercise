package a1225;

import common.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 * <a href="https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_GetIntersectionNode {

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;
        while (a!=b){
            a = a==null?headA:a.next;
            b = b==null?headB:b.next;
        }
        return a;
    }
}
