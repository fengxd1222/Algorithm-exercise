package a2023.a0101;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <a href="https://leetcode.cn/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_lowestCommonAncestorII {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null; // 如果树为空，直接返回null
        if(root == p || root == q) return root; // 如果 p和q中有等于 root的，那么它们的最近公共祖先即为root（一个节点也可以是它自己的祖先）
        TreeNode left = lowestCommonAncestor(root.left, p, q); // 递归遍历左子树，只要在左子树中找到了p或q，则先找到谁就返回谁
        TreeNode right = lowestCommonAncestor(root.right, p, q); // 递归遍历右子树，只要在右子树中找到了p或q，则先找到谁就返回谁
        if(left == null) return right; // 如果在左子树中 p和 q都找不到，则 p和 q一定都在右子树中，右子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        else if(right == null) return left; // 否则，如果 left不为空，在左子树中有找到节点（p或q），这时候要再判断一下右子树中的情况，如果在右子树中，p和q都找不到，则 p和q一定都在左子树中，左子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        else return root; //否则，当 left和 right均不为空时，说明 p、q节点分别在 root异侧, 最近公共祖先即为 root
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode,TreeNode> nodeMap = new HashMap<>();

        nodeMap.put(p,null);
        nodeMap.put(q,null);
        process(root,p,q,nodeMap);
        return nodeMap.get(p);
    }

    private void process(TreeNode root, TreeNode p, TreeNode q, Map<TreeNode, TreeNode> nodeMap) {
        if(root==null)return;

        process(root.left,p,q,nodeMap);
        process(root.right,p,q,nodeMap);


        if(nodeMap.get(p)!=null && nodeMap.get(q)!=null && nodeMap.get(q).val==nodeMap.get(p).val){
            return;
        }

        if(nodeMap.get(p)!=null && (nodeMap.get(p).equals(root.left)||nodeMap.get(p).equals(root.right))){
            nodeMap.put(p,root);
        }

        if(nodeMap.get(q)!=null && (nodeMap.get(q).equals(root.left)||nodeMap.get(q).equals(root.right))){
            nodeMap.put(q,root);
        }

        if(root.val == p.val){
            nodeMap.put(p,root);
        }
        if(root.val == q.val){
            nodeMap.put(q,root);
        }
    }
}
