package a2023.a0110;

import java.util.Arrays;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 *
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 *
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *
 * <a href="https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_dicesProbability {
    public double[] dicesProbability(int n) {
        
        double[] ans = new double[5*n+1];

        int curSum = n;
        double pow = Math.pow(6, n);
        for (int i = 0; i < ans.length; i++) {
            ans[i] = process(curSum,n)/pow;
            curSum++;
        }
        return ans;
    }

    private double process(int curSum, int n) {
        if(curSum<0||n<0){
            return 0;
        }
        if(curSum==0 && n==0){
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= 6; i++) {
            count+=process(curSum-i,n-1);
        }
        return count;
    }

    public double[] dicesProbability1(int n) {

        double[] ans = new double[5*n+1];

        int[][] dict = new int[ans.length+n][n+1];

        int curSum = n;
        double pow = Math.pow(6, n);
        for (int i = 0; i < ans.length; i++) {
            ans[i] = process1(curSum,n,dict)/pow;
            curSum++;
        }
        return ans;
    }

    private double process1(int curSum, int n, int[][] dict) {
        if(curSum<0||n<0){
            return 0;
        }
        if(dict[curSum][n]!=0){
            return dict[curSum][n];
        }
        if(curSum==0 && n==0){
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= 6; i++) {
            count+=process1(curSum-i,n-1,dict);
        }
        dict[curSum][n] = count;
        return count;
    }

    public double[] dicesProbability_dp(int n){
        double[] ans = new double[5*n+1];

        /*
        dp五部曲:假设投掷n个骰子总的投的次数为6^n
        1.状态定义:dp[i][j]为投掷i个骰子点数和为j的次数
        2.状态转移:dp[i][j]由dp[i-1][j-1],dp[i-1][j-2],...,dp[i-1][j-6]相加得到
            因此dp[i][j]=∑dp[i-1][j-k],其中1<=k<=6&&j-k>=i-1(j-k<i-1时dp[i][j]=0)
            举例:dp[2][4]=dp[1][3]+dp[1][2]+dp[1][1],dp[1][0]=0,投1次点数和不可能为0
            最本质的就是每当n+1,游戏规模会扩大6倍,也就是在6^n-1次的基础上重复玩了6个6^n-1次
            因此dp[i][j]的次数可以为dp[i-1][j-k]次数的和,而第n次玩的点数k为1-6概率相等
            因此对应dp[i-1][j-k]中重复的6次6^n-1每次选出dp[i-1][j-1],dp[i-1][j-2],...
            进行相加即就是转移过来的玩6^n次的dp[i][j]的次数
        3.初始化:只需要初始化dp[1][i]=1即可(1<=i<=6)
        4.遍历顺序:显然dp[i]是需要dp[i-1]推导的,而dp[i][j]是需要dp[i-1][j-k]推导
            因此j的遍历顺序没关系
        5.返回形式:将这5*n+1种出现的次数/6^n就是答案
        */
        //[筛子个数][点数]
        int[][] dict = new int[n + 1][6 * n + 1];

        double pow = Math.pow(6, n);
        for (int i = 1; i <= 6; i++) {
            dict[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6*i; j++) {

                //单单看第 n 枚骰子，它的点数可能为 1,2,3,...,6
                // 因此投掷完 n 枚骰子后点数 j 出现的次数，可以由投掷完 n−1 枚骰子后，
                // 对应点数 j−1,j−2,j−3,...,j−6出现的次数之和转化过来。

//                dict[i][j] += dict[i-1][j-1];
//                dict[i][j] += dict[i-1][j-2];
//                dict[i][j] += dict[i-1][j-3];
//                dict[i][j] += dict[i-1][j-4];
//                dict[i][j] += dict[i-1][j-6];
                //转化为循环，同时要判断一下 j-k是否大于0
                for (int k = 1; k <=6&&j-k>=0 ; k++) {
                    dict[i][j] += dict[i-1][j-k];
                }
            }
        }

        for (int i = n; i <=6*n ; i++) {
            ans[i-n] = dict[n][i]/pow;
        }
//        int curSum = n;
//        for (int i = 0; i < ans.length; i++) {
//            ans[i] = dict[n][curSum++] / pow;
//        }
        return ans;
    }



    public static void main(String[] args) {
        Offer_dicesProbability a = new Offer_dicesProbability();
//        System.out.println(Arrays.toString(a.dicesProbability(10)));
        double[] a1 = a.dicesProbability1(10);
        System.out.println(Arrays.toString(a1));
        System.out.println(a1.length);
        double[] a2 = a.dicesProbability_dp(10);
        System.out.println(Arrays.toString(a2));
        System.out.println(a2.length);

    }
}
