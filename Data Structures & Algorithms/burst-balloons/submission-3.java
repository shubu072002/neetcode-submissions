class Solution {
    public int maxCoins(int[] nums) {
       int n = nums.length;
       int[] arr = new int[n+2];
       arr[0]=arr[arr.length-1]=1;
       int[][] dp = new int[n+2][n+2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
       for(int i=1;i<=n;i++){
        arr[i]=nums[i-1];
       } 
       return helper(1,n,arr,dp);
    }
    public int helper(int i, int j, int[] arr, int[][] dp){
        if(j<i){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int max = Integer.MIN_VALUE;
        for(int idx=i;idx<=j;idx++){
            int curr = arr[i-1]*arr[idx]*arr[j+1]+helper(i,idx-1,arr,dp)+helper(idx+1,j,arr,dp);
            max = Math.max(curr,max);
        }
        return dp[i][j]=max;
    }
}
