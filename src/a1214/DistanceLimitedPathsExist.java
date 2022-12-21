package a1214;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个 n 个点组成的无向图边集 edgeList ，其中 edgeList[i] = [ui, vi, disi] 表示点 ui 和点 vi 之间有一条长度为 disi 的边。请注意，两个点之间可能有 超过一条边 。
 *
 * 给你一个查询数组queries ，其中 queries[j] = [pj, qj, limitj] ，你的任务是对于每个查询 queries[j] ，判断是否存在从 pj 到 qj 的路径，且这条路径上的每一条边都 严格小于 limitj 。
 *
 * 请你返回一个 布尔数组 answer ，其中 answer.length == queries.length ，当 queries[j] 的查询结果为 true 时， answer 第 j 个值为 true ，否则为 false 。
 *
 * 输入：n = 3, edgeList = [[0,1,2],[1,2,4],[2,0,8],[1,0,16]], queries = [[0,1,2],[0,2,5]]
 *  输出：[false,true]
 *  解释：上图为给定的输入数据。注意到 0 和 1 之间有两条重边，分别为 2 和 16 。
 *  对于第一个查询，0 和 1 之间没有小于 2 的边，所以我们返回 false 。
 *  对于第二个查询，有一条路径（0 -> 1 -> 2）两条边都小于 5 ，所以这个查询我们返回 true 。
 */

public class DistanceLimitedPathsExist {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Map<Integer,Map<Integer,Integer>> dict = new HashMap<>(n);

        for (int i = 0; i < edgeList.length; i++) {
            int[] ints = edgeList[i];
            Map<Integer,Integer> targetAndDistance = new HashMap<>();
            targetAndDistance.put(ints[1],ints[2]);
            if(dict.containsKey(ints[0])){
                targetAndDistance.putAll(dict.get(ints[0]));
            }
            dict.put(ints[0],targetAndDistance);
        }
        boolean[] res = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];
            int limit = query[2];
            if(!(dict.containsKey(start) && dict.get(start).containsKey(end) && dict.get(start).get(end)<limit) &&
                !(dict.containsKey(end) && dict.get(end).containsKey(start) && dict.get(end).get(start)<limit)){
//                res[i] = false;
                continue;
            }
            res[i] = true;
        }
        return res;
    }

    public static void main(String[] args) {
        DistanceLimitedPathsExist dis = new DistanceLimitedPathsExist();

        int[] ints1 = {0, 1, 2};
        int[] ints2 = new int[]{1,2,4};
        int[] ints3 = new int[]{2,0,8};
        int[] ints4 = new int[]{1,0,16};
        int[][] ints = new int[][]{ints1,ints2,ints3,ints4};
        // [[0,1,2],[0,2,5]]
        int[] a = new int[]{0,1,2};
        int[] b = new int[]{0,2,5};
        boolean[] booleans = dis.distanceLimitedPathsExist(3, ints, new int[][]{a, b});
        System.out.println(booleans);

    }
}
