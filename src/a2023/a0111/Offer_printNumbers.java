package a2023.a0111;

import java.util.Arrays;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * <a href="https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_printNumbers {
    public int[] printNumbers(int n) {


        int max = (int)(Math.pow(10, n) - 1);
        int[] ans = new int[max];
        for (int i = 0; i < max; i++) {
            ans[i] = i+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Offer_printNumbers a = new Offer_printNumbers();
        System.out.println(Arrays.toString(a.printNumbers(1)));
        System.out.println(Arrays.toString(a.printNumbers(2)));
    }
}
