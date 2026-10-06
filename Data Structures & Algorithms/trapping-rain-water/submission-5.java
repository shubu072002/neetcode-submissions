class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int ans = 0;
        int lmh =0;
        int rmh =0;
        while(left<right){
            lmh = Math.max(lmh,height[left]);
            rmh = Math.max(rmh,height[right]);

            if(lmh<rmh){
                ans+= lmh-height[left];
                left++;
            }
            else{
                ans+= rmh-height[right];
                right--;
            }
        }
        return ans;
    }
}
