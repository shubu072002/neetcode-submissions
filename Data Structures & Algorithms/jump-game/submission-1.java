class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int finaldes=n-1;
        for(int i=n-2;i>=0;i--){
            if(i+nums[i]>=finaldes){
                finaldes=i;
            }
        }
        return finaldes==0?true:false;
    }
}
