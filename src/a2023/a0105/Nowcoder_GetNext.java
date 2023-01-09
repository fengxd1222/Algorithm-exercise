package a2023.a0105;

import common.TreeLinkNode;

import java.util.Stack;

/**
 * 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，
 * 同时包含指向父结点的next指针。下图为一棵有9个节点的二叉树。树中从父节点指向子节点的指针用实线表示，从子节点指向父节点的用虚线表示
 *
 * <a href="https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=265&tqId=39212&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13&difficulty=undefined&judgeStatus=undefined&tags=&title=">...</a>
 */
public class Nowcoder_GetNext {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        //第一种情况：有右子树的情况下，他的最左叶子节点就是答案
        if(pNode.right!=null){
            TreeLinkNode right = pNode.right;
            while (right.left!=null){
                right = right.left;
            }
            return right;
        }
        //第二种情况：他是他父节点的左孩子，那么就返回他的父节点
        if(pNode.next != null && pNode.next.left == pNode)return pNode.next;

        //第三种情况，他是他父节点的右孩子，那就往上寻找 第二种情况
        if(pNode.next!=null){
            TreeLinkNode next = pNode.next;
            while (next.next!=null && next.next.right==next){
                next = next.next;
            }
            return next.next;
        }
        return null;
    }
}
