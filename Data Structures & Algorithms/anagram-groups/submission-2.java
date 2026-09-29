class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str: strs){
            int[] hash = new int[26];
            for(int i=0;i<str.length();i++){
                int idx = str.charAt(i)-'a';
                hash[idx]++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                sb.append(hash[i]);
                sb.append('#');
            }
            String s = sb.toString();
            if(!map.containsKey(s)){
                map.put(s, new ArrayList<>());
            }
            List<String> temp = map.get(s);
            temp.add(str);
        }
       return new ArrayList<>(map.values());
    }
}
