package a1218;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums 和一个整数 k 。 nums 仅包含 0 和 1 。每一次移动，你可以选择 相邻 两个数字并将它们交换。
 *
 * 请你返回使 nums 中包含 k 个 连续 1 的 最少 交换次数。
 *
 * <a href="https://leetcode.cn/problems/minimum-adjacent-swaps-for-k-consecutive-ones/">...</a>
 */
public class MinMoves_Point {
    public int minMoves(int[] nums, int k) {

        List<Integer> zeros = new ArrayList<>();
        int z = 0;
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == 1){
                i++;
                break;
            }
        }
        for (; i < nums.length; i++) {
            if (nums[i] == 1){
                zeros.add(z);
                z = 0;
            }else {
                z++;
            }
        }
        int cost = 0;
        for (int j = 0; j < k-1; j++) {
            cost += zeros.get(j)*Math.min(j+1, k-j-1);
        }
        int[] pre = new int[zeros.size()+1];
        for (int j = 1; j <= zeros.size(); j++) {
            pre[j] += zeros.get(j-1)+pre[j-1];
        }
        int temp = cost;
        for (int j = k-1; j < zeros.size(); j++) {
            temp -= pre[k/2+(j-k+1)]-pre[j-k+1];
            temp += pre[j+1]-pre[k/2+(j-k+1)+k%2];
            cost = Math.min(temp, cost);
        }
        return cost;
    }


}
