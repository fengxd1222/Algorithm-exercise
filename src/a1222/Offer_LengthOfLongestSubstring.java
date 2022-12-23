package a1222;

import a1221.ByteDance_LengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *      <a href="https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;

        char[] chars = s.toCharArray();
        for (int left = 0,right=0; right < chars.length; right++) {
            char aChar = chars[right];
            if(map.containsKey(aChar)){
                left = Math.max(map.get(aChar)+1,left);
            }
            max = Math.max(max,right-left+1);
            map.put(aChar,right);
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(Offer_LengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(Offer_LengthOfLongestSubstring.lengthOfLongestSubstring("bbbbb"));
        System.out.println(Offer_LengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
        System.out.println(Offer_LengthOfLongestSubstring.lengthOfLongestSubstring("au"));
        System.out.println(Offer_LengthOfLongestSubstring.lengthOfLongestSubstring("abba"));
        System.out.println(Offer_LengthOfLongestSubstring.lengthOfLongestSubstring("tmmzuxt"));
    }
}
