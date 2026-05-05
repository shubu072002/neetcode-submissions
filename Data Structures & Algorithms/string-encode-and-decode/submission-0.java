class Solution {

   public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i =0;
        while(i<str.length()){
            int sepIdx = str.indexOf("#",i);
            int length = Integer.parseInt(str.substring(i,sepIdx));
            i = sepIdx+1;
            String decodedString = str.substring(i,i+length);
            list.add(decodedString);
            i = i + length;
        }

        return list;
}
}
