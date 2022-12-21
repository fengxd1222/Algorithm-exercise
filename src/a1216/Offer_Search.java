package a1216;

/**
 * 统计一个数字在排序数组中出现的次数。
 * https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5
 */
public class Offer_Search {
    public static int search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length-1;
        int midIndex = 0;
        while (leftIndex<=rightIndex){
            midIndex = (leftIndex+rightIndex)/2;
            //在右边，左边界变为中间界限
            if(nums[midIndex]<target){
                leftIndex = midIndex+1;
            }else if(nums[midIndex]>target){
                rightIndex = midIndex-1;
            } else {
                break;
            }
        }
        if(rightIndex==leftIndex && nums[leftIndex]!=target){
            return 0;
        }
        leftIndex = midIndex;
        rightIndex = midIndex;

        while (leftIndex-1>=0){
            if(nums[leftIndex-1]==target){
                leftIndex--;
            }else {
                break;
            }
        }
        while (rightIndex+1<nums.length){
            if(nums[rightIndex+1]==target){
                rightIndex++;
            }else {
                break;
            }
        }
        if(leftIndex <= rightIndex && rightIndex < nums.length && nums[leftIndex] == target && nums[rightIndex] == target){
            return rightIndex-leftIndex+1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Offer_Search.search(new int[]{5,7,7,10},6));
        System.out.println(Offer_Search.search(new int[]{2,2},2));
        System.out.println(Offer_Search.search(new int[]{1,2},2));
    }
}
