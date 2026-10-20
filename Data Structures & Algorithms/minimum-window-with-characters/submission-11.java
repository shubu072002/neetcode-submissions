class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int uniquecharcount = map.size();
        int startIdx = -1;
        int start =0;
        int end =0;
        int minLength = Integer.MAX_VALUE;
        while(end<n){
            char ch = s.charAt(end);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                    uniquecharcount--;
                }
                while(uniquecharcount==0){
                    int length = end - start +1;
                    if(length<minLength){
                        minLength=length;
                        startIdx=start;
                    }
                    char c = s.charAt(start);
                    if(map.containsKey(c)){
                        map.put(c,map.get(c)+1);
                        if(map.get(c)==1){
                            uniquecharcount++;
                        }
                    }
                    start++;
                }
            }
            end++;
        }
        return startIdx==-1?"":s.substring(startIdx, startIdx+minLength);
    }
}
