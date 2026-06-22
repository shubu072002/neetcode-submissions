class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<=n;i++){
            int element = (i==n)?0:heights[i];
            while(!stack.isEmpty() && heights[stack.peek()]>element){
                int height = heights[stack.pop()];
                int ps = stack.isEmpty()?-1:stack.peek();
                int width = i -ps -1;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
