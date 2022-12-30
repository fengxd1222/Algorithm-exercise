package a1226;

import common.ListNode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <a href="https://leetcode.cn/problems/binary-tree-right-side-view/?envType=study-plan&id=zijie&plan=7d_zijie&plan_progress=yg0e3md">...</a>
 */
public class Byte_RightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        if(root==null )return new ArrayList<>();

        List<Integer> res= new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.peek();
            res.add(poll.val);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.right!=null){
                    queue.offer(node.right);
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode4;
        System.out.println(Byte_RightSideView.rightSideView(treeNode));
    }

}
