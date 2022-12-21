package a1220;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <a href="https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=yli43e5">...</a>
 *
 */
public class Offer_MaxProfit {
    public static int maxProfit(int[] prices) {
        if(prices==null || prices.length==0){
            return 0;
        }
        return Math.max(0,process(prices,0,0));
    }

    /**
     *
     * @param prices
     * @param buy 买入的价格对应的下角标
     * @param sell 卖出的价格对应的下角标
     * @return
     */
    private static int process(int[] prices, int buy, int sell) {
        if(buy>=prices.length || sell>=prices.length){
            return 0;
        }
        if(sell>=buy){
            return Math.max(Math.max(prices[sell]-prices[buy],process(prices,buy+1,sell)),process(prices,buy,sell+1));
        }
        return 0;
    }


    public static int maxProfit1(int[] prices) {
        if(prices==null || prices.length==0){
            return 0;
        }
        int cost = Integer.MAX_VALUE,profit=0;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            cost = Math.min(cost,price);
            profit = Math.max(profit,price-cost);
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(Offer_MaxProfit.maxProfit(new int[]{7,6,4,3,1}));
    }
}
