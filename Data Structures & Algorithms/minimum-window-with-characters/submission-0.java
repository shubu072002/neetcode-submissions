class Solution {
    public String minWindow(String s, String t) {
       int n = s.length();
       int left = 0;
       int right =0;
       int startIdx = -1;
       int minWindow = Integer.MAX_VALUE;
       HashMap<Character, Integer> map = new HashMap<>();
       for(int i=0;i<t.length();i++){
        char ch = t.charAt(i);
        map.put(ch,map.getOrDefault(ch,0)+1);
       } 
       int uniqueCharCount = map.size();
       while(right<n){
        char ch = s.charAt(right);
        if(map.containsKey(ch)){
            map.put(ch,map.get(ch)-1);
            if(map.get(ch)==0){
                uniqueCharCount--;
            }
        }
        while(uniqueCharCount==0){
            int length = right-left+1;
            if(length<minWindow){
                minWindow=length;
                startIdx = left;
            }
            ch = s.charAt(left);
            if(map.containsKey(ch)){
              map.put(ch,map.get(ch)+1);
              if(map.get(ch)>0){
                uniqueCharCount++;
              }
            }
            left++;
        }
        right++;
       }
       if(startIdx<0){
        return "";
       }
       return s.substring(startIdx,startIdx+minWindow);
    }
}
