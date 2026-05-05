class Solution {
    
         private boolean isOperator(String str){
        return str.equals("*") || str.equals("+") || str.equals("-") || str.equals("/") ;
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s: tokens){
        if(!isOperator(s)){
            st.push(Integer.parseInt(s));
        }
        else{
            int b = st.pop();
            int a = st.pop();
            if (s.equals("+")) st.push(a+b);
            else if (s.equals("-")) st.push(a-b);
            else if (s.equals("*")) st.push(a*b);
            else if (s.equals("/")) st.push(a/b);
        }
        }
        return st.pop();    
    }
}

