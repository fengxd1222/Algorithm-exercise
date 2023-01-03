package a2023.a0101;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 * <a href="https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_verifyPostorder {
    public boolean verifyPostorder(int[] postorder) {


        return process(postorder,0,postorder.length-1);
    }

    private boolean process(int[] postorder, int left, int right) {
        if(left>=right)return true;

        int a = left;
        while (postorder[a]<postorder[right])a++;

        int m = a;
        while (postorder[a]>postorder[right])a++;
        return a==right && process(postorder,left,m-1)&&process(postorder,m,right-1);
    }

}
