package a1217;

/**
 * 傻屌题，题干都描述不清，旋转一次还是N次
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
 *
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * <a href="https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_MinArray_Point {
    public int minArray(int[] numbers) {
        //二分
        int leftIndex = 0;
        int rightIndex = numbers.length-1;
        int midIndex = 0;
        while (leftIndex<rightIndex){
            midIndex = (leftIndex+rightIndex)/2;
            //在右边，左边界变为中间界限
            if(numbers[midIndex]>numbers[rightIndex]){
                leftIndex = midIndex+1;
            }else if(numbers[midIndex]<numbers[rightIndex]){
                rightIndex = midIndex;
            } else {
                rightIndex--;
            }
        }
        return numbers[leftIndex];
    }

    public char firstUniqChar(String s) {
        if(s==null||s.length()==0){
            return  ' ';
        }
        int[] count = new int[26];
        char[] chars = s.toCharArray();

        for (char aChar : chars) {
            count[aChar-'a']++;
        }

        for (char aChar : chars) {
            if(count[aChar-'a']==1){
                return aChar;
            }
        }
        return ' ';
    }
}
