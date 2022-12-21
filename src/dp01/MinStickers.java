package dp01;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 我们有 n 种不同的贴纸。每个贴纸上都有一个小写的英文单词。
 *
 * 您想要拼写出给定的字符串 target ，方法是从收集的贴纸中切割单个字母并重新排列它们。如果你愿意，你可以多次使用每个贴纸，每个贴纸的数量是无限的。
 *
 * 返回你需要拼出 target 的最小贴纸数量。如果任务不可能，则返回 -1 。
 * https://leetcode.cn/problems/stickers-to-spell-word
 */
public class MinStickers {

    public static int minStickers1(String[] stickers, String target) {
        int res = process1(stickers, target);
        return res ==Integer.MAX_VALUE?-1:res;
    }

    /**
     * ["abc","bb","cd"] -> target=aabd
     * @param stickers
     * @param target
     * @return
     */
    private static int process1(String[] stickers, String target) {
        //如果target长度为0，证明已经处理完，返回0
        if(target.length()==0){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (String sticker : stickers) {
            //去除target中存在sticker中的字符
            String targetAfterDeal = deal(sticker,target);
            if(target.length()!=targetAfterDeal.length()){
                res = Math.min(res,process1(stickers,targetAfterDeal));
            }
        }
        return res + (res==Integer.MAX_VALUE?0:1);
    }

    private static String deal(String sticker, String target) {
        char[] stickerChars = sticker.toCharArray();
        char[] targetChars = target.toCharArray();
        int[] count = new int[26];
        for (char targetChar : targetChars) {
            count[targetChar-'a']++;
        }
        for (char stickerChar : stickerChars) {
            count[stickerChar-'a']--;
        }
        StringBuilder newTarget = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if(count[i]>0){
                for (int j = 0; j < count[i]; j++) {
                    newTarget.append((char) (i+'a'));
                }
            }
        }
        return newTarget.toString();
    }


    /**
     * 第二种方法，优化数组，将贴纸按照字母出现的频率替换成词频数组
     * @param stickers
     * @param target
     * @return
     */
    public static int minStickers2(String[] stickers, String target) {
        int[][] newStickers = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            String sticker = stickers[i];
            char[] chars = sticker.toCharArray();
            for (char aChar : chars) {
                newStickers[i][aChar-'a']++;
            }
        }
        int res = process2(newStickers, target);
        return res ==Integer.MAX_VALUE?-1:res;
    }

    private static int process2(int[][] newStickers, String target) {
        if(target.length()==0){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        char[] chars = target.toCharArray();
        int[] targetCount = new int[26];
        for (char aChar : chars) {
            targetCount[aChar-'a']++;
        }

        for (int[] newSticker : newStickers) {
            if(newSticker[chars[0]-'a']>0){
                StringBuilder newTarget = new StringBuilder();
                for (int i = 0; i < targetCount.length; i++) {
                    if(targetCount[i]>0){
                        //大于0，证明当前位置的字母有出现
                        int count = targetCount[i] - newSticker[i];
                        for (int j = 0; j < count; j++) {
                            newTarget.append((char)(i+'a'));
                        }
                    }
                }
                res = Math.min(res,process2(newStickers, newTarget.toString()));
            }
        }
        return res + (res==Integer.MAX_VALUE?0:1);
    }


    /**
     * 第三种方法，在第二种的基础上，增加缓存
     * @param stickers
     * @param target
     * @return
     */
    public static int minStickers3(String[] stickers, String target) {
        int[][] newStickers = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            String sticker = stickers[i];
            char[] chars = sticker.toCharArray();
            for (char aChar : chars) {
                newStickers[i][aChar-'a']++;
            }
        }
        Map<String ,Integer> cache = new HashMap<>();
        int res = process3(newStickers, target,cache);
        return res ==Integer.MAX_VALUE?-1:res;
    }

    private static int process3(int[][] newStickers, String target, Map<String, Integer> cache) {
        if(cache.containsKey(target)){
            return cache.get(target);
        }
        if(target.length()==0){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        char[] chars = target.toCharArray();
        int[] targetCount = new int[26];
        for (char aChar : chars) {
            targetCount[aChar-'a']++;
        }

        for (int[] newSticker : newStickers) {
            if(newSticker[chars[0]-'a']>0){
                StringBuilder newTarget = new StringBuilder();
                for (int i = 0; i < targetCount.length; i++) {
                    if(targetCount[i]>0){
                        //大于0，证明当前位置的字母有出现
                        int count = targetCount[i] - newSticker[i];
                        for (int j = 0; j < count; j++) {
                            newTarget.append((char)(i+'a'));
                        }
                    }
                }
                String newTargetStr = newTarget.toString();
                res = Math.min(res,process3(newStickers, newTargetStr,cache));
            }
        }
        res += (res==Integer.MAX_VALUE?0:1);
        cache.put(target,res);
        return res;
    }

    public static int minStickers(String[] stickers, String target) {
        int n = target.length();
        int[] f = new int[1<<n];
        Deque<Integer> d = new ArrayDeque<>();
        d.addLast(0);
        while(!d.isEmpty()){
            int poll = d.pollFirst();
            for(String s:stickers){
                int state = poll;
                int[] cnt = new int[26];
                for(char c:s.toCharArray()){
                    cnt[c-'a']++;
                }
                for(int i = 0;i<n;i++){
                    if(cnt[target.charAt(i) - 'a']>0 &&((state>>i)&1) == 0){
                        state |= 1<<i;
                        cnt[target.charAt(i) - 'a']--;
                    }
                }
                if(f[state] != 0|| state == 0) continue;
                d.addLast(state);
                f[state] = f[poll] + 1;
                if(state == (1<<n)-1) return f[state];
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String[] strickers = {"dad","rose","pay","else","condition","were","east","nor"};
        System.out.println(minStickers1(strickers,"easesoldier"));
        System.out.println(minStickers2(strickers,"easesoldier"));
        System.out.println(minStickers3(strickers,"easesoldier"));
        System.out.println(minStickers(strickers,"easesoldier"));
    }
}
