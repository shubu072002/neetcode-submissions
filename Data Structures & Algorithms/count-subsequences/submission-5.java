class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = s.length();
        int[][] dp = new int[n+2][m+2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        
        return helper(s,t,0,0,dp);
    }
    public int helper(String s, String t, int i, int j,int[][] dp){
        // base case
        if(j>=t.length()){
            return 1;
        }
        if(i>=s.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int x =0;
        if(s.charAt(i)==t.charAt(j)){
            x = helper(s,t,i+1,j+1,dp);
        }
        int y = helper(s,t,i+1,j,dp);

        return dp[i][j]= x + y;

    }
}
