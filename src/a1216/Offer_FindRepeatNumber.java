package a1216;

/**
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5
 */
public class Offer_FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            while (cur!=i){
                int target = nums[cur];
                if(target==cur){
                    return target;
                }
                nums[cur] = cur;
                nums[i] = target;
                cur = target;
            }
        }
        return 0;
    }
}
