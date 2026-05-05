class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = arr[arr.length-1] =1;
        for(int i=0;i<n;i++){
            arr[i+1]=nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(arr,1,n,dp);
    }
    public int helper(int[] arr, int i, int j, int[][] dp ){
        //base case
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int max = Integer.MIN_VALUE;
        for(int idx=i;idx<=j;idx++){
            int curr = arr[i-1]*arr[idx]*arr[j+1]+ helper(arr,i,idx-1, dp)+helper(arr,idx+1,j, dp);
            max = Math.max(curr,max);
        }
        return dp[i][j]=max;
    }
}