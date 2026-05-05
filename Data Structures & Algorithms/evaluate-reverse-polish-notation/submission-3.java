class Solution {
    public boolean isOperator(String str){
        return str.equals("+") || str.equals("*") ||
         str.equals("-") || str.equals("/");
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String element: tokens){
            if(!isOperator(element)){
                stack.push(Integer.parseInt(element));
            }
            else{
                int b = stack.pop();
                int a = stack.pop();
                if(element.equals("+")) stack.push(a+b);
                else if(element.equals("-")) stack.push(a-b);
                else if(element.equals("*")) stack.push(a*b);
                else if(element.equals("/")) stack.push(a/b);
            }
        }
        return stack.pop();
    }
}
