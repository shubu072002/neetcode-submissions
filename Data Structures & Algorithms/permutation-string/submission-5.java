class Solution {
    public boolean isvalid(int[] freqmap1, int[] freqmap2){
        for(int i=0;i<freqmap1.length;i++){
            if(freqmap1[i]!=freqmap2[i]){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int[] freqmap1 = new int[26];
        int[] freqmap2 = new int[26];
        int n = s1.length();
        int m = s2.length();
        if(m<n){
            return false;
        }
        int i=0;
        while(i<n){
            freqmap1[s1.charAt(i)-'a']++;
            freqmap2[s2.charAt(i)-'a']++;
            i++;
        }
        if(isvalid(freqmap1,freqmap2)){
            return true;
        }
        for(int idx=1;idx<=m-n;idx++){
            freqmap2[s2.charAt(idx-1)-'a']--;
            freqmap2[s2.charAt(idx+n-1)-'a']++;
            if(isvalid(freqmap2,freqmap1)){
                return true;
            }
        }
        return false;
    }
}
