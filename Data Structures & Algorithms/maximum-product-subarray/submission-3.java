class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n<2){
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        int left = 1;
        int right =1;
        for(int i=0;i<n;i++){
            left = left==0?1:left;
            right = right==0?1:right;
            left = left * nums[i];
            right= right * nums[n-i-1];
            max = Math.max(max,Math.max(left,right));
        }
        return max;
    }
}
