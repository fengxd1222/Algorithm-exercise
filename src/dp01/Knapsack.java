package dp01;

/**
 * 有N件物品，第i个物品的重量为w[i]，价值为v[i]。求在总重量不超过W的情况下能装入背包的最大价值。
 */
public class Knapsack {
    /**
     * 背包问题
     * @param w 重量
     * @param v 价值
     * @param bag 总重量
     * @return
     */
    public static int getMaxValue1(int[] w,int [] v,int bag){
        return process1(w,v,0,bag);
    }

    private static int process1(int[] w, int[] v, int index,  int bag) {
        //判断背包剩余重量
        if(bag<0){
            return 0;
        }
        if(index==w.length){
            return 0;
        }
        //有两种选择，选择当前货物，or 不选择
        int p1 = process1(w,v,index+1,bag);

        //选择，但是需要判断选择后的背包是否无效
        int p2 = 0;
        if(bag-w[index]>=0){
            p2 = v[index] + process1(w,v,index+1,bag-w[index]);
        }

        return Math.max(p1,p2);
    }

    public static int dp(int[] w, int[] v, int bag){
        int[][] dp = new int[w.length][bag+1];
        for (int index = w.length-2; index >=0 ; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[index+1][rest];
                int p2 = 0;
                if(rest-w[index]>=0){
                    p2 = v[index] + dp[index+1][rest-w[index]];
                }
                dp[index][rest] = Math.max(p1,p2);
            }
        }
        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] w = {3,2,4,7,3,1,7};
        int[] v = {5,6,3,19,12,4,2};
        int bag = 15;
        System.out.println(getMaxValue1(w,v,bag));
        System.out.println(dp(w,v,bag));

    }
}
