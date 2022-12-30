package a1225;

import com.sun.xml.internal.bind.util.Which;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *
 * <a href="https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();

        //二分

        int left = 0;
        int right = nums.length-1;

        while (left<right){
            int sum = nums[left]+nums[right];
            if(sum>target){
                right--;
            }else if(sum<target){
                left++;
            }else {
                return new int[] { nums[left], nums[right] };
            }
        }



        /*int left = 0;
        int r = nums.length-1;

        while (left<r){
            int mid  = left+(r-left)/2;

            int midVal = nums[mid];
            if(midVal>target){
                r = mid;
            }else {
                r*=2;
                break;
            }

        }
        //超时
        for (int i = 0; i < r; i++) {
            if(nums[i]>target||res.size()==2)break;
            int right = i+1;
            while (right< nums.length){
                int a = target - nums[i] - nums[right];
                if(a==0){
                    res.add(nums[i]);
                    res.add(nums[right]);
                    break;
                }
                if(a>0){
                    right++;
                }else {
                    break;
                }

            }
        }*/

        //超时
//        List<Integer> res = new ArrayList<>();
//        Stack<Integer> stack = new Stack<>();
//        process(nums,0,target,res,stack);

        return new int[0];
    }

    private static void process(int[] nums, int index, int target, List<Integer> res, Stack<Integer> stack) {
        if(stack.size()>2){
            return;
        }
        if(target==0){
            res.addAll(new ArrayList<>(stack));
            return;
        }
        if(res.size()>=1){
            return;
        }

        if(target<0){
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if(nums[i]>target){
                return;
            }
            if(i>index&&nums[i]==nums[i-1]){
                continue;
            }
            stack.push(nums[i]);
            process(nums,i+1,target-nums[i],res,stack);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Offer_TwoSum.twoSum(new int[]{2,7,11,15},9)));
        System.out.println(Arrays.toString(Offer_TwoSum.twoSum(new int[]{10,26,30,31,47,60},40)));
        System.out.println(Arrays.toString(Offer_TwoSum.twoSum(new int[]{10,18,25,33,36,50,50,52,57,74},126)));
    }
}
