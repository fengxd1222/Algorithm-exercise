package a1214;

import java.util.Stack;

public class Offer_ReversePrint {
    public int[] reversePrint(ListNode head) {

        Stack<Integer> stack = new Stack<>();

        while (head!=null){
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int index=0;
        while (!stack.isEmpty()){
            res[index] = stack.pop();
            index++;
        }

        return res;
    }


    public static void main(String[] args) {
        Offer_ReversePrint reversePrint = new Offer_ReversePrint();
        ListNode node = new ListNode(1);
        ListNode node_1 = new ListNode(2);
        node.next = node_1;

        ListNode node_2 = new ListNode(3);
        node_1.next = node_2;

        ListNode node_3 = new ListNode(4);
        node_2.next = node_3;

        int[] ints = reversePrint.reversePrint(node);
        System.out.println(ints);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
