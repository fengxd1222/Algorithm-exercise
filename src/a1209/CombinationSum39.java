package a1209;

import java.util.*;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 */
public class CombinationSum39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(candidates);
        process(list,candidates,0,target,stack);
        return list;
    }

    /**
     * @param list
     * @param candidates
     * @param index
     * @param target
     * @param stack
     * @return
     */
    private void process(List<List<Integer>> list, int[] candidates, int index, int target, Stack<Integer> stack) {
        if(target==0){
            list.add(new ArrayList<>(stack));
        }
        if(target<0){
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if(target-candidates[i]<0){
                break;
            }
            stack.push(candidates[i]);
            process(list,candidates,i,target-candidates[i],stack);
            stack.pop();
        }
    }

    public static void main(String[] args) {

    }
}
