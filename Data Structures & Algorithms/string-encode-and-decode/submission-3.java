class Solution {

    public String encode(List<String> strs) {
       StringBuilder sb = new StringBuilder();
       for(String str: strs){
        sb.append(str.length());
        sb.append('#');
        sb.append(str);
       }
       return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int sepIdx = str.indexOf('#',i);
            int length = Integer.parseInt(str.substring(i,sepIdx));
            i=sepIdx+1;
            String s = str.substring(i,i+length);
            res.add(s);
            i=i+length;
        }
        return res;
    }
}
