class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum =0;
        return helper(nums,target,0,sum);
    }
    public int helper(int[] nums, int target, int index, int sum){
        if(index>=nums.length && sum==target){
            return 1;
        }
        if(index>=nums.length){
            return 0;
        }
        int x = helper(nums,target,index+1,sum+nums[index]);
        int y = helper(nums,target,index+1,sum-nums[index]);
        return x + y;
    }
}
