class Solution {
    public boolean isOperator(String s){
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") );
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
       for(String token: tokens){
        if(!isOperator(token)){
            stack.push(Integer.parseInt(token));
        }
        else{
            int a = stack.pop();
            int b = stack.pop();
            if(token.equals("+")){
                stack.push(a+b);
            }
            else if(token.equals("-")){
                stack.push(b-a);
            }else if(token.equals("*")){
                stack.push(a*b);
            }
            else{
                stack.push(b/a);
            }
        }
       }
        return stack.peek();
    }
}
