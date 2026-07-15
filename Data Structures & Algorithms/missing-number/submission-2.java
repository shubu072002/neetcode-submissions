class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int num = 0;
        for(int i=1;i<=n;i++){
            num = num^i;
        }
        for(int i=0;i<n;i++){
            num = num^nums[i];
        }
        return num;
    }
}
