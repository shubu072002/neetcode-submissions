class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openBrackets = new Stack<>();
        Stack<Integer> aesterisk = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                openBrackets.push(i);
            }
            else if(s.charAt(i)=='*'){
                aesterisk.push(i);
            }
            else{
                if(!openBrackets.isEmpty()){
                    openBrackets.pop();
                }
                else if(!aesterisk.isEmpty()){
                    aesterisk.pop();
                }
                else{
                    return false;
                }
            }
        }
        while(!openBrackets.isEmpty()){
            if(aesterisk.isEmpty()){
                return false;
            }
            if(openBrackets.pop()>aesterisk.pop()){
                return false;
            }
        }
        return true;
    }
}
