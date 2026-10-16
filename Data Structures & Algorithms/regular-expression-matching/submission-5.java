class Solution {
    int n ;
    int m;
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        n = s.length();
        m= p.length();
        dp= new Boolean[n+2][m+2];

        return helper(0,0,s,p);
    }
    public boolean helper(int i, int j, String s, String p){
        if(j==m){
            return i==n;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        boolean match  = (i<n && j<m && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'));
        boolean x=false;
        boolean y = false;
        if(j+1<m && p.charAt(j+1)=='*'){
            x= helper(i,j+2,s,p);
            y= match && helper(i+1,j,s,p);
            return dp[i][j] = x||y;
        }
        else{
            return dp[i][j]  = match && helper(i+1,j+1,s,p);
        }
    }
}
