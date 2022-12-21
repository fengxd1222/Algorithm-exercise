package dp01;

/**
 * 规定1和A对应、2和B对应、3和C对应...26和Z对应，
 * 那么一个数字字符串比如"111”就可以转化为:"AAA"、"KA"和"AK"。
 * 给定一个只有数字字符组成的字符串str，请问有多少种转化结果？
 */
public class NumberConvertLetter {
    public static int convert1(String str){
        return process1(str.toCharArray(),0);
    }

    private static int process1(char[] chars, int index) {
        //顺利走到最后一个字符串，证明终止，切当前转换有效
        if(index==chars.length){
            return 1;
        }
        //如果当前字符是0，证明之前的转换无效，返回0
        if(chars[index]=='0'){
            return 0;
        }
        //转换一位
        int res = process1(chars,index+1);
        //转换2位，1开头，没有特殊情况 转换两位，2开头，有特殊情况 20-26

        if(index+1< chars.length && (chars[index]-'0')*10+(chars[index+1]-'0')<27){
            res += process1(chars,index+2);
        }
        return res;
    }

    /**
     * 可变参数的数量决定数组的维度，递归传进的初始化参数决定
     * @param str
     * @return
     */
    public static int dp(String str){
        char[] chars = str.toCharArray();
        int[] dp = new int[chars.length+1];
        dp[chars.length] = 1;

        for (int i = chars.length-1; i >= 0 ; i--) {
            if(chars[i]!= '0'){
                //转换一位
                int res = dp[i+1];
                //转换2位，1开头，没有特殊情况 转换两位，2开头，有特殊情况 20-26

                if(i+1< chars.length && (chars[i]-'0')*10+(chars[i+1]-'0')<27){
                    res += dp[i+2];
                }
                dp[i] = res;
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(convert1("2132082"));
        System.out.println(dp("2132082"));
    }
}
