class Solution {
    public boolean isValid(String s) {
     int n = s.length();
     if(n%2!=0){
        return false;
     }   
     Stack<Character> stack = new Stack<>();
     for(int i=0;i<n;i++){
        if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
            stack.push(s.charAt(i));
        }

        else{
            if(stack.size()==0){
                return false;
            }
            int top = stack.peek();
            if(s.charAt(i)=='}' && top!='{'){
              return false;
            }
            else if(s.charAt(i)==']' && top!='['){
              return false;
            }
            else if(s.charAt(i)==')' && top!='('){
              return false;
            }
            else{
                stack.pop();
            }

        }
     }
     if(stack.size()==0){
        return true;
     }
     return false;

    }
}
