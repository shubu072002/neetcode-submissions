class Solution {
    int n;
    public int countSubstrings(String s) {
        n = s.length();
       int count = 0;
       for(int i=0;i<n;i++){
           count += helper(s,i,i);
           count+=helper(s,i,i+1);
       } 
       return count;
    }
    public int helper(String s, int left, int right){
        int count =0;
        while(left>=0 && right<n){
           if(s.charAt(left)!=s.charAt(right)){
            break;
           }
           count++;
           left--;
           right++;
        }
        return count;
    }
}
