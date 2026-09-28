class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(0,s,result,new ArrayList<>());
        return result;
    }
    public void helper(int idx, String s, List<List<String>> result, List<String> temp){
        if(idx==s.length()){
            result.add(new ArrayList<>(temp));
        }
        for(int end=idx;end<s.length();end++){
            if(isPalindrome(s,idx,end)){
                temp.add(s.substring(idx,end+1));
                helper(end+1,s,result,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end ){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end --;
        }
        return true;
    }
}
