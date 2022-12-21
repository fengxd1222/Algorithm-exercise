package dp01;

import java.util.Arrays;

/**
 * 假设有排成一行的N个位置，记为1-N，N一定大于或者等于2，开始时机器人在其中的M位置上（M一定是1-N中的一个）；
 *
 * 如果机器人来到1位置，那么下一步只能往右到2位置；
 *
 * 如果在N位置，下一步只能到N-1位置；
 *
 * 如果在中间位置，下一步可以往左或右；
 *
 * 规定机器人必须走K步，最终来到P位置（P在1-N之间）；
 *
 * 给定四个参数N、M、K、P，返回方法数。
 */
public class StepCount {
    /**
     * 暴力递归
     * @param N
     * @param M
     * @param K
     * @param P
     * @return
     */
    public static int way1(int N,int M,int K,int P){
        return process1(N,M,K,P);
    }

    /**
     * 暴力递归
     * @param n 当前有几个数
     * @param m 机器人当前的位置
     * @param k 还剩下几步
     * @param p 最终目标位置
     * @return
     */
    private static int process1(int n, int m, int k, int p) {
        //如果机器人还剩0步，判断是否在目标上
        if(k==0){
            return m==p?1:0;
        }
        //如果机器人在最左或最右，只能相反移动
        if(m==1){
            return process1(n,2,k-1,p);
        }
        if(m==n){
            return process1(n,m-1,k-1,p);
        }
        //在中间的情况有两种，一种向左，一种向右
        return process1(n,m-1,k-1,p)+process1(n,m+1,k-1,p);
    }

    /**
     * 空间换时间，加入缓存，重点是辨别出变化的参数，变化的参数可以当做key，他们计算出来的值为value
     * 在此处，机器人所在的位置和还剩下几步，是key，计算出来的方法数是value，由此推出，可用二维数组存储
     * @param N 当前有几个数
     * @param M 机器人当前的位置
     * @param K 还剩下几步
     * @param P 最终目标位置
     * @return
     */
    public static int way2(int N,int M,int K,int P){
        int[][] dp = new int[N+1][K+1];
        //初始化值
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return process2(N,M,K,P,dp);
    }

    /**
     *
     * @param n
     * @param m
     * @param k
     * @param p
     * @param dp
     * @return
     */
    private static int process2(int n, int m, int k, int p, int[][] dp) {
        if(dp[m][k]!=-1){
            return dp[m][k];
        }
        int res = 0;

        //如果机器人还剩0步，判断是否在目标上
        if(k==0){
            res = m==p?1:0;
        }
        //如果机器人在最左或最右，只能相反移动
        else if(m==1){
            res = process2(n,2,k-1,p,dp);
        }
        else if(m==n){
            res = process2(n,m-1,k-1,p,dp);
        }else {
            //在中间的情况有两种，一种向左，一种向右
            res = process2(n,m-1,k-1,p,dp)+process2(n,m+1,k-1,p,dp);
        }
        dp[m][k] = res;
        return res;
    }


    /**
     * 列出二维数组图，通过关系式计算推导 撞墙的杨辉三角
     * @param N 当前有几个数
     * @param M 机器人当前的位置
     * @param K 还剩下几步
     * @param P 最终目标位置
     * @return
     */
    public static int way3(int N,int M,int K,int P){
        int[][] dp = new int[K+1][N+1];
        //初始化值
        dp[0][P]=1;
        for (int i = 1; i < dp.length; i++) {
            dp[i][1] = dp[i-1][2];
            for (int j = 2; j <= N-1; j++) {
                dp[i][j] = dp[i-1][j+1] + dp[i-1][j-1];
            }
            dp[i][N] = dp[i-1][N-1];
        }
        return dp[K][M];
    }

    public static void main(String[] args) {
        System.out.println(way1(4,2,4,4));
        System.out.println(way2(5,2,6,4));
        System.out.println(way3(5,2,6,4));
    }
}
