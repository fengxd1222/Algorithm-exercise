package a1212;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Trap {
    /**
     * 构建两个数组，left从左向右的最大高度，right从右向左的最大高度，同一个位置的最小值减去当前的高度就是能放的水
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        
        left[0] = height[0];
        right[height.length-1] = height[height.length-1];

        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }

        for (int i = height.length-2; i >=0; i--) {
            right[i] = Math.max(right[i+1],height[i] );
        }

        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(left[i],right[i])-height[i];
        }
        return ans;
    }
}
