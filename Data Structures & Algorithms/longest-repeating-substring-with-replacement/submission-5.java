class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxFreq = Integer.MIN_VALUE;
        int maxLength  = Integer.MIN_VALUE;
        int start =0;
        int end =0;
        int[] freqMap = new int[26];
        while(end<n){
            char ch = s.charAt(end);
            freqMap[ch-'A']++;
            maxFreq = Math.max(maxFreq, freqMap[ch-'A']);
            int windowSize = end - start +1;
            if((windowSize-maxFreq)>k){
                freqMap[s.charAt(start)-'A']--;
                start++;
            }
            windowSize = end - start +1;
            maxLength = Math.max(maxLength, windowSize);
            end++;
        }
        return maxLength;
    }
}
