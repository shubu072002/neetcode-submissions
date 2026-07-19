class Solution {
    public int trap(int[] height) {
        int area =0;
        int lmh =0;
        int rmh =0;
        int left = 0;
        int right = height.length-1;
        while(left<right){
            lmh = Math.max(lmh,height[left]);
            rmh = Math.max(rmh,height[right]);
            if(lmh<=rmh){
                area += lmh-height[left];
                left++;
            }
            else{
                area += rmh-height[right];
                right--;
            }
        }
        return area;
    }
}
