package a2023.a0109;

import java.util.*;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 *
 */
public class Offer_permutation {
    public String[] permutation(String s) {
        if(s.length()==1)return new String[]{s};

        List<String> ans = new ArrayList<>();
        char[] chars = s.toCharArray();
        process(ans,0,chars);
        return ans.toArray(new String[0]);
    }

    private void process(List<String> ans,int i, char[] chars) {
        if(i==chars.length-1){
            ans.add(new String(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int j = i; j < chars.length; j++) {
            if(set.contains(chars[j])){
                continue;
            }
            set.add(chars[j]);
            swap(chars,j,i);
            process(ans,i+1,chars);
            swap(chars,j,i);
        }
    }

    private void swap(char[] c, int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    public static void main(String[] args) {
        Offer_permutation a = new Offer_permutation();
        System.out.println(Arrays.toString(a.permutation("abc")));
    }
}
