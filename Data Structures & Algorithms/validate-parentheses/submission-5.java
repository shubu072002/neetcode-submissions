class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            }
             else {
                if (stack.isEmpty()) {
                    return false;
                }
                else if(stack.peek()=='{' && ch!='}'){
                    return false;
                }
                 else if(stack.peek()=='[' && ch!=']'){
                    return false;
                }
                 else if(stack.peek()=='(' && ch!=')'){
                    return false;
                }
                else{
                    stack.pop();
                }

            }
        }
        return stack.isEmpty();
    }
}
