class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        if(n<2){
            return nums[0];
        }
        int[] arr1 = new int[n-1]; // include first
        int[] arr2 = new int[n-1]; // include last
        for(int i=1;i<n;i++){
            arr1[i-1]=nums[i-1];
            arr2[i-1]=nums[i];
        }
        int includefirst = helper(arr1);
        int includelast = helper(arr2);

        return Math.max(includefirst, includelast);
    }
    public int helper(int[] nums){
        int n = nums.length;
        if(n<2){
           return nums[0];
        }
        int[] dp = new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}
