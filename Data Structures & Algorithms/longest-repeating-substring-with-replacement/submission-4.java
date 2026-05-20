class Solution {
    public int characterReplacement(String s, int k) {
       int n = s.length();
       int[] freqMap = new int[26];
       int start =0;
       int end =0;
       int maxFreq = Integer.MIN_VALUE;
       int maxWindow = Integer.MIN_VALUE;
       while(end<n){
        char ch = s.charAt(end);
        freqMap[ch-'A']++;
        maxFreq = Math.max(maxFreq,freqMap[ch-'A'] );
        int windowSize = end - start + 1;
         if(windowSize-maxFreq > k){
            freqMap[s.charAt(start)-'A']--;
            start++;
         }
        int length= end - start +1;
        maxWindow=Math.max(length,maxWindow);
        end ++;
       } 
       return maxWindow;
    }
}
