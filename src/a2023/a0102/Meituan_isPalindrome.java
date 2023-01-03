package a2023.a0102;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 *
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * <a href="https://leetcode.cn/company/mock-interview/0/">...</a>
 */
public class Meituan_isPalindrome {
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        String s = String.valueOf(x);
        return process(s,0,s.length()-1);
    }

    private boolean process(String s, int left, int right) {
        if(left==right)return true;

        return s.charAt(left)==s.charAt(right)&&process(s,left+1,right-1);
    }

    public static void main(String[] args) {
        Meituan_isPalindrome a = new Meituan_isPalindrome();
        System.out.println(a.isPalindrome(121));
        System.out.println(a.isPalindrome(12123));
        System.out.println(a.isPalindrome(12121));
    }
}
