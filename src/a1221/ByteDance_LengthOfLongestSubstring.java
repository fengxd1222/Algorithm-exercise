package a1221;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *      <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/?envType=study-plan&id=zijie&plan=7d_zijie&plan_progress=yg0e3md">...</a>
 */
public class ByteDance_LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if(s==null){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(ByteDance_LengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(ByteDance_LengthOfLongestSubstring.lengthOfLongestSubstring("bbbbb"));
        System.out.println(ByteDance_LengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
        System.out.println(ByteDance_LengthOfLongestSubstring.lengthOfLongestSubstring("au"));
        System.out.println(ByteDance_LengthOfLongestSubstring.lengthOfLongestSubstring("abba"));
    }
}
