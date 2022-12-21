package a1219;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *
 *    / \
 *
 *   2   2
 *
 *  / \ / \
 *
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *
 *    / \
 *
 *   2   2
 *
 *    \   \
 *
 *    3    3
 *
 *    <a href="https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        //层级遍历，取层节点，判断节点是否对称或者判断节点数量是否偶数
        Deque<TreeNode> queue = new LinkedList<>();
        if(root.left==null && root.right==null){
            return true;
        }
        if(root.left==null || root.right==null){
            return false;
        }
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()){
            int size = queue.size();
            if(size%2==0){
                //判断左右
                Deque<TreeNode> subDeque = new LinkedList<>();
                while (!queue.isEmpty()){
                    TreeNode first = queue.pollFirst();
                    TreeNode last = queue.pollLast();
                    if((first!=null && last!=null) && first.val != last.val){
                        return false;
                    }
                    if((first==null&&first!=last)||(last==null && first!=last)){
                        return false;
                    }
                    if(first!=null && last!=null && (first.left!=null||first.right!=null||last.left!=null|| last.right!=null)){
                        subDeque.offerFirst(first.left);
                        subDeque.offerFirst(first.right);
                        subDeque.offerLast(last.right);
                        subDeque.offerLast(last.left);
                    }
                }
                //处理完之后将当层的左右子节点继续放入队列中
                queue = subDeque;
            }else {
                return false;
            }
        }
        return true;
    }

    public boolean isSymmetric2(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }
    boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }


    public static void main(String[] args) {
        Offer_IsSymmetric offer_isSymmetric = new Offer_IsSymmetric();
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(2);
        TreeNode a1 = new TreeNode(3);
        TreeNode a2 = new TreeNode(4);
        TreeNode b1 = new TreeNode(4);
        TreeNode b2 = new TreeNode(3);

        root.left = a;
        root.right = b;

//        a.left = a1;
//        a.right = a2;
        a.right = new TreeNode(3);
//        b.left = b1;
//        b.right = b2;
        b.right = new TreeNode(3);
        System.out.println(offer_isSymmetric.isSymmetric(root));
    }
}
