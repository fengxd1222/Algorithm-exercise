package a2023.a0104;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * <a href="https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_majorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> dict = new HashMap<>();
        int tar = nums.length/2;
        for (int num : nums) {
            Integer orDefault = dict.getOrDefault(num, 0);
            if(orDefault>=tar)return num;
            dict.put(num,orDefault+1);
        }
        return 0;
    }

    /**
     * 摩尔投票
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        int x = 0,count=0;
        for (int num : nums) {
            if(count==0)x=num;
            count+= x==num?1:-1;
        }
        return x;
    }



    public static void main(String[] args) {
        Offer_majorityElement a = new Offer_majorityElement();
        System.out.println(a.majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
        System.out.println(a.majorityElement1(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }


}
