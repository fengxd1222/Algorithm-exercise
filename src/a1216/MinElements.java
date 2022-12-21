package a1216;

import java.util.Stack;

/**
 * 给你一个整数数组 nums ，和两个整数 limit 与 goal 。数组 nums 有一条重要属性：abs(nums[i]) <= limit 。
 *
 * 返回使数组元素总和等于 goal 所需要向数组中添加的 最少元素数量 ，添加元素 不应改变 数组中 abs(nums[i]) <= limit 这一属性。
 *
 * 注意，如果 x >= 0 ，那么 abs(x) 等于 x ；否则，等于 -x 。
 * https://leetcode.cn/problems/minimum-elements-to-add-to-form-a-given-sum/
 */
public class MinElements {
    public static int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int x : nums) {
            sum += x;
        }
        long diff = Math.abs(sum - goal);
        return (int) ((diff + limit - 1) / limit);
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1,-1,1};
        System.out.println(MinElements.minElements(nums, 3, -4));
    }
}
