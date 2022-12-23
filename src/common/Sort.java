package common;

/**
 * 排序
 */
public class Sort {





    /**==============================================================================快排===========================================================*/
    /**
     * 快速排序三个版本
     * @param nums
     * @return
     */
    public int[] quickSort(int[] nums){
        if(nums==null||nums.length==0){
            return nums;
        }
        //普通快排
        processForQuickSort_1(nums,0,nums.length-1);
        //快排2.0 将中间数改为数组，过度掉重复的那一部分
        processForQuickSort_2(nums,0,nums.length-1);
        //快排3.0 随机快排 利用概率上的随机性，让时间复杂度在数学期望上达到O(n)
        processForQuickSort_3(nums,0,nums.length-1);
        return nums;
    }

    private void processForQuickSort_3(int[] nums, int left, int right) {
        if(left>=right)return;
        int randomMid = left+(int)(Math.random()*(right-left)/2);
        //随机值与对比值交换，得出一个概率性的结果，多次排序，最终会趋向于O(n)的时间复杂度
        swap(nums,randomMid,right);
        int[] m = partitionForArray(nums,left,right);
        processForQuickSort_2(nums,left,m[0]-1);
        processForQuickSort_2(nums,m[1]+1,right);
    }

    private void processForQuickSort_2(int[] nums, int left, int right) {
        if(left>=right)return;

        int[] m = partitionForArray(nums,left,right);
        processForQuickSort_2(nums,left,m[0]-1);
        processForQuickSort_2(nums,m[1]+1,right);
    }

    private int[] partitionForArray(int[] nums, int left, int right) {
        if(left>right){
            return new int[]{-1,-1};
        }
        if(left==right){
            return new int[]{left,right};
        }

        int less = left-1;
        int more = right;
        int index=0;
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
        return new int[]{less+1,more};
    }

    private void processForQuickSort_1(int[] nums, int left, int right) {
        if(left>=right)return;

        int m = partition(nums,left,right);
        processForQuickSort_1(nums,left,m);
        processForQuickSort_1(nums,m+1,right);
    }

    private int partition(int[] nums, int left, int right) {

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

    /**
     * ========================================================================归并===================================================================
     */

    /**
     * 归并排序
     * @param nums
     * @return
     */
    public int[] mergeSort(int[] nums){
        if(nums==null||nums.length==0){
            return nums;
        }
        processForMergeSort(nums,0,nums.length-1);
        return nums;
    }

    public void processForMergeSort(int[] nums,int left,int right){
        if(left==right)return;

        int mid = left+(right-left)/2;
        processForMergeSort(nums,left,mid);
        processForMergeSort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] merge = new int[right-left+1];
        int p1 = left;int p2 = mid+1;
        int index=0;
        while (p1<=mid&&p2<=right){
            merge[index] = nums[p1]>=nums[p2]?nums[p2++]:nums[p1++];
        }
        while (p1<=mid){
            merge[index++] = nums[p1++];
        }
        while (p2<=right){
            merge[index++] = nums[p2++];
        }
        for (int i = 0; i < merge.length; i++) {
            nums[left+i] = merge[i];
        }
    }
}
