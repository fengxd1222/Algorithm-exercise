package a2023.a0101;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 *
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 *
 *<a href="https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 *
 */
public class Offer_buildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> dict = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            dict.put(inorder[i],i );
        }
        return process(preorder,inorder,dict,0,0,inorder.length-1,0,preorder.length-1);
    }

    private TreeNode process(int[] preorder, int[] inorder, Map<Integer, Integer> dict, int root, int inorder_left, int inorder_right, int preorder_left, int preorder_right) {
        if(preorder_left>preorder_right)return null;

        TreeNode rootNode = new TreeNode(preorder[root]);
        int leftNumber = dict.get(preorder[root])-inorder_left;

        //前序遍历中，root的下一个节点为左子树的root节点，对应root+1，
        //中序遍历中，root节点的左边为左子树，边界就是【inorder_left，inorder_left+leftNumber-1或者root节点在中序遍历的位置-1】，
        //前序遍历中，第一个节点为根节点，左子树从第二个节点开始，即preorder_left+1，到preorder_left+左子树长度为止【preorder_left+1,preorder_left+leftNumber】
        rootNode.left = process(preorder,inorder,dict,root+1,inorder_left,inorder_left+leftNumber-1,preorder_left+1,preorder_left+leftNumber);

        //前序遍历中，root节点后数左子树的长度+1个，是右子树的root节点
        //中序遍历中，root节点的有边为右子树，边界就是【inorder_left+leftNumber+1或者root节点在中序遍历中的位置+1,inorder_right】
        //前序遍历中，左子树之后为右子树，所以按照上面左子树递归的参数从preorder_left+左子树长度+1开始算起，到preorder_right，【preorder_left+leftNumber+1,preorder_right】
        rootNode.right = process(preorder,inorder,dict,root+leftNumber+1,inorder_left+leftNumber+1,inorder_right,preorder_left+leftNumber+1,preorder_right);
        return rootNode;
    }

}
