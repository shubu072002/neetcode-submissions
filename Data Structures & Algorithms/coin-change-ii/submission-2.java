class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+3][amount+3];
        for(int i=0;i<dp.length;i++){
           for(int j=0;j<dp[0].length;j++){
            dp[i][j]=-1;
           }
        }
       return helper(0,amount,coins,dp); 
    }
    public int helper(int idx, int amount, int[] coins, int[][] dp){
        if(amount==0){
            return 1;
        }
        if(amount<0 || idx == coins.length){
            return 0;
        }
        if(dp[idx][amount]!=-1){
            return dp[idx][amount];
        }
        int x = helper(idx,amount-coins[idx],coins,dp);
        int y = helper(idx+1,amount,coins,dp);
        return dp[idx][amount]=x + y;
    }
}
