package a2023.a0101;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * <a href="https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_myPow {
    public double myPow(double x, int n) {


        double res = 1;
        double temp = x;
        //int 范围问题，后续需要用tempN = -tempN取反数，这是因为int的补码问题
        long tempN = n;
        if(tempN<0){
            tempN = -tempN;
            temp = 1/x;
        }

        while (tempN!=0){
            if((tempN&1)!=0){
                res *= temp;
            }
            temp *= temp;
            tempN>>=1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(10%2);
        System.out.println(10/2);
        System.out.println(2<<5);
    }
}
