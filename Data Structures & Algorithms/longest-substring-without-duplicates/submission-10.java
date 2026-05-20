class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start =0;
        int end =0;
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(end<n){
            char ch = s.charAt(end);
            if(map.containsKey(ch) && start<=map.get(ch)){
                start = map.get(ch)+1;
            }
            map.put(ch,end);
            int length = end - start + 1;
            maxLength = Math.max(maxLength, length);
            end++;
        }
        return maxLength;
    }
}
