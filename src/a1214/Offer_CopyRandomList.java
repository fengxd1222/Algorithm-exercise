package a1214;

import java.util.HashMap;
import java.util.Map;

public class Offer_CopyRandomList {

    Map<Node, Node> nodeMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!nodeMap.containsKey(head)) {
            Node newNode = new Node(head.val);
            nodeMap.put(head,newNode);
            Node next = copyRandomList(head.next);
            Node random = copyRandomList(head.random);
            newNode.next = next;
            newNode.random = random;
        }
        return nodeMap.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
