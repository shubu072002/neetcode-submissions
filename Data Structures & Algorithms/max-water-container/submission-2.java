class Solution {
    public int maxArea(int[] heights) {
        int n= heights.length;
        int left = 0;
        int right = n-1;
        int max = 0;
        while(left<right){
           int height = Math.min(heights[left],heights[right]);
           int length = right-left;
           int area = length * height;
           max = Math.max(area, max);
           if(heights[left]<heights[right]){
            left++;
           }
           else{
            right--;
           }
        }
        return max;
    }
}
