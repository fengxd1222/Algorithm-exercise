package a1225;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * <a href="https://leetcode.cn/problems/longest-palindromic-substring/?envType=study-plan&id=zijie&plan=7d_zijie&plan_progress=yg0e3md">...</a>
 */
public class Byte_LongestPalindrome {
    public String longestPalindrome(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[s.length()-1][s.length()-1] = true;

        int max = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length()-1; i++) {
            dp[i][i] = true;
            dp[i][i+1] = s.charAt(i)==s.charAt(i+1);
            if(dp[i][i+1]){
                max = 2;
                left = i;
                right = i+1;
            }
        }

        for (int i = 2; i < s.length(); i++) {
            for (int j = 0; j <= i-2; j++) {
                if(s.charAt(i)==s.charAt(j)){
                    dp[j][i] = dp[j+1][i-1];
                }else {
                    dp[j][i] = false;
                }

                if(dp[j][i] && max < i-j+1){
                    max = i-j+1;
                    left = j;
                    right = i;
                }
            }
        }
        return s.substring(left,right+1);
    }
}
