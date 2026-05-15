class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length+4][3];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return helper(0,0,prices,dp);
    }
    public int helper(int idx, int purOrSell,int[] prices, int[][] dp){
        // base case
        if(idx>=prices.length){
            return 0;
        }
        if(dp[idx][purOrSell]!=-1){
            return dp[idx][purOrSell];
        }
        int max = 0;
        if(purOrSell==0){
            int buy = helper(idx+1,1,prices,dp)-prices[idx];
            int notBuy = helper(idx+1,0,prices,dp);
            max = Math.max(buy,notBuy);
        }else{
            int sell = helper(idx+2,0,prices,dp)+prices[idx];
            int notSell = helper(idx+1,1,prices,dp);
            max = Math.max(sell,notSell); 
        }
        return dp[idx][purOrSell]=max;
    }
}
