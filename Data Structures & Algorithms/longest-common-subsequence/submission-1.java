class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j]=-1;
            }
        }
        return helper(text1, text2, 0, 0, dp);
    }
    public int helper(String text1, String text2, int i, int j, int[][] dp){
        //base case
        if(i>=text1.length() || j>=text2.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(text1.charAt(i)==text2.charAt(j)){
           dp[i][j] = 1 + helper(text1, text2, i+1, j+1, dp);
           return dp[i][j];
        }
        else{
            int case1 = helper(text1, text2, i, j+1, dp);
            int case2 = helper(text1, text2, i+1, j, dp);
            dp[i][j]= Math.max(case1, case2);
            return dp[i][j];
        }
    }
}
