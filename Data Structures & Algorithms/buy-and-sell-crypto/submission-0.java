class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            int curPrice = prices[i];
            minPrice = Math.min(minPrice, curPrice);
            int profit = curPrice - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
