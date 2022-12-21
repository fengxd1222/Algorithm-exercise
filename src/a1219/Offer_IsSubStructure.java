package a1219;


/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * 例如:
 * 给定的树 A:
 *
 *      3
 *
 *     / \
 *
 *    4   5
 *
 *   / \
 *
 *  1   2
 * 给定的树 B：
 *
 *    4
 *
 *   /
 *
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 */
public class Offer_IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null || B==null){
            return false;
        }
        //将两个树序列化
        return process(A,B);
    }

    private boolean process(TreeNode a, TreeNode b) {
        if(b==null){
            return true;
        }
        if(a==null){
            return false;
        }
        if(a.val==b.val){
            return (process(a.left, b.left) || process(a.right, b.right));
        }
        return process(a.left,b)||process(a.right,b);
    }
}
