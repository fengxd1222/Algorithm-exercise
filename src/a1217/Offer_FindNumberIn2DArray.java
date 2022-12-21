package a1217;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右 非递减 的顺序排序，
 * 每一列都按照从上到下 非递减 的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <a href="https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix==null ||matrix.length==0 || matrix[0].length==0){
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            int[] matrixGroup = matrix[i];
            if(matrixGroup[0]<=target && matrixGroup[matrixGroup.length-1]>=target){
                //二分
                int leftIndex = 0;
                int rightIndex = matrixGroup.length-1;
                int midIndex = 0;
                while (leftIndex<=rightIndex){
                    midIndex = (leftIndex+rightIndex)/2;
                    //在右边，左边界变为中间界限
                    if(matrixGroup[midIndex]<target){
                        leftIndex = midIndex+1;
                    }else if(matrixGroup[midIndex]>target){
                        rightIndex = midIndex-1;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
