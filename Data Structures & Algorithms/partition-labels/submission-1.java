class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int i=0;
        int n = s.length();
        while(i<n){
            int startIdx = i;
            int lastIdx = s.lastIndexOf(s.charAt(startIdx));
            for(int j=startIdx+1;j<=lastIdx;j++){
                int lastIdxOfNextChar = s.lastIndexOf(s.charAt(j));
                if(lastIdxOfNextChar>lastIdx){
                    lastIdx=lastIdxOfNextChar;
                }
            }
            res.add(lastIdx-startIdx+1);
            i=lastIdx+1;
        }
        return res;
    }
}