class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int start = 0;
        int end = 0;
        int startIdx = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int uniqueCharCount = map.size();
        int minLength = Integer.MAX_VALUE;
        while (end < n) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    uniqueCharCount--;
                }
            }
            while (uniqueCharCount == 0) {
                int length = end - start + 1;
                if (length < minLength) {
                    minLength = length;
                    startIdx = start;
                }
                ch = s.charAt(start);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);

                    if (map.get(ch) > 0) {
                        uniqueCharCount++;
                    }
                }
                start++;
            }
            end++;
        }
        if (startIdx == -1) {
            return "";
        } else {
            return s.substring(startIdx, startIdx + minLength);
        }
    }
}
