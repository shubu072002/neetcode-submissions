class Solution {
    public boolean isAnagram(String s, String t) {
       int n = s.length();
       int m = t.length();
       if(n!=m){
        return false;
       }
       int[] freqMap = new int[26];
       for(int i=0;i<n;i++){
        char ch1 = s.charAt(i);
        char ch2 = t.charAt(i);
        
        freqMap[ch1-'a']++;
        freqMap[ch2-'a']--;
       }
       for(int i=0;i<freqMap.length;i++){
         if(freqMap[i]!=0){
            return false;
         }
       }
       return true;
    }
}
