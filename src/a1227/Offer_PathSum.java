package a1227;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * <a href="https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_PathSum {

    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        stack.push(root.val);
        process(root,target-root.val,res,stack);
        return res;
    }

    private static void process(TreeNode root, int target, List<List<Integer>> res, Stack<Integer> stack) {
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null&&target==0){
            res.add(new ArrayList<>(stack));
            return;
        }

        if(root.left!=null){
            stack.push(root.left.val);
            process(root.left,target- root.left.val,res,stack);
            stack.pop();
        }
        if(root.right!=null){
            stack.push(root.right.val);
            process(root.right,target- root.right.val,res,stack);
            stack.pop();
        }
    }

    public static void main(String[] args) {

        TreeNode root= new TreeNode(5);

        TreeNode a1 = new TreeNode(4);
        TreeNode a2 = new TreeNode(11);
        TreeNode a3 = new TreeNode(7);
        TreeNode a4 = new TreeNode(2);
        a1.left = a2;
        a2.left=a3;
        a2.right=a4;
        root.left=a1;

        TreeNode b1 = new TreeNode(8);
        TreeNode b2 = new TreeNode(13);
        TreeNode b3 = new TreeNode(4);
        TreeNode b4 = new TreeNode(5);
        TreeNode b5 = new TreeNode(1);

        b1.left = b2;
        b1.right=b3;
        b3.left = b4;
        b3.right = b5;

        root.right = b1;

        System.out.println(Offer_PathSum.pathSum(root,22));
    }
}
