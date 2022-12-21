package a1219;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *
 *    /   \
 *
 *   2     7
 *
 *  / \   / \
 *
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *
 *    /   \
 *
 *   7     2
 *
 *  / \   / \
 *
 * 9   6 3   1
 * <a href="https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 *
 */

public class Offer_MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {

        process(root);
        return root;
    }

    private void process( TreeNode root) {
       if(root==null)return;
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = right;
        root.right = left;
        process(root.left);
        process(root.right);
    }
}
