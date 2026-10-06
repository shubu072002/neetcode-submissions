class Solution {
    public int maxArea(int[] heights) {
       int n = heights.length;
       int max = 0;
       int left = 0;
       int right = n-1;
       int area = 0;
       while(left<right){
        if(heights[left]<heights[right]){
            int length = heights[left];
            int width = right-left;
            area = length*width;
            left++;
        }
        else{
            int length = heights[right];
            int width = right-left;
            area = length*width;
            right--;
        }
        max = Math.max(area,max);
       } 
       return max;
    }
}
