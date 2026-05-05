class Solution {
    public int numDistinct(String s, String t) {
        HashMap<String, Integer> map = new HashMap<>();
        return helper(s,t,0,"",map);
    }
    public int helper(String s , String t , int index, String temp,   HashMap<String, Integer> map){
        if(temp.equals(t)){
            return 1;
        }
        if(temp.length()>=t.length() || index>=s.length()){
            return 0;
        }
        String key = index + temp;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int x = helper(s,t,index+1,temp+s.charAt(index),map);
        int y = helper(s,t,index+1,temp,map);
        map.put(key,x+y);
        return x+y;
}
}
