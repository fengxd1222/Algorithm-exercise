package a1225;

import common.ListNode;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * <a href="https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_Exchange {
    public static int[] exchange(int[] nums) {

        int left = 0;
        int right = nums.length-1;
        while (left<right){
            while (left<right&&(nums[left]&1)==1)left++;
            while (left<right&&(nums[right]&1)==0)right--;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Offer_Exchange.exchange(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(Offer_Exchange.exchange(new int[]{1, 2, 3, 4,5,7,8})));
    }

}
