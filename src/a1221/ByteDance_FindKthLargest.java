package a1221;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 * <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/?envType=study-plan&id=zijie&plan=7d_zijie&plan_progress=yg0e3md">...</a>
 *
 */
public class ByteDance_FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null|| nums.length==0 || k>nums.length){
            return 0;
        }
        process(nums,0,nums.length-1);
        return nums[nums.length-k];
    }

    /**
     * 快速排序
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        if(nums==null|| nums.length==0 || k>nums.length){
            return 0;
        }

        int target = nums.length - k;
        int left=0;
        int right=nums.length-1;

        while (true){
            int partIndex = partition(nums,left,right);
            if(partIndex==target){
                return nums[target];
            }else if(partIndex>target){
                right = partIndex-1;
            }else {
                left = partIndex+1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = (int)(Math.random()*(right-left+1))+left;
        swap(nums,randomIndex,right);

        int less = left-1;
        int more = right;
        int index = left;

        while (index<more){
            if(nums[index]==nums[right]){
                index++;
            }else if(nums[index]<nums[right]){
                less++;
                swap(nums,index,less);
                index++;
            }else {
                more--;
                swap(nums,index,more);
            }
        }
        swap(nums,more,right);
        return less+1;
    }


    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }



    //归并排序
    private void process(int[] nums, int L,  int R) {
        if(L==R){
            return;
        }
        int mid = L+(R-L)/2;
        process(nums,L,mid);
        process(nums,mid+1,R);
        merge(nums,L,mid,R);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] temp = new int[r-l+1];
        int index=0;
        int p1=l;
        int p2=mid+1;

        while (p1<=mid && p2<=r){
            temp[index++] = nums[p1]>=nums[p2]?nums[p2++] : nums[p1++];
        }

        while (p1<=mid){
            temp[index++] = nums[p1++];
        }

        while(p2<=r){
            temp[index++] = nums[p2++];
        }
        for (int i = 0; i <temp.length; i++) {
            nums[l+i] = temp[i];
        }
    }

    public void test(int i,int j){
        System.out.println(i);
        System.out.println(j);
    }

    public static void main(String[] args) {
        ByteDance_FindKthLargest a = new ByteDance_FindKthLargest();
        System.out.println(a.findKthLargest(new int[]{3,2,1,5,6,4},2));
        System.out.println(a.findKthLargest1(new int[]{3,2,1,5,6,4},2));
        System.out.println(a.findKthLargest1(new int[]{3,2,3,1,2,4,5,5,6},4));
        System.out.println(a.findKthLargest1(new int[]{2,1},1));


    }

    //归并排序




}
