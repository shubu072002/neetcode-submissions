class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
       Stack<Integer> stack = new Stack<>();
       int maxArea = Integer.MIN_VALUE; 
       for(int i=0;i<=n;i++){
        int element = (i==n)?0:heights[i];
        while(!stack.isEmpty() && heights[stack.peek()]>element){
            int h = heights[stack.pop()];
            int ps = (stack.isEmpty())?-1:stack.peek();
            int w = i - ps - 1;
            maxArea = Math.max(maxArea, h*w);
        }
        stack.push(i);
       }
       return (maxArea==Integer.MIN_VALUE)?0:maxArea;
    }
}
