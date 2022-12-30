package a1227;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Offer_KthLargest {
    public int kthLargest(TreeNode root, int k) {
        if(root==null)return 0;

        List<Integer> res = new ArrayList<>();

        process(root,res);
        return res.get(res.size()-k);
    }

    private void process(TreeNode root, List<Integer> res) {
        if(root==null)return;
        process(root.left,res);
        res.add(root.val);
        process(root.right,res);
    }
}
