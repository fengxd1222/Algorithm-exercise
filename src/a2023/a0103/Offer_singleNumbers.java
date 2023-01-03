package a2023.a0103;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * <a href="https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_singleNumbers {
    public int[] singleNumbers(int[] nums) {
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }

        int rightOne = eor&(~eor+1);
        int newEor = 0;
        for(int i=0;i<nums.length;i++){
            //将数组中数字分为两类，一个是和eor最右侧的1一样的，一个是不一样的，然后因为同一个数字分出来肯定还是偶数次，最终异或出来的就是这个数字，剩下的那个数字只需要让eor与newEor异或就可得出来
            if((rightOne&nums[i])!=0){
                newEor ^= nums[i];
            }
        }
        return new int[]{newEor,eor^newEor};
    }
}
