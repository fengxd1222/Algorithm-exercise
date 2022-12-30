package a1211;

import java.util.Arrays;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * https://leetcode.cn/problems/first-missing-positive/
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 ) {
                nums[i] = nums.length+1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if(num<=nums.length){
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {

        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1,6,-4,-6}));

    }
}
