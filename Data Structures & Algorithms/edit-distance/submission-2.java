class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return helper(word1,word2,0,0,n,m,dp);
    }
    public int helper(String word1, String word2, int i, int j, int n, int m, int[][] dp){
        if(j==m){
            return n-i;
        }
        if(i==n){
            return m-j;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans = 0;
        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j]= helper(word1,word2,i+1,j+1,n,m,dp);
        }
        else{
            int insert = 1+helper(word1,word2,i,j+1,n,m,dp);
            int update = 1+helper(word1,word2,i+1,j+1,n,m,dp);
            int delete = 1+helper(word1,word2,i+1,j,n,m,dp);
            ans=Math.min(insert,Math.min(update,delete));
        }
        return dp[i][j]=ans;
    }
}
