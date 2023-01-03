package a2023.a0102;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * <a href="https://leetcode.cn/company/mock-interview/1/">...</a>
 */
public class Meituan_uniquePathsWithObstacles {

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if(obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0]==null || obstacleGrid[0].length==0){
            return 0;
        }
        if(obstacleGrid[0][0]==1)return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        dp[0][0] =1;
        for (int i = 1; i < obstacleGrid.length; i++) {
            if(obstacleGrid[i][0]!=1){
                dp[i][0] = Math.min(1,dp[i-1][0]);
            }
        }
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if(obstacleGrid[0][i]!=1){
                dp[0][i] = Math.min(1,dp[0][i-1]);
            }
        }


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(obstacleGrid[i][j]!=1){
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0]==null || obstacleGrid[0].length==0){
            return 0;
        }
        return process(obstacleGrid,0,0);
    }

    private int process(int[][] obstacleGrid, int left, int right) {
        if(left>=obstacleGrid.length || right>=obstacleGrid[0].length){
            return 0;
        }
        if(obstacleGrid[left][right]==1){
            return 0;
        }
        if(left==obstacleGrid.length-1 && right==obstacleGrid[0].length-1){
            return 1;
        }
        obstacleGrid[left][right] = 1;
        int process1 = process( obstacleGrid, left + 1, right);
        int process = process(obstacleGrid, left, right + 1);
        obstacleGrid[left][right] = 0;
        return process+process1;
    }

    public static void main(String[] args) {
        Meituan_uniquePathsWithObstacles a = new Meituan_uniquePathsWithObstacles();

        System.out.println(a.uniquePathsWithObstacles(new int[][]{new int[]{0,0,0},new int[]{0,1,0},new int[]{0,0,0}}));
        System.out.println(a.uniquePathsWithObstacles1(new int[][]{new int[]{0,0,0},new int[]{0,1,0},new int[]{0,0,0}}));
        System.out.println(a.uniquePathsWithObstacles1(new int[][]{new int[]{0,0},new int[]{1,1},new int[]{0,0}}));
        System.out.println(a.uniquePathsWithObstacles1(new int[][]{new int[]{1,0}}));
    }
}
