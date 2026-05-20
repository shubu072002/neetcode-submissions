class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int curr = prices[i];
            minValue = Math.min(minValue,curr);
            int profit = curr-minValue;
            maxProfit = Math.max(maxProfit,profit);
        }
        return maxProfit;
    }
}
