class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int n = s.length();
        int left=0;
        int right=n-1;
        while(left<right){
            if(!Character.isLetterOrDigit(s.charAt(left))){
               left++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(right))){
               right--;
            }
            else if(s.charAt(left)!=s.charAt(right)){
                    return false;
                }
            else{
                left++;
                right--;
            }    
        
        }
        return true;

    }
}
