class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left =0;
        int right=n-1;
        int max = Integer.MIN_VALUE;
        while(left<right){
            int height = Math.min(heights[left],heights[right]);
            int area = height * (right-left);

            max = Math.max(max, area);
            if(heights[left]<=heights[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }
}
