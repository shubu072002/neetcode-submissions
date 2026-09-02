class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int i=0;i<n;i++){
            total+=nums[i];
        }
        if(total%2!=0){
            return false;
        }
        int target = total/2;
        int[][] dp = new int[n+1][target+2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        if(isPresent(0,nums,target,dp)){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isPresent(int idx, int[] nums, int target,int[][] dp){
        if(target==0){
            return true;
        }
        if(target<0 || idx==nums.length){
            return false;
        }
        if(dp[idx][target]!=-1){
            return dp[idx][target]==1;
        }
        boolean x = isPresent(idx+1,nums,target-nums[idx],dp);
        boolean y = isPresent(idx+1,nums,target,dp);

         dp[idx][target]=x||y?1:0;
         return x||y;
    }
}
