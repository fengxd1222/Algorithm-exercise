package a2023.a0109;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 */
public class Offer_serializeTreeNode {
    public String serialize(TreeNode root) {
        if(root==null)return null;
        StringBuilder stringBuilder = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        stringBuilder.append(root.val);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll.left!=null){
                queue.offer(poll.left);
                stringBuilder.append(",").append(poll.left.val);
            }else {
                stringBuilder.append(",").append("null");
            }
            if(poll.right!=null){
                queue.offer(poll.right);
                stringBuilder.append(",").append(poll.right.val);
            }else {
                stringBuilder.append(",").append("null");
            }

        }
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null)return null;

        String[] strs = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i=1;
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(!strs[i].equals("null")){
                poll.left = new TreeNode(Integer.parseInt(strs[i]));
                queue.offer(poll.left);
            }
            i++;
            if(!strs[i].equals("null")){
                poll.right = new TreeNode(Integer.parseInt(strs[i]));
                queue.offer(poll.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
    }
}
