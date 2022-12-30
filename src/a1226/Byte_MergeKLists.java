package a1226;

import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 * <a href="https://leetcode.cn/problems/merge-k-sorted-lists/?envType=study-plan&id=zijie&plan=7d_zijie&plan_progress=yg0e3md">...</a>
 */
public class Byte_MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            while (list!=null){
                queue.add(list);
                list = list.next;
            }
        }
        ListNode root = new ListNode(-1);
        ListNode cur = queue.poll();
        root.next = cur;
        while (!queue.isEmpty()){
            ListNode poll = queue.poll();
            poll.next = null;
            cur.next = poll;
            cur = cur.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(-2);
        ListNode a2 = new ListNode(-1);
        ListNode a3 = new ListNode(-1);
        ListNode a4 = new ListNode(-1);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        Byte_MergeKLists mergeKLists = new Byte_MergeKLists();
        System.out.println(mergeKLists.mergeKLists(new ListNode[]{a1,null}));

    }
}
