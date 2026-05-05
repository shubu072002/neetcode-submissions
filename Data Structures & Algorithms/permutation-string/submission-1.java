class Solution {
     private boolean isValid(int[] arr1, int[] arr2){
        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n= s1.length();
        int m = s2.length();
        if(m<n){
            return false;
        }
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        
        for(int i=0;i<n;i++){
            map1[s1.charAt(i)-'a']++;
            map2[s2.charAt(i)-'a']++;
        }
        if(isValid(map1, map2)){
            return true;
        }
        for(int i=1;i<=m-n;i++){
            map2[s2.charAt(i-1)-'a']--;
            map2[s2.charAt(i+n-1)-'a']++;
            if(isValid(map1, map2)){
                return true;
            }
        }
        return false;
}
}
