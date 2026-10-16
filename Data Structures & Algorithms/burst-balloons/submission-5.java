class Solution {
    int[][] dp ;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] coins = new int[n+2];
        coins[0]=1;
        coins[coins.length-1]=1;
        for(int i=1;i<=n;i++){
            coins[i]=nums[i-1];
        }
        dp= new int[n+3][n+3];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return helper(1,n,coins);
    }
    public int helper(int i, int j, int[] coins){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int max = Integer.MIN_VALUE;
        for(int idx=i;idx<=j;idx++){
            int curr = coins[idx]*coins[i-1]*coins[j+1]+
                       helper(i,idx-1,coins)+helper(idx+1,j,coins);
            max = Math.max(max,curr);           
        }
        return dp[i][j] =  max;
    }
}
