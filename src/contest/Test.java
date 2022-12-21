package contest;

public class Test {
    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * <p>
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     * <p>
     * 输入：s = "cbbd"
     * 输出："bb"
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        //单个元素本身是回文子串，所以有dp[x][x]=true
        dp[s.length() - 1][s.length() - 1] = true;

        int max = 1;
        int left = 0;
        int right = s.length() - 1;
        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i] = true;
            //填充次对角线
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (dp[i][i + 1]) {
                max = 2;
                left = i;
                right = i + 1;
            }
        }


        for (int j = 2; j < s.length() - 1; j++) {
            for (int i = 0; i < j-2; i++) {
                if(s.charAt(j)==s.charAt(i)){
                    dp[i][j] = dp[i+1][j-1];
                }else {
                    dp[i][j] = false;
                }
                if(dp[i][j] && j-i+1>max){
                    max = j-i+1;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left,right-1);
    }
}
