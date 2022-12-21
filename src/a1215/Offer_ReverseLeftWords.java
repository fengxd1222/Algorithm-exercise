package a1215;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5
 */
public class Offer_ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        if(s==null || n>s.length()){
            return null;
        }

        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        //0~n-1放在后面 n~length放到前面
        int leftIndex = 0;
        int rightIndex = n;

        while (true){
            if(rightIndex<s.length()){
                stringBuilder.append(chars[rightIndex]);
                rightIndex++;
            }else {
                if(leftIndex<n){
                    stringBuilder.append(chars[leftIndex]);
                    leftIndex++;
                }else {
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Offer_ReverseLeftWords reverseLeftWords = new Offer_ReverseLeftWords();
        System.out.println(reverseLeftWords.reverseLeftWords("abcdefg",2));
    }
}
