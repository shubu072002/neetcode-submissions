class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int left = 0;
        int right = 0;
        int minwindow = Integer.MAX_VALUE;
        int startidx = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<m;i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)+1);
        }
        int uniquecharcount = map.size();
        while(right<n){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                    uniquecharcount--;
                }
            }
            while(uniquecharcount==0){
                int length = right - left + 1;
                if(length<minwindow){
                    minwindow = length;
                    startidx = left;
                }
                char c = s.charAt(left);
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                    if(map.get(c)>0){
                      uniquecharcount++;  
                    }
                }
                left++;
            }
            right++;
        }
        if(startidx<0){
            return "";
        }
        return s.substring(startidx,startidx+minwindow);
    }
}
