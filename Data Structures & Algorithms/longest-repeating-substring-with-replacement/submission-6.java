class Solution {
    public int characterReplacement(String s, int k) {
       int[] freq = new int[26];
       int start =0;
       int end =0; 
       int max = 0;
       int maxFreq =0;
       while(end<s.length()){
        char ch = s.charAt(end);
        freq[ch-'A']++;
        maxFreq = Math.max(maxFreq, freq[ch-'A']);
        int windowSize = end - start + 1;
        if(windowSize-maxFreq>k){
          freq[s.charAt(start)-'A']--;
          start++;
        }
        windowSize = end - start + 1;
        max = Math.max(windowSize,max);
        end++;
       }
       return max;
    }
}
