class Solution {
    public boolean isOperator(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if(!isOperator(str)){
                stack.push(Integer.parseInt(str));
            }
            else{
                int b = stack.pop();
                int a = stack.pop();
                if(str.equals("+")) stack.push(a+b);
                else if(str.equals("-")) stack.push(a-b);
                else if(str.equals("/")) stack.push(a/b);
                else if(str.equals("*")) stack.push(a*b);
            }
        }
       return stack.pop();
    }
}
