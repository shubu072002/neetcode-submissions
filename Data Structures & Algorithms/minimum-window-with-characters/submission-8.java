class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()){
            return "";
        }
       HashMap<Character, Integer> map = new HashMap<>();
       for(int i=0;i<t.length();i++){
        char ch = t.charAt(i);
        map.put(ch,map.getOrDefault(ch,0)+1);
       } 
       int uniquecharcount = map.size();
       int start = 0;
       int end =0;
       int startIdx = -1;
       int minLength = Integer.MAX_VALUE;
       while(end<s.length()){
        char ch = s.charAt(end);
        if(map.containsKey(ch)){
           map.put(ch,map.get(ch)-1);
           if(map.get(ch)==0){
            uniquecharcount--;
           }
           while(uniquecharcount==0){
            ch = s.charAt(start);
            int length = end-start+1;
            if(length<minLength){
               startIdx = start;
                minLength = Math.min(minLength,length);
            }
            
            minLength = Math.min(minLength,length);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
                if(map.get(ch)>0){
                    uniquecharcount++;
                }
            }
            start++;
           }
        }
        end++;
       }
       return startIdx<0?"":s.substring(startIdx, startIdx+minLength);
    }
}
