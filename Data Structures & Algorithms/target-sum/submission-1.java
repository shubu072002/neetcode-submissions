class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum =0;          
        return helper(0,nums,target,sum);
    }
    public int  helper(int idx, int[] nums, int target, int sum){
        if(idx>=nums.length && sum==target){
            return 1;
        }
         if(idx>=nums.length){
            return 0;
        }
        int x = helper(idx+1,nums,target,sum+nums[idx]);
        int y = helper(idx+1,nums,target,sum-nums[idx]);
        return  x + y;
    }
}
