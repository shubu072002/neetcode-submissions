class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int maxArea =0;
        int start =0;
        int end = n-1;
        while(start<end){
            int height = Math.min(heights[start],heights[end]);
            int width = end - start;
            int area = height * width;
            maxArea= Math.max(maxArea,area);
            if(heights[start]<=heights[end]){
                start++;
            }
            else{
                end--;
            }
        }
        return maxArea;
    }
}
