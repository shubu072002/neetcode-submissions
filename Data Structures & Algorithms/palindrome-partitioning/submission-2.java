class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s,res,0,new ArrayList<>());
        return res;
    }
    public void helper(String s,List<List<String>> res, int idx,List<String> temp ){
        if(idx==s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int end=idx;end<s.length();end++){
            if(isPalindrome(s,idx,end)){
                temp.add(s.substring(idx,end+1));
                helper(s,res,end+1,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
