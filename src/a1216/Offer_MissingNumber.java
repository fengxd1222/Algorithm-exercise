package a1216;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5
 */
public class Offer_MissingNumber {
    public static int missingNumber(int[] nums) {
        if(nums==null || nums.length==0){
            return -1;
        }

        int leftIndex = 0;
        int rightIndex = nums.length-1;
        int midIndex = 0;
        while (leftIndex<=rightIndex){
            midIndex = (leftIndex+rightIndex)/2;
            //在右边，左边界变为中间界限
            if(nums[midIndex]==midIndex){
                leftIndex = midIndex+1;
            }else {
                rightIndex = midIndex-1;
            }
        }

        return leftIndex;
    }

    public static void main(String[] args) {
        System.out.println(Offer_MissingNumber.missingNumber(new int[]{0,1,2,3,4,5,6,7,9}));
    }
}
