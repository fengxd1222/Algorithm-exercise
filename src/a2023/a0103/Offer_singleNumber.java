package a2023.a0103;

import java.util.ArrayList;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 * <a href="https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_singleNumber {
    public int singleNumber(int[] nums) {
        int[] res = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                res[i]+=num&1;
                num>>>=1;
            }
        }

        int ans = 0;

        for (int i = 0; i < 32; i++) {
            ans<<=1;
            ans |= res[31-i]%3;
        }
        return ans;
    }

    public static void main(String[] args) {
        Offer_singleNumber a = new Offer_singleNumber();
        System.out.println(a.singleNumber(new int[]{9,1,7,9,7,9,7}));
        System.out.println(a.singleNumber(new int[]{1,1,6,1}));
        new ArrayList<>();
    }
}
