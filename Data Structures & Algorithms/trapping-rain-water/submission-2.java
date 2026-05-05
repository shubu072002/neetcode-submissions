class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n-1;
        int lmh = 0;
        int rmh = 0;
        int max = 0;
        while(l<r){
            lmh = Math.max(lmh, height[l]);
            rmh = Math.max(rmh, height[r]);
            if(lmh<rmh){
                max = max + (lmh-height[l]);
                l++;
            }
            else{
               max = max + (rmh-height[r]);
                r--;  
            }
        }
        return max;
    }
}
