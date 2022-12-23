package a1222;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <a href="https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_TranslateNum {
    public static int translateNum(int num) {
        if(num<10){
            return 1;
        }
        if(num<=25){
            return 2;
        }
        String s = String.valueOf(num);
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            String substring = s.substring(i - 1, i + 1);
            if(substring.compareTo("10")>=0 && substring.compareTo("25")<=0){
                dp[i+1] = dp[i]+dp[i-1];
            }else {
                dp[i+1] = dp[i];
            }
        }
        return dp[s.length()];
    }

    public static int translateNum1(int num){
        if(num<10){
            return 1;
        }
        if(num<=25){
            return 2;
        }
        String s = String.valueOf(num);
        //a对应的0 b对应的1 当i=2时
        int a = 1,b=1;
        for (int i = 1; i < s.length(); i++) {
            String substring = s.substring(i - 1, i + 1);
            if(substring.compareTo("10")>=0 && substring.compareTo("25")<=0){
                int temp = a+b;
                a = b;
                b = temp;
            }else {
                a = b;
            }
        }
        return b;
    }


    public static void main(String[] args) {
        System.out.println(Offer_TranslateNum.translateNum(12258));
        System.out.println(Offer_TranslateNum.translateNum(542));

        System.out.println(Offer_TranslateNum.translateNum1(12258));
        System.out.println(Offer_TranslateNum.translateNum1(542));
    }

}
