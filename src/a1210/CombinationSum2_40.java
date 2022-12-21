package a1210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 */
public class CombinationSum2_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        Arrays.sort(candidates);

        process(list,candidates,0,target,stack);
        return list;
    }

    private boolean process(List<List<Integer>> list, int[] candidates, int index,  int target, Stack<Integer> stack) {
        if(target<0){
            return false;
        }
        if(target==0){
            list.add(new ArrayList<>(stack));
            return true;
        }

        for (int i = index; i < candidates.length; i++) {
                if(target - candidates[i]<0){
                    return false;
                }
                if(i>index && candidates[i]==candidates[i-1]){
                    continue;
                }
                stack.push(candidates[i]);
                process(list, candidates, i+1,  target - candidates[i], stack);
                stack.pop();
        }
        return true;
    }

    public static void main(String[] args) {
        // candidates = [10,1,2,7,6,1,5], target = 8
        CombinationSum2_40 c = new CombinationSum2_40();
        System.out.println(c.combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }
}
