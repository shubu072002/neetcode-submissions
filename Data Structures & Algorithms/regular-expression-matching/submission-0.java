class Solution {
    public boolean isMatch(String s, String p) {
         return helper(s,p,0,0);
    }
    public boolean helper(String s, String p, int i, int j){
    if (j == p.length()) {
    return i == s.length();
}
       boolean match = (i < s.length() && j<p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')); 
       boolean x = false;
       boolean y = false;
       if(j+1<p.length() && p.charAt(j+1)=='*'){
          x= helper(s,p,i,j+2);
          y= match && helper(s,p,i+1,j);
          return x||y;
       }
       else{
       return match && helper(s,p,i+1,j+1);
       }
    }
}