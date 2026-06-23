class Solution {
    public boolean isValid(int[] a , int[] b){
        for(int i=0;i<26;i++){
            if(a[i]!=b[i]){
               return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (m < n) {
            return false;
        }
        int[] freqmap1 = new int[26];
        int[] freqmap2 = new int[26];
        for (int i = 0; i < n; i++) {
            freqmap1[s1.charAt(i)-'a']++;
            freqmap2[s2.charAt(i)-'a']++;
        }
        if(isValid(freqmap1,freqmap2)){
            return true;
        }
        for(int i=1;i<=m-n;i++){
            freqmap2[s2.charAt(i-1)-'a']--;
            freqmap2[s2.charAt(i+n-1)-'a']++;

            if(isValid(freqmap1,freqmap2 )){
                return true;
            }
        }
        return false;

    }
}
