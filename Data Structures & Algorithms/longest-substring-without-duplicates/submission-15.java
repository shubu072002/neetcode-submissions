class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n<1){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        int start= 0;
        int end =0;
        while(end<n){
            char ch = s.charAt(end);
            if(map.containsKey(ch) && map.get(ch)>=start){
                start= map.get(ch)+1;
            }
            int length =  end - start + 1;
            max = Math.max(length, max);
            map.put(ch,end);
            end++;
        }
        return max ;
    }
}
