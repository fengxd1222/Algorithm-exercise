package a2023.a0102;

/**
 * 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：9
 * 示例 2：
 *
 * 输入：grid = [[1,1,0,0]]
 * 输出：1
 */
public class Meituan_largest1BorderedSquare {
    public int largest1BorderedSquare(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0]==null || grid[0].length==0){
            return 0;
        }
        int max = 0;
        if(grid[0][0]==1){
            max = 1;
        }
        return Math.max(max,Math.max(process(grid,1,0),process(grid,0,1)));
    }

    private int process(int[][] grid, int left, int right) {
        if(left>=grid.length || right>=grid[0].length){
            return 0;
        }
        if(grid[left][right]==0){
            return 0;
        }
        if(left==right){
            return (int) Math.pow(left+1,2);
        }
        return Math.max(process(grid,left+1,right),process(grid,left,right+1));
    }

    public static void main(String[] args) {
        Meituan_largest1BorderedSquare a = new Meituan_largest1BorderedSquare();
        System.out.println(a.largest1BorderedSquare(new int[][]{new int[]{1,1,1},new int[]{1,0,1},new int[]{1,1,1}}));
    }
}
