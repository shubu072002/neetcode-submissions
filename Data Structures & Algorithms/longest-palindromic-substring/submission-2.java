class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int end =0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            int left = i;
            int right=i;
            while(left>=0 && s.charAt(left)==ch){
                left--;
            };
            while(right<n && s.charAt(right)==ch){
                right++;
            }
            while(left>=0 && right<n){
                if(s.charAt(left)!=s.charAt(right)){
                    break;
                }
                left--;
                right++;
            }
            left++;
            if(end-start<right-left){
                start = left;
                end = right;
            }
        }
        return s.substring(start,end);
    }
}
