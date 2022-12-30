package a1230;

import a1212.Trap;
import common.TreeNode;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 * <a href="https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_IsBalanced {

    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }


    public static void main(String[] args) {
        //[1, 2,2, 3,3,3,3, 4,4,4,4,4,4,null,null, 5,5]
        TreeNode root = new TreeNode(1);

        TreeNode l2a = new TreeNode(2);
        TreeNode l2b = new TreeNode(2);
        root.left = l2a;
        root.right = l2b;

        TreeNode l3a = new TreeNode(3);
        TreeNode l3b = new TreeNode(3);
        TreeNode l3c = new TreeNode(3);
        TreeNode l3d = new TreeNode(3);

        l2a.left = l3a;
        l2a.right = l3b;
        l2b.left = l3c;
        l2b.right = l3d;

        TreeNode l4a = new TreeNode(4);
        TreeNode l4b = new TreeNode(4);
        TreeNode l4c = new TreeNode(4);
        TreeNode l4d = new TreeNode(4);
        TreeNode l4e = new TreeNode(4);
        TreeNode l4f = new TreeNode(4);

        l3a.left = l4a;
        l3a.right = l4b;

        l3b.left = l4c;
        l3b.right = l4d;

        l3c.left = l4e;
        l3c.right = l4f;

        l4a.left = new TreeNode(5);
        l4a.right = new TreeNode(5);

        Offer_IsBalanced offer_isBalanced = new Offer_IsBalanced();
        offer_isBalanced.isBalanced(root);

    }

}
