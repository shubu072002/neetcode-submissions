class Solution {
    public int evalRPN(String[] tokens) {
       int n = tokens.length;
       Stack<Integer> stack = new Stack<>();
       for(int i=0;i<n;i++){
        String s  = tokens[i];
        if(!s.equals("+") && !s.equals("*") && !s.equals("/") && !s.equals("-")){
            stack.push(Integer.parseInt(s));
        }
        else{
            int y = stack.pop();
            int x = stack.pop();
            if(s.equals("+")) stack.push(x+y);
            else if(s.equals("-")) stack.push(x-y);
            else if(s.equals("/")) stack.push(x/y);
            else if(s.equals("*")) stack.push(x*y);
        }
       }
       return stack.peek();
    }
}
