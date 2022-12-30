package a1229;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 *
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 *
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 *
 * <a href="https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_MedianFinder {

    List<Integer> arr = new ArrayList<>();
    public Offer_MedianFinder() {
    }

    public void addNum(int num) {
        if(arr.size()==0){
            arr.add(num);
        }else {
            int index = searchIndex(num);
            if(index==-1){
                arr.add(num);
                return;
            }
            arr.add(index,num);
        }
    }

    private int searchIndex(int num) {

        int left = 0;
        int right = arr.size()-1;
        while (left<right){
            int mid = left+(right-left)/2;
            Integer midNum = arr.get(mid);
            if(num== midNum){
                return mid;
            }else if(num> midNum){
                left = mid+1;
            }else {
                right = mid;
            }
        }

        for (int i = left; i <= right; i++) {
            Integer integer = arr.get(i);
            if (num<integer) {
                return i;
            }
        }

        return -1;
    }

    public double findMedian() {
        if((arr.size()&1)==1){
            return arr.get(arr.size()/2);
        }
        int size = arr.size();
        int left = size/2-1;
        int right = size/2;
        return (double) (arr.get(left) + arr.get(right)) /2;
    }

    public static void main(String[] args) {
        System.out.println(3/2);
    }
}
