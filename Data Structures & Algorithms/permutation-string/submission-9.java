class Solution {
    public boolean isValid(int[] nums1, int[] nums2){
        for(int i=0;i<26;i++){
            if(nums1[i]!=nums2[i]){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(m<n){
            return false;
        }
        int[] freqMap1 = new int[26];
        int[] freqMap2 = new int[26];
        
        for(int i=0;i<n;i++){
            freqMap1[s1.charAt(i)-'a']++;
            freqMap2[s2.charAt(i)-'a']++;
        }
        if(isValid(freqMap1,freqMap2)){
            return true;
        }
        for(int i=1;i<=m-n;i++){
            freqMap2[s2.charAt(i-1)-'a']--;
            freqMap2[s2.charAt(i+n-1)-'a']++;
            if(isValid(freqMap1,freqMap2)){
                return true;
            }
        }
        return false;
    }
}
