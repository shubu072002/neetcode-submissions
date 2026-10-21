class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxFreq = Integer.MIN_VALUE;
        int maxLength = Integer.MIN_VALUE;
        int[] freqMap = new int[26];
        int start =0;
        int end =0;
        while(end<n){
            freqMap[s.charAt(end)-'A']++;
            maxFreq = Math.max(freqMap[s.charAt(end)-'A'], maxFreq);
            int windowsize = end-start+1;
            if(windowsize-maxFreq>k){
                freqMap[s.charAt(start)-'A']--;
                start++;
            }
            windowsize = end-start+1;
            maxLength = Math.max(maxLength, windowsize);
            end++;
        }
        return maxLength;
    }
}
