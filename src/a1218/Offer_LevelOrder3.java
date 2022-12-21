package a1218;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *    返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class Offer_LevelOrder3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        List<List<Integer>> array = new ArrayList<>();
        while (!queue.isEmpty()){
            List<TreeNode> needOfferNode = new ArrayList<>();

            //全取出来 再套一个循环
            while (!queue.isEmpty()){
                TreeNode treeNode = queue.poll();
                needOfferNode.add(treeNode);
            }
            if(needOfferNode.isEmpty()){
                continue;
            }
            List<Integer> subList = new ArrayList<>(needOfferNode.size());
            for (TreeNode treeNode : needOfferNode) {
                subList.add(treeNode.val);
                if(treeNode.left!=null){
                    queue.offer(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.offer(treeNode.right);
                }
            }
            array.add(subList);

        }
        return array;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(res.size()%2==0){
                Collections.reverse(tmp);
                res.add(tmp);
            }else {
                res.add(tmp);
            }

        }
        return res;
    }

}
