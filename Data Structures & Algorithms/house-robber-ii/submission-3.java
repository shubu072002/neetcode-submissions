class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        if(n<2){
            return nums[0];
        }
        int[] includeFirst = new int[n-1];
        int[] includeLast = new int[n-1];
        for(int i=0;i<n-1;i++){
            includeFirst[i]=nums[i];
            includeLast[i]=nums[i+1];
        }
        int x = helper(includeFirst);
        int y = helper(includeLast);
        
        return Math.max(x,y);
    }
    public int helper(int[] nums){
        int n = nums.length;
        if(n==0){
            return 0;
        }
        if(n<2){
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}
