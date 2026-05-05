class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            int[] freq = new int[26];
            s=s.toLowerCase();
            String cur = s;
            for(int i=0;i<cur.length();i++){
                char ch = cur.charAt(i);
                freq[ch-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
               sb.append('#');
               sb.append(freq[i]);
            }
            String key = sb.toString();
            
            if(!map.containsKey(key)){
             map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        
        }
        return new ArrayList<>(map.values());
    }
}
