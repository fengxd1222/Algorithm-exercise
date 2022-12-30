package a1226;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * <a href="https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_MovingCount {
    public int movingCount(int m, int n, int k) {

        boolean[][] dict = new boolean[m][n];
        return process(m,n,0,0,k,dict);
    }

    private int process(int m, int n, int i, int j, int k, boolean[][] dict) {
        if(i<0||j<0||i>=m||j>=n||dict[i][j]){
            return 0;
        }
        int sum = i % 10 + j % 10 + i / 10 + j / 10;
        if(sum>k){
            return 0;
        }
        dict[i][j] = true;
        int res = process(m, n, i + 1, j, k, dict) + process(m, n, i - 1, j, k, dict) + process(m, n, i, j + 1, k, dict) + process(m, n, i, j - 1, k, dict);
        return 1+res;
    }

    public static void main(String[] args) {
//        int sum = 0;
//        int number = 123456;
//        while (number>10){
//            sum+= number % 10;
//            number = number/10;
//        }
//        System.out.println(sum);
//        System.out.println(12345%10);
        Offer_MovingCount m = new Offer_MovingCount();
        System.out.println(m.movingCount(2,3,1));
        System.out.println(m.movingCount(2,3,1));
        System.out.println(m.movingCount(3,1,0));
    }

}
