package a1214;

public class Offer_ReverseList {
    public ListNode reverseList(ListNode head) {

        if(head!=null && head.next!=null){
            System.out.println("递归前链表 "+head);
            ListNode listNode = reverseList(head.next);
            System.out.println("递归后返回值链表 "+listNode);
            ListNode next = head.next;
            head.next = null;
            next.next = head;
            return listNode;
        }
        return head;
    }

    public ListNode reverseList1(ListNode head) {

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


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        Offer_ReverseList reverseList = new Offer_ReverseList();

        ListNode node = new ListNode(1);
        ListNode node_1 = new ListNode(2);
        node.next = node_1;

        ListNode node_2 = new ListNode(3);
        node_1.next = node_2;

        ListNode node_3 = new ListNode(4);
        node_2.next = node_3;

//        System.out.println(reverseList.reverseList(node));
        System.out.println(reverseList.reverseList1(node));
    }
}
