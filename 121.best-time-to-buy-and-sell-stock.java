/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int globalMin = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price: prices){
            if(price < globalMin){
                globalMin = price;
            }else {
                maxProfit = Math.max(maxProfit, price - globalMin);
            }
        }
        return maxProfit;
    }
}
// @lc code=end

