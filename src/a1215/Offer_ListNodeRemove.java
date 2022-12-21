package a1215;


/**
 * 单向链表 remove
 */
public class Offer_ListNodeRemove {
    /**
     * 1->2->3->3->5  移除3
     * node1    node2
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode remove(ListNode head, int val){

        while (head!=null){
            if(head.val!=val){
                break;
            }
            head = head.next;
        }

        ListNode node1 = head;
        ListNode node2 = head;
        while (node2!=null){
            if(node2.val==val){
                //跳过node2
                node1.next = node2.next;
            }else {
                node1 = node2;
            }
            node2 = node2.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node_1 = new ListNode(2);
        node.next = node_1;

        ListNode node_2 = new ListNode(3);
        node_1.next = node_2;

        ListNode node_3 = new ListNode(4);
        node_2.next = node_3;

        System.out.println(Offer_ListNodeRemove.remove(node,3));
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
}
