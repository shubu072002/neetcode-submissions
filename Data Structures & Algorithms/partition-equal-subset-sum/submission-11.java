class Solution {
    int n;
    int[][] dp;
    public boolean canPartition(int[] nums) {
        n = nums.length;
        int total = 0;
        for(int num: nums){
             total+=num;
        }
        if(total%2!=0){
            return false;
        }
        int target = total/2;
        dp=new int[n+2][total];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return helper(0, nums, target);
    }
    public boolean helper(int i, int[] nums, int target){
        if(target==0){
            return true;
        }
        if(i>=n || target<0){
            return false;
        }
        if(dp[i][target]!=-1){
            return dp[i][target]==1;
        }
        boolean take = false;
        boolean nottake = false;
        take= helper(i+1,nums,target-nums[i]);
        nottake =  helper(i+1, nums, target);

        dp[i][target] =take||nottake?1:0;
        return take||nottake;
    }
}
