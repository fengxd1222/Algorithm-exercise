package a1225;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 *
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * <a href="https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_ReverseWords {

    public static String reverseWords(String s) {
        String[] strArr = s.trim().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = strArr.length-1; i>0; i--) {
            if(strArr[i].equals(""))continue;
            builder.append(strArr[i]).append(" ");
        }
        builder.append(strArr[0]);
        return builder.toString();
    }

    public static String reverseWords1(String s) {
        s = s.trim();
        StringBuilder builder = new StringBuilder();
        int left = s.length()-1,right = s.length()-1;
        while (left>=0){
            while (left>=0 && s.charAt(left)!=' ')left--;
            builder.append(s.substring(left+1,right+1)+" ");
            while (left>=0&& s.charAt(left)==' ')left--;
            right = left;
        }
        return builder.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(Offer_ReverseWords.reverseWords("a good   example"));
        System.out.println(Offer_ReverseWords.reverseWords1("a good   example"));
    }
}
