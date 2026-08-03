class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr  = new int[n+2];
        arr[0] = arr[n+1] = 1;
        for(int i=1;i<=n;i++){
            arr[i]=nums[i-1];
        }
        int[][] dp = new int[n+2][n+2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return helper(arr,1,n,dp);
    }
    public int helper(int[] arr, int i, int j,int[][] dp){
        if(i>j){
            return 0 ;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int max = Integer.MIN_VALUE;
        for(int idx=i;idx<=j;idx++){
            int curr = arr[i-1]*arr[idx]*arr[j+1]+helper(arr,i,idx-1,dp)+helper(arr,idx+1,j,dp);
            max = Math.max(curr,max);
        }
        return dp[i][j]=max;
    }
}
