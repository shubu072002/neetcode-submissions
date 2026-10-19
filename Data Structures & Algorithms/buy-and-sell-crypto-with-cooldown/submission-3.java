class Solution {
    int n;
    int[][] dp;
    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new int[n+3][2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return helper(0,1,prices);
    }
    public int helper(int idx, int buyOrSell, int[] prices){
        if(idx>=n){
            return 0;
        }
        if(dp[idx][buyOrSell]!=-1){
            return dp[idx][buyOrSell];
        }
        int max = 0;
        if(buyOrSell==1){
            int notbuy = helper(idx+1,1,prices);
            int buy = helper(idx+1,0,prices)-prices[idx];
            max = Math.max(notbuy, buy);
        }
        else{
            int notsell = helper(idx+1,0,prices);
            int sell = helper(idx+2, 1, prices)+prices[idx];
            max = Math.max(notsell, sell);
        }
        return dp[idx][buyOrSell] = max;
    }
}
