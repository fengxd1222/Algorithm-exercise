package a1209;

import java.util.Stack;

/**
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * <p>
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * <p>
 * https://leetcode.cn/problems/count-and-say/
 * <p>
 * 前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 * <p>
 * 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。然后对于每个组，
 * 先描述字符的数量，然后描述字符，形成一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。
 */
public class CountAndSay38 {

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        String curStr = "1";
        int curIndex = 1;
        return process(curIndex, curStr, n);
    }

    private static String process(int curIndex, String curStr, int n) {
        if (curIndex == n) {
            return curStr;
        }
        Stack<Integer> numbers = new Stack<>();
        numbers.push(-1);
        char[] chars = curStr.toCharArray();


        StringBuilder newStr = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {

            int number = chars[i] - '0';

            if (numbers.peek() == number || numbers.peek() == -1) {
                //判断栈顶元素是当前元素 继续压栈
                numbers.push(number);
            } else if (numbers.peek() != -1 && numbers.peek() != number) {
                //当前元素不是栈顶元素，且不是默认值-1，开始处理出栈
                int count = 0;
                int curNumber = numbers.peek();
                while (numbers.peek() != -1) {
                    numbers.pop();
                    count++;
                }
                newStr.append(count).append(curNumber);
                numbers.push(number);
            }
        }
        if (numbers.peek() != -1) {
            int count = 0;
            int curNumber = numbers.peek();
            while (numbers.peek() != -1) {
                numbers.pop();
                count++;
            }
            newStr.append(count).append(curNumber);
        }
        return process(curIndex + 1, newStr.toString(), n);
    }


    /**
     * 递归--优化第一版
     *
     * @param n
     * @return
     */
    public static String countAndSay2(int n) {
        String curStr = "1";
        int curIndex = 1;
        return process2(curIndex, curStr, n);
    }

    private static String process2(int curIndex, String curStr, int n) {
        if (n == 1) {
            return "1";
        }
        if (curIndex == n) {
            return curStr;
        }

        char[] chars = curStr.toCharArray();
        StringBuilder newStr = new StringBuilder();

        int left = 0;//当前第一个指针
        int right = 0;//当前第二个指针

        while (left < chars.length && right < chars.length) {
            //如果两个指针的元素不一致，那么对[left,right)范围内的数字进行处理，左闭右开
            if (chars[left] != chars[right]) {
                newStr.append(right - left).append(chars[left] - '0');
                left = right;
            } else {
                //如果两个指针元素一致，需要额外判断右指针是否已到边界
                if (right + 1 < chars.length) {
                    right++;
                } else {
                    //到达边界，直接处理并跳出循环
                    newStr.append(right - left + 1).append(chars[left] - '0');
                    break;
                }
            }
        }
        return process2(curIndex + 1, newStr.toString(), n);
    }


    public static void main(String[] args) {
        System.out.println(countAndSay(5));
        System.out.println(countAndSay2(5));
    }
}
