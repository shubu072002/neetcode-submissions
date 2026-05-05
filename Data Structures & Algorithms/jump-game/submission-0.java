class Solution {
    public boolean canJump(int[] nums) {
        int finaldes = nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
        int jump = nums[i]+i;
        if(jump>=finaldes){
            finaldes=i;
        }
        }
        return finaldes==0?true:false;
    }
}
