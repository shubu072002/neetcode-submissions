class Solution {
    public int trap(int[] height) {
       int n = height.length;
       int l = 0;
       int r = n-1;
       int area = 0 ;
       int lmh =0;
       int rmh =0;
       while(l<r){
         lmh = Math.max(lmh,height[l]);
         rmh = Math.max(rmh,height[r]);
         if(lmh<rmh){
            area = area + (lmh-height[l]);
            l++;
         }else{
            area = area + (rmh-height[r]);
            r--;
         }
       }
       return area;
    }
}
