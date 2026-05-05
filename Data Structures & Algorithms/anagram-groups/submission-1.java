class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            String s = strs[i];
            s.toLowerCase();
            int[] freqMap = new int[26];
            for(int j=0;j<s.length();j++){
                freqMap[s.charAt(j)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<26;j++){
                sb.append('#');
                sb.append(freqMap[j]);
            }
            String str = sb.toString();
            if(!map.containsKey(str)){
                map.put(str,new ArrayList<>());
            }
            map.get(str).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
