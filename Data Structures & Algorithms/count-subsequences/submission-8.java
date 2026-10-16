class Solution {
    int n ;
    int m ;
    int[][] dp;
    public int numDistinct(String s, String t) {
        n = s.length();
        m = t.length();
        dp = new int[n+2][m+2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }

        return helper(0,0,s,t);
    }
    public int helper(int i, int j, String s, String t){
        if(i==n && j==m){
            return 1;
        }
        if(i==n){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int x=0;
        int y =0;
        if(i<n && j<m && s.charAt(i)==t.charAt(j)){
            x= helper(i+1,j,s,t);
            y= helper(i+1,j+1,s,t);
            return dp[i][j]=x +y;
        }
        else{
            return dp[i][j] =  helper(i+1,j,s,t);
        }
    }
}
