package a1226;

import java.util.*;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * <a href="https://leetcode.cn/problems/permutations/?envType=study-plan&id=zijie&plan=7d_zijie&plan_progress=yg0e3md">...</a>
 */
public class Byte_Permute {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Set<Integer> dict = new LinkedHashSet<>();
        process(res,dict,nums,0);
        return res;
    }

    private static void process(List<List<Integer>> res, Set<Integer> set, int[] nums, int begin) {
        if(set.size()== nums.length){
            res.add(new ArrayList<>(set));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!set.isEmpty()&&set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            process(res,set,nums,i+1);
            set.remove(nums[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println(Byte_Permute.permute(new int[]{1,2,3}));
    }
}
