package a2023.a0105;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * * <a href="https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_findContinuousSequence {
    /**
     * 滑动窗口
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        int i=1,j=2,s=3;
        List<int[]> res = new ArrayList<>();
        while (i<j){
            if(s==target){
                int[] ans = new int[j-i+1];
                for (int k = i; k <= j; k++) {
                    ans[k-i] = k;
                }
                res.add(ans);
            }
            if(s>=target){
                s-=i;
                i++;
            }else {
                j++;
                s+=j;
            }
        }
        return res.toArray(new int[0][]);
    }
}
