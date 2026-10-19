class Solution {
    public int lengthOfLIS(int[] nums) {
       int n = nums.length;
       int[] dp = new int[n];
       Arrays.fill(dp,1);
       for(int j=1;j<n;j++){
        for(int i=0;i<j;i++){
            if(nums[j]>nums[i]){
            if(dp[i]+1>dp[j]){
                dp[j]=dp[i]+1;
            }
            }
        }
       } 
       int max = 0;
       for(int i=0;i<dp.length;i++){
         max = Math.max(max, dp[i]);
       }
       return max;
    }
}
