package a2023.a0104;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 * <a href="https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_constructArr {
    public int[] constructArr(int[] a) {
        if (a==null||a.length==0)return a;

        int length = a.length;

        //左边乘积
        int[] left = new int[length];
        left[0]=1;
        for (int i = 1; i < length; i++) {
            left[i] = left[i-1]*a[i-1];
        }

        //右边乘积
        int[] right = new int[length];
        right[length-1]=1;
        for (int i = length-2; i >=0 ; i--) {
            right[i] = right[i+1]*a[i+1];
        }

        int[] ans = new int[length];

        for (int i = 0; i < length; i++) {
            ans[i] = left[i]*right[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        char[] chars = args[0].toCharArray();
        for (char aChar : chars) {

        }
    }
}
