class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum =0;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int target = sum/2;
        int dp[][] = new int[n+1][target+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return helper(nums,0,target,dp);
    }
    public boolean helper(int[] nums, int idx, int target,int[][] dp){
        if(target==0){
            return true;
        }
        if(target<0){
            return false;
        }
        if(idx>=nums.length){
            return false;
        }
        if(dp[idx][target]!=-1){
            return dp[idx][target] ==1;
        }
        boolean x = helper(nums,idx+1,target-nums[idx],dp);
        boolean y = helper(nums,idx+1,target,dp);

         dp[idx][target] = x||y?1:0;
         return x||y;
    }
}
