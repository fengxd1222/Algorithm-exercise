package a1217;

/**
 * 给你一个长度为 n 的二维整数数组 groups ，同时给你一个整数数组 nums 。
 *
 * 你是否可以从 nums 中选出 n 个 不相交 的子数组，使得第 i 个子数组与 groups[i] （下标从 0 开始）完全相同，且如果 i > 0 ，那么第 (i-1) 个子数组在 nums 中出现的位置在第 i 个子数组前面。（也就是说，这些子数组在 nums 中出现的顺序需要与 groups 顺序相同）
 *
 * 如果你可以找出这样的 n 个子数组，请你返回 true ，否则返回 false 。
 *
 * 如果不存在下标为 k 的元素 nums[k] 属于不止一个子数组，就称这些子数组是 不相交 的。子数组指的是原数组中连续元素组成的一个序列。
 *
 * 输入：groups = [[1,-1,-1],[3,-2,0]], nums = [1,-1,0,1,-1,-1,3,-2,0]
 * 输出：true
 * 解释：你可以分别在 nums 中选出第 0 个子数组 [1,-1,0,1,-1,-1,3,-2,0] 和第 1 个子数组 [1,-1,0,1,-1,-1,3,-2,0] 。
 * 这两个子数组是不相交的，因为它们没有任何共同的元素。
 *
 * <a href="https://leetcode.cn/problems/form-array-by-concatenating-subarrays-of-another-array/">...</a>
 */
public class CanChoose {
    public static boolean canChoose(int[][] groups, int[] nums) {

        int numsIndex = 0;
        for (int[] group : groups) {
            int groupIndex = 0;
            while (groupIndex<group.length && numsIndex<nums.length){
                if(group[groupIndex]==nums[numsIndex++]){
                    groupIndex++;
                }else {
                    numsIndex -= groupIndex;
                    groupIndex=0;
                }
            }
            if(numsIndex>=nums.length && groupIndex!=group.length){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] groups = new int[][]{new int[]{10,-2},new int[]{1,2,3,4}};
        int[] nums = new int[]{1,2,3,4,10,-2};
        System.out.println(CanChoose.canChoose(groups,nums));

        int[][] groups1 = new int[][]{new int[]{1,-1,-1},new int[]{3,-2,0}};
        int[] nums1 = new int[]{1,-1,0,1,-1,-1,3,-2,0};
        System.out.println(CanChoose.canChoose(groups1,nums1));


        int[][] groups2 = new int[][]{new int[]{-5,0}};
        int[] nums2 = new int[]{2,0,-2,5,-1,2,4,3,4,-5,-5};
        System.out.println(CanChoose.canChoose(groups2,nums2));
    }
}
