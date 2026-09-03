class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int end  =0;
        for(int i=0;i<n;i++){
            int left = i;
            int right =i;
            char ch = s.charAt(i);
            while(left>=0 && s.charAt(left)== ch){
                left--;
            }
            while(right<n && s.charAt(right)== ch){
                right++;
            }
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            left++;
            if(right-left>end-start){
               start=left;
               end =right;
            }
        }
        return s.substring(start,end);
    }
}
