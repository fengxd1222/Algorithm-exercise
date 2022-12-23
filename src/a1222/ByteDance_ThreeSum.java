package a1222;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 *
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 *
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0
 * <a href="https://leetcode.cn/problems/3sum/?envType=study-plan&id=zijie&plan=7d_zijie&plan_progress=yg0e3md">...</a>
 */
public class ByteDance_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        //使用三指针，固定一个指针，挪动其他两个指针，判断值，

        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i]>0)return res;
            if(i>0&&nums[i]==nums[i-1])continue;
            int left = i+1,right = nums.length-1;
            while (left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //当前i已经固定，如果nums[left]和nums[left+1]相等，跳过,否则会重复
                    while (left<right&&nums[left]==nums[++left]);
                    //right同理
                    while (left<right&&nums[right]==nums[--right]);
                    continue;
                }
                if (sum<0){
                    while (left<right&&nums[left]==nums[++left]);
                }
                if (sum>0){
                    while (left<right&&nums[right]==nums[--right]);
                }

            }
        }
        
        //时间复杂度过高，超时
//        Stack<Integer> stack = new Stack<>();
//        process(res,nums,stack,0,0);
        return res;
    }

    private void process(List<List<Integer>> res, int[] nums, Stack<Integer> stack, int index, int target) {
        if(target!=0 && stack.size()==3){
            return;
        }
        if(target==0 && stack.size()==3){
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if(nums[i]+target>0){
                return;
            }
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            stack.push(nums[i]);
            process(res,nums,stack,i+1,target+nums[i]);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        ByteDance_ThreeSum byteDance_threeSum = new ByteDance_ThreeSum();
        System.out.println(byteDance_threeSum.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
