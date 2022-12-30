package a1225;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan&id=zijie&plan=7d_zijie&plan_progress=yg0e3md
 */
public class Byte_Trap {
    public int trap(int[] height) {

        int left = 1;
        int right = height.length-2;
        int leftMax = height[0];
        int rightMax = height[height.length-1];
        int max = 0;
        while (left<=right){
            if(leftMax<rightMax){
                max += Math.max(0,leftMax-height[left]);
                leftMax = Math.max(height[left], leftMax);
                left++;
            }else{
                max += Math.max(0,rightMax-height[right]);
                rightMax = Math.max(height[right],rightMax );
                right++;
            }
        }
        return max;
    }
}
