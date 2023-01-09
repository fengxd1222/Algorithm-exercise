package a2023.a0105;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定节点数为 n 的二叉树的前序遍历和中序遍历结果，请重建出该二叉树并返回它的头结点。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建出如下图所示。
 <a href="https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=265&tqId=39211&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13&difficulty=undefined&judgeStatus=undefined&tags=&title=">...</a> */
public class Nowcoder_reConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre, int [] vin) {
        Map<Integer,Integer> dict = new HashMap<>(vin.length);
        for (int i = 0; i < vin.length; i++) {
            dict.put(vin[i],i);
        }

        return process(pre,0,0,pre.length-1,0,vin.length-1,dict);

    }

    private TreeNode process(int[] pre, int root, int preLeft, int preRight, int vinLeft, int vinRight, Map<Integer, Integer> dict) {
        if(preLeft>preRight)return null;

        TreeNode curRoot = new TreeNode(pre[root]);
        Integer leftLength = dict.get(pre[root])-vinLeft;

        curRoot.left = process(pre,root+1,preLeft+1,preLeft+leftLength,vinLeft,vinLeft+leftLength-1,dict);

        curRoot.right = process(pre,root+leftLength+1,preLeft+leftLength+1,preRight,vinLeft+leftLength+1,vinRight,dict);
        return curRoot;
    }
}
