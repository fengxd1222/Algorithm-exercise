package a1223;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 * <a href="https://leetcode.cn/problems/number-of-islands/?envType=study-plan&id=zijie&plan=7d_zijie&plan_progress=yg0e3md">...</a>
 */
public class ByteDance_NumsIslands {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0||grid[0].length==0){
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            char[] chars = grid[0];
            for (int j = 0; j < chars.length; j++) {
                if(chars[j]=='1'){
                    process(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    private void process(char[][] grid, int i, int j) {
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]=='0'){
            return ;
        }
        if(grid[i][j]=='1'){
            grid[i][j] = '0';
            process(grid,i,j-1);
            process(grid,i,j+1);
            process(grid,i-1,j);
            process(grid,i+1,j);
        }
    }
}
