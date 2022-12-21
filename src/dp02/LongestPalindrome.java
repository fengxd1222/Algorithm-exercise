package dp02;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * <a href="https://leetcode.cn/problems/longest-palindromic-substring/description/">...</a>
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {

        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        int maxLen = 1;
        int left = 0;
        int right = 0;

        dp[length-1][length-1] = true;
        for (int i = 0; i < length-1; i++) {
            dp[i][i] = true;
            dp[i][i+1] = s.charAt(i)==s.charAt(i+1);
            if(dp[i][i+1]){
                maxLen = 2;
                left = i;
                right = i+1;
            }
        }


        for (int j = 2; j < length; j++) {
            for (int i = 0; i <= j-2; i++) {
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }else {
                    dp[i][j] = false;
                }
                if(dp[i][j] && j-i+1>maxLen){
                    maxLen = j-i+1;
                    left = i;
                    right = j;
                }
            }
        }

        return s.substring(left,right+1);
    }

    public static String longestPalindrome2(String s) {

        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        int maxLen = 1;
        int left = 0;
        int right = 0;

        dp[length-1][length-1] = true;
        for (int i = 0; i < length-1; i++) {
            dp[i][i] = true;
        }


        for (int j = 1; j < length; j++) {
            for (int i = 0; i <= j-1; i++) {
                if(s.charAt(i)==s.charAt(j)){
                    if(i==j-1){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else {
                    dp[i][j] = false;
                }
                if(dp[i][j] && j-i+1>maxLen){
                    maxLen = j-i+1;
                    left = i;
                    right = j;
                }
            }
        }

        return s.substring(left,right+1);
    }


    public static void main(String[] args) {
        //System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("aacabdkacaa"));
        System.out.println(longestPalindrome("bbcbf"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("aaaa"));
    }
}
