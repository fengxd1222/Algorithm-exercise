package a1221;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 *
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * <a href="https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_GiftMaxValue {
    public int maxValue(int[][] grid) {
        return process(grid,0,0);
    }

    private int process(int[][] grid, int i, int j) {
        if(i> grid.length-1||j>grid[0].length-1){
            return 0;
        }
        return Math.max(grid[i][j]+process(grid,i+1,j),grid[i][j]+process(grid,i,j+1));
    }

    public int dp(int[][] grid){
        if(grid==null || grid.length==0 || grid[0].length==0){
            return 0;
        }
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        for (int i = grid.length-1; i >=0 ; i--) {
            for (int j = grid[0].length-1; j >=0; j--) {
                dp[i][j] = Math.max(grid[i][j]+dp[i+1][j],grid[i][j]+dp[i][j+1]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Offer_GiftMaxValue offer_giftMaxValue = new Offer_GiftMaxValue();
        System.out.println(offer_giftMaxValue.maxValue(new int[][]{new int[]{1,3,1},new int[]{1,5,1},new int[]{4,2,1}}));
        System.out.println(offer_giftMaxValue.dp(new int[][]{new int[]{1,3,1},new int[]{1,5,1},new int[]{4,2,1}}));
    }
}
