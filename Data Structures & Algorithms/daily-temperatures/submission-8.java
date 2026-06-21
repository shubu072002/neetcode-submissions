class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       int n = temperatures.length;
       int[] res = new int[n];
       Stack<Integer> stack = new Stack<>();
       for(int i=n-1;i>=0;i--){
         int nums = temperatures[i];
         while(!stack.isEmpty() && nums>=temperatures[stack.peek()]){
            stack.pop();
         }
         if(!stack.isEmpty()){
            res[i] = stack.peek()-i;
         }
         stack.push(i);
       } 
       return res;
    }
}
