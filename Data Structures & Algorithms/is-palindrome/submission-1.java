class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        String lowerCase = s.toLowerCase();
        while(i<j){
            char left = lowerCase.charAt(i);
            char right = lowerCase.charAt(j);
            if(!Character.isLetterOrDigit(left)){
                i++;
            }
            else if( !Character.isLetterOrDigit(right)){
                j--;
            }
            
            else{
                if(left!=right){
                return false;
                }
            
            i++;
            j--;
            }
        }
        return true;
    }
}
