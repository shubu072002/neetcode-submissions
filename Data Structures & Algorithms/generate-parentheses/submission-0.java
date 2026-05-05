class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n,0,0,res,"");
        return res;
    }
    public void helper(int n, int open, int close, List<String> res, String temp){
        if(open==n && close==n){
            res.add(temp);
            return;
        }
        if(open>n || close>n){
            return;
        }
        if(close<open){
            helper(n, open+1, close, res, temp.concat("("));
            helper(n, open, close+1, res, temp.concat(")"));
        }
        else
        {
            helper(n, open+1, close, res, temp.concat("("));
        }
    }
}
