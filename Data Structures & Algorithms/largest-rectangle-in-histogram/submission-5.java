class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<=n;i++){
            int element = i==n?0:heights[i];
            while(!stack.isEmpty() && heights[stack.peek()]>element){
                int h = heights[stack.pop()];
                int ps = stack.isEmpty()?-1:stack.peek();
                int w = i-ps-1;
                int area = h*w;
                maxArea = Math.max(maxArea,area);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
