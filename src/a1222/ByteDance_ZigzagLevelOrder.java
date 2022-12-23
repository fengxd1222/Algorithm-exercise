package a1222;

import javax.management.relation.Role;
import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 */
public class ByteDance_ZigzagLevelOrder {

    /**
     * 层序遍历的变种
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        if(root.left==null && root.right==null){
            res.add(Collections.singletonList(root.val));
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            for (int i = queue.size()-1; i >=0 ; i--) {
                TreeNode poll = queue.poll();
                subList.add(poll.val);
                if(poll.left!=null)queue.offer(poll.left);
                if(poll.right!=null)queue.offer(poll.right);
            }
            if(res.size()%2==0){

                res.add(subList);
            }else {
                Collections.reverse(subList);
                res.add(subList);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println();
    }

}
