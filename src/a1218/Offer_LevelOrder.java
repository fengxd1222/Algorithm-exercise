package a1218;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <a href="https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_LevelOrder {

    public int[] levelOrder(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        List<Integer> array = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            array.add(treeNode.val);
            if(treeNode.left!=null){
                queue.offer(treeNode.left);
            }
            if(treeNode.right!=null){
                queue.offer(treeNode.right);
            }
        }
        return array.stream().mapToInt(Integer::intValue).toArray();
    }




}
