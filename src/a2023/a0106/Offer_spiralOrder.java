package a2023.a0106;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * <a href="https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_spiralOrder {
    public int[] spiralOrder(int[][] matrix) {

        if(matrix==null || matrix.length==0 ||matrix[0]==null||matrix[0].length==0){
            return new int[0];
        }


        int[] res = new int[matrix.length*matrix[0].length];
        int curIndex=0;

        //left right  top bottom
        int left = 0,top=0,right=matrix[0].length-1,bottom = matrix.length-1;
        int eleCounts = matrix.length*matrix[0].length;
        while (eleCounts>0){
            for (int i = left; i <= right && eleCounts>=1; i++) {
                res[curIndex++] = matrix[top][i];
                eleCounts--;
            }
            top++;
            for (int i = top; i <=bottom && eleCounts>=1 ; i++) {
                res[curIndex++] =matrix[i][right];
                eleCounts--;
            }
            right--;
            for (int i = right; i >=left && eleCounts>=1; i--) {
                res[curIndex++] =matrix[bottom][i];
                eleCounts--;
            }
            bottom--;

            for (int i = bottom; i >=top && eleCounts>=1 ; i--) {
                res[curIndex++] =matrix[i][left];
                eleCounts--;
            }
            left++;
        }
        return res;
    }


}
