package a1221;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * <a href="https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_MaxSubArray {
    public static int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int max=0;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre+nums[i],nums[i]);
            max = Math.max(pre,max);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(Offer_MaxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
