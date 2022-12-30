package a1230;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 层序或者递归
 */
public class Offer_MaxDepth {

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxDepth = 1;
        while (!queue.isEmpty()){
            List<TreeNode> cur = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode poll = queue.poll();
                if(poll.left!=null){
                    cur.add(poll.left);
                }
                if(poll.right!=null){
                    cur.add(poll.right);
                }
            }
            if (cur.size() > 0) {
                maxDepth++;
                for (TreeNode treeNode : cur) {
                    queue.offer(treeNode);
                }
            }
        }
        return maxDepth;
    }

    public int maxDepth2(TreeNode root) {
        if(root==null){
            return 0;
        }
        return process(root);
    }

    private int process(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max((1+process(root.left)),(1+process(root.right)));
    }


}
