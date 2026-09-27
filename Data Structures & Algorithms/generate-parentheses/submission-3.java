class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(0,0,result,n,"");
        return result;
    }
    public void helper(int open, int close, List<String> result, int n , String temp ){
        if(open==n && close==n){
            result.add(temp);
            return;
        }
        if(open>n || close>n){
           return;
        }
        if(open>close){
            helper(open+1,close,result,n,temp.concat("("));
            helper(open,close+1,result,n,temp.concat(")"));
        }else{
            helper(open+1,close,result,n,temp.concat("("));
        }
    }
}
