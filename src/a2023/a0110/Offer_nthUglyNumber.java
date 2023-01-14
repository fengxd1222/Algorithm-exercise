package a2023.a0110;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 *
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 * <a href="https://leetcode.cn/problems/chou-shu-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_nthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0]=1;
        int a=0,b=0,c=0;
        for (int i = 0; i < n; i++) {
            int dpa = dp[a]*2;
            int dpb = dp[b]*3;
            int dpc = dp[c]*5;
            dp[i] = Math.min(dpa,Math.min(dpc,dpb));
            if(dp[i]==dpa){
                a++;
            }
            if(dp[i]==dpb){
                b++;
            }
            if(dp[i]==dpc){
                c++;
            }

        }
        return dp[n-1];
    }
}
