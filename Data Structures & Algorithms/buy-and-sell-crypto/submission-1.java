class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int curr = prices[i];
            min = Math.min(min, curr);
            int profit = curr - min;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
