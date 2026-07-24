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
       int targetSum = sum/2;
       int[][] dp = new int[n+2][targetSum+2];
       for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
       if(helper(nums,0,targetSum,dp)){
        return true;
       }
       else{
        return false ;
       }
    }
    public boolean helper(int[] nums, int idx, int target, int[][] dp){
        int n =nums.length;
        //base case 
        if(target<0 || idx>=n){
            return false;
        }
        if(target==0){
            return true;
        }
        if(dp[idx][target]!=-1){
            return dp[idx][target]==1;
        }
        boolean x = helper(nums,idx+1,target-nums[idx],dp);
        boolean y = helper(nums,idx+1,target,dp);
        dp[idx][target] = x||y?1:0;
        return x||y;

    }
}
