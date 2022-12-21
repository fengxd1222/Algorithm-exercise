package a1220;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 * 提示：
 *
 * 0 <= n <= 100
 *
 * <a href="https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_FrogJumpNumWays {
    public int numWays(int n) {
        if(n==0){
            return 1;
        }
        return process(n-1)+process(n-2);
    }

    /**
     *
     * @param n 剩余步数
     * @return
     */
    private int process(int n) {
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        return process(n-1)+process(n-2);
    }


    public int numWays1(int n) {
        if(n==0){
            return 1;
        }
        int l = 0;
        int r = 1;
        int c = 0;
        for (int i = 1; i <=n ; i++) {
            c = (l+r)%1000000007;
            l=r;
            r=c;
        }
        return c;
    }

}
