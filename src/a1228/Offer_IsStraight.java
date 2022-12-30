package a1228;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * <a href="https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_IsStraight {
    public boolean isStraight(int[] nums) {
        if(nums==null||nums.length==0){
            return false;
        }

        int min = 0;
        int max = 0;

        Set<Integer> dict = new HashSet<>();

        for (int num : nums) {
            if(num==0){
                continue;
            }
            if(dict.contains(num)){
                return false;
            }
            dict.add(num);
            min = min==0?num:Math.min(min,num);
            max = Math.max(max,num);
        }
        return max-min <5;
    }
}
