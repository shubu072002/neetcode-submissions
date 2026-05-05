class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n =s.length();
        if(n==0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0 ;
        int maxLen = Integer.MIN_VALUE;
        while(end<n){
            char ch = s.charAt(end);
            if(map.containsKey(ch) && map.get(ch)>=start){
                start = map.get(ch)+1;
            }
             map.put(ch,end);
            int length = end - start +1;
            maxLen = Math.max(length, maxLen);
            end++;

        }
        return maxLen;
    }
}
