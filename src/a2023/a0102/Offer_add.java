package a2023.a0102;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 *
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 * <a href="https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_add {
    public static int add(int a, int b) {
        int carry = (a&b)<<1;
        int sum = a^b;
        while (carry!=0){
            carry = (a&b)<<1;
            sum = a^b;
            a = sum;
            b = carry;
        }
        return sum;
    }

    public static void main(String[] args) {
//        System.out.println(Offer_add.add(3, 4));
    }
}
