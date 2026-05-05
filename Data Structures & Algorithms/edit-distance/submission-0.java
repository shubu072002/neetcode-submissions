class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j]=-1;
            }
        }
        return helper(word1, word2, 0, 0,dp);
    }
    public int helper(String word1, String word2, int i, int j,int[][] dp){
        int n = word1.length();
        int m = word2.length();
        int ans =0;
        if(j==m){
            return n-i;
        }
        if(i==n){
            return m-j;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j] = helper(word1, word2, i+1, j+1,dp);
        }
        else{
            int ins =  1+ helper(word1, word2, i, j+1,dp);
            int del =  1+helper(word1, word2, i+1, j,dp);
            int rep =  1+helper(word1, word2, i+1, j+1,dp);
            ans = Math.min(ins,Math.min(del,rep));
        }
        return dp[i][j] = ans;
    }
}