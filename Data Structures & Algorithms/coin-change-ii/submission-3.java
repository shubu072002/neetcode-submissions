class Solution {
    int n ;
    int[][] dp;
    public int change(int amount, int[] coins) {
        n = coins.length;
        dp= new int[n+2][amount+10];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return helper(0,amount,coins);
    }
    public int helper(int idx, int amount,  int[] coins){
        if(amount==0){
            return 1;
        }
        if(amount<0 || idx==n){
            return 0;
        }
        if(dp[idx][amount]!=-1){
            return dp[idx][amount];
        }
        int x =0;
        int y =0;
        x = helper(idx,amount-coins[idx],coins);
        y = helper(idx+1, amount, coins);
        
        return dp[idx][amount] =  x+y;
    }
}
