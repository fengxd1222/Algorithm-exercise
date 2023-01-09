package a2023.a0108;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *  <a href="https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];

        Deque<Integer> deque = new LinkedList<>();
        for (int j=0,i = 1-k; j < nums.length; i++,j++) {
            if(i>0 && deque.peekFirst()==nums[i-1]){
                deque.removeFirst();
            }

            while (!deque.isEmpty() && deque.peekLast()<nums[j]){
                deque.removeLast();
            }
            deque.addLast(nums[j]);
            if(i>=0){
                ans[i] = deque.peekFirst();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Offer_maxSlidingWindow a = new Offer_maxSlidingWindow();
        System.out.println(Arrays.toString(a.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
