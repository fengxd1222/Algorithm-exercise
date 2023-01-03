package a2023.a0101;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * <a href="https://leetcode.cn/problems/qiu-12n-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 */
public class Offer_sumNums {
    public int sumNums(int n) {
        boolean x = n>1 && (n+=sumNums(n-1))>0;
        return n;
    }
}

