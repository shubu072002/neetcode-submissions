class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
       for(String s : strs){
        int n = s.length();
        sb.append(n);
        sb.append('#');
        sb.append(s);
       }
       return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int sepIdx = str.indexOf('#',i);
            int length = Integer.parseInt(str.substring(i,sepIdx));
            int startIdx = sepIdx+1;
            String s = str.substring(startIdx,startIdx+length);
            ans.add(s);
            i= startIdx+length;
        }
     return ans;
    }
}
