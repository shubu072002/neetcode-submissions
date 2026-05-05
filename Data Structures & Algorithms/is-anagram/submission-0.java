class Solution {
    public boolean isAnagram(String s, String t) {
       if(s.length()!=t.length()){
            return false;
        }
        s= s.toLowerCase();
        t=t.toLowerCase();
        int[] freqMap = new int[26];
        int i=0;
        int j=0;
        while(i<s.length()){
            char ch = s.charAt(i);
            int freqIdx1 = ch-'a';
            freqMap[freqIdx1]++;
            
            char sh = t.charAt(j);
            int freqIdx2 = sh-'a';
            freqMap[freqIdx2]--;
            
            i++;
            j++;
        }
        for(int element: freqMap){
            if(element!=0){
                return false;
            }
        }
        return true;
    }
}
