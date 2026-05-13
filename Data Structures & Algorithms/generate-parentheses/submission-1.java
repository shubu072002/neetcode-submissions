class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(0,0,n,res,"");
        return res;
    }
    public void helper(int open, int close, int n, List<String> res, String temp){
        if(open==n && close==n){
            res.add(temp);
            return;
        }
        if(open>n || close>n){
            return;
        }
        if(close<open){
            helper(open+1,close,n,res,temp.concat("("));
            helper(open,close+1,n,res,temp.concat(")"));
        }
        else{
             helper(open+1,close,n,res,temp.concat("("));
        }
    }
}
