package a1228;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 * <a href="https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 *
 * 考察的是排序，但是需要修改排序规则
 *
 * 当 字符串 x+y>y+x 有规则 y<x 此处的小于不是数字的小于关系，而是对于拼接字符串来说，哪个数字在前更小
 * 反之     x+y<y+x 有y>x
 *
 */
public class Offer_MinNumber {
    public String minNumber(int[] nums) {
        if(nums==null||nums.length==0)return null;
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs,0,nums.length-1);
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str);
        }
        return builder.toString();
    }

    private void quickSort(String[] nums, int left, int right) {
        if(left>=right)return;
        int randomMid = left+(int)(Math.random()*(right-left)/2);
        //随机值与对比值交换，得出一个概率性的结果，多次排序，最终会趋向于O(n)的时间复杂度
        swap(nums,randomMid,right);
        int m = partition(nums,left,right);
        quickSort(nums,left,m);
        quickSort(nums,m+1,right);
    }

    private int partition(String[] nums, int left, int right) {
        int less = left-1;
        int more = right;
        int index=left;
        while (index<more){
            if(nums[index].equals(nums[right])){
                index++;
            }else if((nums[index]+nums[right]).compareTo(nums[right]+nums[index])<0){
                swap(nums,++less,index++);
            }else {
                swap(nums,index,--more);
            }
        }
        swap(nums,more,right);
        return less+1;
    }

    private void swap(String[] nums, int i, int j) {
        String temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(("30"+"3").compareTo("3"+"30"));
        System.out.println(("3"+"30").compareTo("30"+"3"));

        Offer_MinNumber offer_minNumber = new Offer_MinNumber();
        System.out.println(offer_minNumber.minNumber(new int[]{3,30,34,5,9}));
    }
}
