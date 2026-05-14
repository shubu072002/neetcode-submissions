class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s,res,new ArrayList<>(),0);
        return res;
    }
    public void helper(String s ,  List<List<String>> res, List<String> sublist, int idx ){
        if(idx==s.length()){
            res.add(new ArrayList<>(sublist));
        }
        for(int end=idx;end<s.length();end++){
            if(isPalindrome(s,idx, end)){
                sublist.add(s.substring(idx,end+1));
                helper(s,res,sublist,end+1);
                sublist.remove(sublist.size()-1);
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
