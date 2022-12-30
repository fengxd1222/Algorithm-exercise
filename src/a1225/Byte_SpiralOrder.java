package a1225;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * <a href="https://leetcode.cn/problems/spiral-matrix/?envType=study-plan&id=zijie&plan=7d_zijie&plan_progress=yg0e3md">...</a>
 */
public class Byte_SpiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>(matrix.length * matrix[0].length);

        int left = 0;
        int right = matrix[0].length-1;

        int top = 0;
        int bottom = matrix.length-1;

        int eleNums = matrix.length * matrix[0].length;
        while (eleNums>0){
            for (int i = left; i <= right && eleNums>=1; i++) {
                res.add(matrix[top][i]);
                eleNums--;
            }
            top++;

            for (int i = top; i <= bottom&&eleNums>=1; i++) {
                res.add(matrix[i][right]);
                eleNums--;
            }
            right--;

            for (int i = right; i >= left&&eleNums>=1; i--) {
                res.add(matrix[bottom][i]);
                eleNums--;
            }

            bottom--;

            for (int i = bottom; i >= top&&eleNums>=1; i--) {
                res.add(matrix[i][left]);
                eleNums--;
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Byte_SpiralOrder.spiralOrder(new int[][]{new int[]{1,2,3,4},new int[]{5,6,7,8},new int[]{9,10,11,12}}));
    }
}
