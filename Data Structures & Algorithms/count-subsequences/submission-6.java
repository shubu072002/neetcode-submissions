class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = s.length();
        int[][] dp=new int[n+2][m+2];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return helper(s,t,0,0,dp);
    }
    public int helper(String s, String t, int i, int j, int[][] dp){
        if(i==s.length() && j==t.length()){
            return 1;
        }
        if(i>=s.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int x =0;
        int y =0;
        if(i<s.length() && j<t.length() && s.charAt(i)==t.charAt(j)){
            x=helper(s,t,i+1,j+1,dp);
            y=helper(s,t,i+1,j,dp);
            return dp[i][j]=x+y;
        }
        else{
            return dp[i][j] = helper(s,t,i+1,j,dp);
        }
    }
}
