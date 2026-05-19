class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left =0;
        int right = 0;
        int startIdx =-1;
        int minWindow = Integer.MAX_VALUE;
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int uniqueCharCount= map.size();
        while(right<s.length()){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);

                 if(map.get(ch)==0){
                uniqueCharCount--;
            }
            }
            while(uniqueCharCount==0){
                int length = right - left +1;
                if(length<minWindow){
                    minWindow=length;
                    startIdx = left;
                }
                char c = s.charAt(left);
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                    if(map.get(c)>0){
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
        return s.substring(startIdx, startIdx+minWindow);
    }
}
