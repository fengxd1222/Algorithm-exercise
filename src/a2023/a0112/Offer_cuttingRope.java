package a2023.a0112;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * <a href="https://leetcode.cn/problems/jian-sheng-zi-ii-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5"> </a>
 */
public class Offer_cuttingRope {
    public int cuttingRope(int n) {
        long[] dp = new long[n+1];
        dp[2] = 1;
        for (int i = 3; i <=n ; i++) {
            for (int j = 2; j < i; j++) {
                int ans = j * (i - j);
//                dp[i] = dp[i].max(BigInteger.valueOf(ans)).max(dp[i-j].multiply(BigInteger.valueOf(j)));
                dp[i] = Math.max(dp[i],Math.max(ans,j*dp[i-j]));
            }
        }
//        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
        return (int) (dp[n]%1000000007);
    }

    public int cuttingRope1(int n) {
        BigInteger[] dp = new BigInteger[n+1];
        Arrays.fill(dp,BigInteger.valueOf(0));
        dp[2] = BigInteger.valueOf(1);
        for (int i = 3; i <=n ; i++) {
            for (int j = 2; j < i; j++) {
                int ans = j * (i - j);
                dp[i] = dp[i].max(BigInteger.valueOf(ans)).max(dp[i-j].multiply(BigInteger.valueOf(j)));
            }
        }
        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }

    public static void main(String[] args) {
        Offer_cuttingRope a = new Offer_cuttingRope();
        System.out.println(a.cuttingRope(10));
        System.out.println(a.cuttingRope(120));
        System.out.println(a.cuttingRope1(120));
    }
}
