class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for(int i=0;i<=n;i++){
            xor = xor ^ i;
        }
        for(int element: nums){
            xor = xor ^ element;
        }
        return xor;
    }
}
