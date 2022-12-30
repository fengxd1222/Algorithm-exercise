package a1227;


import common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 *输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 * <a href="https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_TreeToDoublyList {

    public static Node treeToDoublyList1(Node root){
        if(root==null) return null;

        List<Node> nodes = new ArrayList<>();

        process(root,nodes);

        Node first = nodes.get(0);
        Node last = nodes.get(nodes.size()-1);
        for (int i = 0,j=1; i < nodes.size()-1; i++,j++) {
            Node pre = nodes.get(i);
            Node cur = nodes.get(j);
            pre.right = cur;
            cur.left = pre;
        }

        first.left = last;
        last.right = first;
        return first;
    }

    private static void process(Node root, List<Node> nodes) {
        if(root==null)return;

        process(root.left,nodes);
        nodes.add(root);
        process(root.right,nodes);
    }


    Node head, pre;
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        dfs(root);

        pre.right = head;
        head.left =pre;//进行头节点和尾节点的相互指向，这两句的顺序也是可以颠倒的

        return head;

    }

    public void dfs(Node cur){
        if(cur==null) return;
        dfs(cur.left);

        //pre用于记录双向链表中位于cur左侧的节点，即上一次迭代中的cur,当pre==null时，cur左侧没有节点,即此时cur为双向链表中的头节点
        if(pre==null) head = cur;
            //反之，pre!=null时，cur左侧存在节点pre，需要进行pre.right=cur的操作。
        else pre.right = cur;

        cur.left = pre;//pre是否为null对这句没有影响,且这句放在上面两句if else之前也是可以的。

        pre = cur;//pre指向当前的cur
        dfs(cur.right);//全部迭代完成后，pre指向双向链表中的尾节点
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        Node a1 = new Node(2);
        Node a2 = new Node(1);
        Node a3 = new Node(3);
        Node a4 = new Node(5);
        root.left = a1;
        root.right = a4;
        a1.left = a2;
        a1.right = a3;
        Offer_TreeToDoublyList offer_treeToDoublyList = new Offer_TreeToDoublyList();
//        System.out.println(offer_treeToDoublyList.treeToDoublyList(root));
        System.out.println(Offer_TreeToDoublyList.treeToDoublyList1(root));
        System.out.println(1);
    }
}
