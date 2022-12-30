package a1226;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 *
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *
 *  <a href="https://leetcode.cn/problems/longest-increasing-subsequence/?envType=study-plan&id=zijie&plan=7d_zijie&plan_progress=yg0e3md">...</a>
 */
public class Byte_LengthOfLIS_Point {
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        int max = 1;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        Byte_LengthOfLIS_Point byte_lengthOfLIS = new Byte_LengthOfLIS_Point();
        System.out.println(byte_lengthOfLIS.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(byte_lengthOfLIS.lengthOfLIS(new int[]{4,10,4,3,8,9}));
    }
}
