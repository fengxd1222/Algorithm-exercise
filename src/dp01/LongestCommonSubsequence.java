package dp01;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列
 * https://leetcode.cn/problems/longest-common-subsequence/
 * 动态规划中 样本模型
 */
public class LongestCommonSubsequence {
    public static int longestCommonSubsequence1(String text1, String text2) {
        return process1(text1.toCharArray(),text2.toCharArray(),text1.length()-1,text2.length()-1);
    }

    private static int process1(char[] charsA, char[] charsB, int i, int j) {
        //首先i==0 j==0
        if(i==0 && j==0){
            return charsA[i]==charsB[j]?1:0;
        }else if(i==0){
            if(charsA[i] == charsB[j]){
                return 1;
            }else {
                return process1(charsA,charsB,i,j-1);
            }
            //j==0
        }else if(j==0){
            if(charsA[i] == charsB[j]){
                return 1;
            }else {
                return process1(charsA,charsB,i-1,j);
            }
        }else {
            int p1 = process1(charsA,charsB,i,j-1);
            int p2 = process1(charsA,charsB,i-1,j);
            int p3 = charsA[i]==charsB[j]?(1+process1(charsA,charsB,i-1,j-1)):0;
            return Math.max(p1,Math.max(p2,p3));
        }

    }

    public static int longestCommonSubsequence2(String text1, String text2) {
        char[] charsA = text1.toCharArray();
        char[] charsB = text2.toCharArray();
        int n = charsA.length;
        int m = charsB.length;
        int[][] dp = new int[n][m];
        dp[0][0] = charsA[0]==charsB[0]?1:0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = charsA[i] == charsB[0]?1:dp[i-1][0];
        }

        for (int j = 1; j < m; j++) {
            dp[0][j] = charsA[0] == charsB[j]?1:dp[0][j-1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int p1 = dp[i][j-1];
                int p2 = dp[i-1][j];
                int p3 = charsA[i]==charsB[j]?(1+dp[i-1][j-1]):0;
                dp[i][j] = Math.max(p1,Math.max(p2,p3));
            }
        }
        return dp[n-1][m-1];
    }
    

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence1("abcde","ace"));
        System.out.println(longestCommonSubsequence2("abcde","ace"));
    }
}
