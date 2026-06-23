class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int currPrice = prices[i];
            minPrice = Math.min(minPrice, currPrice);
            int profit = currPrice - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
