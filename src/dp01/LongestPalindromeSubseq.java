package dp01;

/**
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 *
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 */
public class LongestPalindromeSubseq {
    /**
     * 样本对应模型
     * @param s
     * @return
     */
    public static int longestPalindromeSubseq1(String s) {
        char[] charsA = s.toCharArray();
        char[] charsB = new StringBuilder(s).reverse().toString().toCharArray();

        int n = charsA.length;
        int m = charsB.length;
        int[][] dp = new int[n][m];

        dp[0][0] = charsA[0]==charsB[0]?1:0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = charsA[i]==charsB[0]?1:dp[i-1][0];
        }

        for (int j = 1; j < m; j++) {
            dp[0][j] = charsA[0]==charsB[j]?1:dp[0][j-1];
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

    /**
     * 范围模型
     * @param s
     * @return
     */
    public static int longestPalindromeSubseq2(String s) {
        char[] chars = s.toCharArray();
        return process2(chars,0,chars.length-1);
    }

    private static int process2(char[] chars, int i, int j) {
        if(i==j){
           return 1;
        }
        if(i==j-1){
            return chars[i]==chars[j]?2:1;
        }
        int p1 = process2(chars,i+1,j-1);
        int p2 = process2(chars,i,j-1);
        int p3 = process2(chars,i+1,j);
        int p4 = chars[i]==chars[j]?2+p1:0;
        return Math.max(Math.max(p1,p4),Math.max(p2,p3));
    }

    /**
     * 最长回文子串 范围模型 - 优化动态规划
     * @param s
     * @return
     */
    public static int longestPalindromeSubseq3(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[][] dp = new int[n][n];
        //先约束边界 dp[L][R]
        dp[n-1][n-1] = 1;
        //约束的下边界，那就从上边界开始，直至下边界的前一位
        //此处初始化对角线以及倒数第二的对角线，因为是范围模型，不可能存在对角线左下方的情况
        for (int i = 0; i < n-1; i++) {
            dp[i][i]=1;
            dp[i][i+1] = chars[i]==chars[i+1]?2:1;
        }
        //下面是dp矩阵，首先对角线以及#对应的值都已经在上面的循环赋值了，所以求值需要设置的L的边界是&符号所在的位置，
        //同时根据矩阵可知，对于R来说，%符号所在的位置是没有值的开始位置，所以R的开始位置是L+2，最大值是n
//          0  1  2  3  4  5  6  R
//        0 1  #  %
//        1    1  #
//        2       1  #
//        3          1  #
//        4             1  #  &
//        5                1  #
//        6                  1
//        L
        for (int i = 0; i < n - 3; i++) {
            for (int j = i+2; j < n; j++) {
                //将原本的递归，转换为动态规划
//                int p1 = process(chars,i+1,j-1);
                int p1 = dp[i+1][j-1];
//                int p2 = process(chars,i,j-1);
                int p2 = dp[i][j-1];
//                int p3 = process(chars,i+1,j);
                int p3 = dp[i+1][j];
//                int p4 = chars[i]==chars[j]?2+p1:0;
                int p4 = chars[i]==chars[j]?2+p1:0;
                //当前要求的值是dp[i][j]
                dp[i][j] = Math.max(Math.max(p1,p4),Math.max(p2,p3));
            }
        }
        return dp[0][n-1];
    }



    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq1("bbbab"));
        System.out.println(longestPalindromeSubseq1("cbbd"));

        System.out.println(longestPalindromeSubseq2("bbbab"));
        System.out.println(longestPalindromeSubseq2("cbbd"));
    }
}
