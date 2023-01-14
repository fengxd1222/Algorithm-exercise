package a2023.a0112;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：6
 * <a href="https://leetcode.cn/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_countDigitOne {
    /**
     * 0-9      1次
     * 10-19    1+10次
     * 20-29    1次
     * 30-39    1次
     * ...
     * 100-109  1+10次
     * 110-119  1+10+10次 110 2  111 3  112 2  113 2 114 2 115 2 116 2 117 2 118 2 119 2
     *
     * 设某个数字 个位数前面有N个1，sum = （个位数是否是1）+ 10*N
     * 如果个位数前面有一个1，就*10，有n个1 就*n
     *  也就是说，现在要求个位数是什么，同时十位数及以上有几个1
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int ans = 0;
        long base = 1;
        while(base <= n){
            int a =  (int)(n / base);
            int b = (int)(n % base);
            int cur = a % 10;
            a = a /10;
            if(cur > 1){
                ans += ((a + 1) * base);
            }else if(cur == 1){
                ans += (a*base + b + 1);
            }else {
                ans += a*base;
            }
            base *= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(231%10);
//        System.out.println(231/10);
//        System.out.println(23%10);
//        System.out.println(1%10);
//        System.out.println(1/10);

        Offer_countDigitOne a = new Offer_countDigitOne();

        System.out.println(a.countDigitOne(9));
        System.out.println(a.countDigitOne(19));
        System.out.println(a.countDigitOne(12));
        System.out.println(a.countDigitOne(13));
        System.out.println(a.countDigitOne(110));
    }
}
