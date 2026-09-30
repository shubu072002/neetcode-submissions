class Solution {
    public boolean isOperator(String str){
     if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") ){
        return true;
     }
     return false;
    }
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            if(!isOperator(tokens[i])){
                stack.push(Integer.parseInt(tokens[i]));
            }
            else{
                int a = stack.pop();
                int b = stack.pop();

                if(tokens[i].equals("+")){
                    stack.push(a+b);
                }
                else if(tokens[i].equals("-")){
                    stack.push(b-a);
                }
                else if(tokens[i].equals("*")){
                    stack.push(a*b);
                }
                else if(tokens[i].equals("/")){
                    stack.push(b/a);
                }
                
            }
        }
        return stack.peek();
    }
}
