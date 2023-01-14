package a2023.a0111;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * <a href="https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_reversePairs {
    public int reversePairs(int[] nums) {
        //归并排序 每次对比时，当前数大于后数时，累加1
        int i = processMergeSort(nums, 0, nums.length - 1);
        return i;
    }

    private int processMergeSort(int[] nums, int left, int right) {
        if(left>=right) return 0;

        int mid = (left+right)/2;

        int res = processMergeSort(nums,left,mid)+processMergeSort(nums,mid+1,right);
        res+=merge(nums,left,mid,right);
        return res;
    }

    private int merge(int[] nums, int left, int mid, int right) {
        int[] merge = new int[right-left+1];
        int p1 = left,p2=mid+1;
        int index=0;
        int ans = 0;
        while (p1<=mid&&p2<=right){
            if(nums[p1]<=nums[p2]){
                merge[index++] = nums[p1++];
            }else {
                ans+=mid-p1+1;
                merge[index++] = nums[p2++];
            }
        }
        while (p1<=mid){
            merge[index++]=nums[p1++];
        }
        while (p2<=right){
            merge[index++] = nums[p2++];
        }

        for (int i = 0; i < merge.length; i++) {
            nums[left+i] = merge[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Offer_reversePairs a = new Offer_reversePairs();
//        System.out.println(a.reversePairs(new int[]{7,5,6,4}));
        System.out.println(a.reversePairs(new int[]{1,3,2,3,1}));
    }
}
