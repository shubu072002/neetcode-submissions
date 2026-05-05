class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(0,res,s,new ArrayList<>());
        return res;
    }
    public void helper(int idx,List<List<String>> res,String s,List<String> sublist ){
        int n = s.length();
        //base case
        if(idx==n){
            res.add(new ArrayList<>(sublist));
            return;
        }
        for(int end= idx; end<n;end++){
            if(isPalindrome(s,idx,end)){
                sublist.add(s.substring(idx,end+1));
                helper(end+1, res, s , sublist);
                //backtrack
                sublist.remove(sublist.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if( s.charAt(start)!=s.charAt(end)){
              return false;
            }
            start++;
            end--;
        }
        return true;
    }
}