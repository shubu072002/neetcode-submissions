class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count =0;
        for(int i=0;i<n;i++){
            count += helper(s,i,i);
            count += helper(s,i,i+1);
        }
        return count;
    }
    public int helper(String s, int start, int end){
        int n = s.length();
        int count = 0;
        while(start>=0 && end<n){
           if(s.charAt(start)!=s.charAt(end)){
            break;
           }
           count++;
           start--;
           end++;
        }
        return count;
    }
}
