package a1223;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 * <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array/?envType=study-plan&id=zijie&plan=7d_zijie&plan_progress=yg0e3md">...</a>
 */
public class ByteDance_Search {

    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0 )
            return -1;

        if(nums.length==1){
            return nums[0]==target?0:-1;
        }

        int mid = 0;
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            mid = (right+left)/2;
            //如果nums[mid]>nums[right]就证明mid在翻转区
            //left...mid 有序，mid...right可能存在低谷
            if(nums[mid]>nums[right]){
                if(target>=nums[left] && target<=nums[mid]){
                    //转为正常二分
                    return binarySearch(nums,left,mid,target);
                }
                //继续在mid...right中查找
                left = mid+1;
            }
            //如果nums[mid]<nums[left]就证明在原排序区
            else if(nums[mid]<nums[left]){
                if(target>=nums[mid]&& target<=nums[right]){
                    //转为正常二分
                    return binarySearch(nums,mid,right,target);
                }
                //继续在left...mid中查找
                right = mid-1;
            }else {
                return binarySearch(nums,left,right,target);
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if(left==right){
            return nums[left]==target?left:-1;
        }
        int mid = 0;
        int l = left;
        int r = right;
        while (l<=r){
            mid = (l+r)/2;
            if(target>nums[mid]){
                //选右边
                l = mid+1;
            }else if(target<nums[mid]){
                r = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ByteDance_Search dance_search = new ByteDance_Search();

        System.out.println(dance_search.search(new int[]{4,5,6,7,0,1,2},0));
        System.out.println(dance_search.search(new int[]{4,5,6,7,0,1,2},3));
        System.out.println(dance_search.search(new int[]{4,5,6,7,0,1,2},8));
        System.out.println(dance_search.search(new int[]{4,5,6,7,0,1,2},1));
    }
}
