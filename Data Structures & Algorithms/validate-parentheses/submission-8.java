class Solution {
    public boolean isValid(String s) {
       Stack<Character> stack = new Stack<>();
       int n = s.length();
       for(int i=0;i<n;i++){
        char ch = s.charAt(i);
        if(ch=='(' || ch=='{' || ch=='['){
            stack.push(ch);
        }
       
        else{
             if(stack.isEmpty()){
           return false;
        }
            if(ch=='}' && stack.peek()!='{'){
                return false;
            }
            else if(ch==']' && stack.peek()!='['){
                return false;
            }
            else if(ch==')' && stack.peek()!='('){
                return false;
            }
            stack.pop();
        }
       } 
       if(stack.isEmpty()){
            return true;
       }
       else{
            return false;
       }
    }
}
