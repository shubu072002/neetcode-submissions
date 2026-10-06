class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        int n = str.length();
        int start = 0;
        int end = n - 1;
        while (start < end) {
            while (start<end && !Character.isLetterOrDigit(str.charAt(start))) {
                start++;
            }
            while (start<end &&  !Character.isLetterOrDigit(str.charAt(end))) {
                end--;
            }
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
