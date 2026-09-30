class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int max =0;
        for(int i=0;i<=n;i++){
            int element  = (i==n)?0:heights[i];
            while(!stack.isEmpty() && element<heights[stack.peek()]){
               int l = heights[stack.pop()];
               int ps = stack.isEmpty()?-1:stack.peek();
               int w = i - ps - 1;
               int area = l*w;
               max = Math.max(max,area);
            }
            stack.push(i);
        }
        return max;
    }
}
