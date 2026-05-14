class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        String[] mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(digits,res,mapping,0,new StringBuilder());
        return res;
    }
    public void helper(String digits, List<String> res, String[] mapping, int idx, StringBuilder sb ){
        if(idx>=digits.length()){
            res.add(sb.toString());
            return;
        }
        int number = digits.charAt(idx) - '0';
        String str = mapping[number];
        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
            helper(digits,res,mapping,idx+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
