class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<>();
        }
       List<String> result = new ArrayList<>();
       String[] mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
       helper(0,digits,mapping,result,new StringBuilder());
       return result; 
    }
    public void helper(int idx, String digits,String[] mapping, List<String> result,StringBuilder temp ){
        if(idx==digits.length()){
            result.add(new String(temp));
            return;
        }
        int digit = digits.charAt(idx)-'0';
        String str = mapping[digit];
        for(int i=0;i<str.length();i++){
            temp.append(str.charAt(i));
            helper(idx+1,digits,mapping,result,temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
