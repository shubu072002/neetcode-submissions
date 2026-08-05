class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()<1){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        String[] mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(digits,mapping,0,res,"");
        return res;
    }
    public void helper(String digits, String[] mapping, int idx, List<String> res, String temp){
        if(idx>=digits.length()){
            res.add(temp);
            return;
        }
        int mapIdx = digits.charAt(idx)-'0';
        String str = mapping[mapIdx];
        for(int i=0;i<str.length();i++){
            helper(digits,mapping,idx+1,res,temp+(str.charAt(i)));
        }
    }
}
