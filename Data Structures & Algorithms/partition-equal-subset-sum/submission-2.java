class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum =0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int target = sum/2;
        int[][] dp = new int[n+10][target + 20];
        for(int i=0;i<dp.length;i++){
           for(int j=0;j<dp[0].length;j++){
            dp[i][j]=-1;
           }
        }
        return helper(0,nums,target,dp);
    }
    public boolean helper(int idx, int[] nums, int target,int[][] dp){
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
            return dp[idx][target]==1;
        }
        boolean x = false;
        boolean y = false;

        x=helper(idx+1,nums,target-nums[idx],dp);
        y=helper(idx+1,nums,target,dp);

        dp[idx][target] = x||y?1:0;
        return x||y;

    }
}
