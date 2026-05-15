class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][]dp = new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
               dp[i][j]=-1;
            }
        }
        return helper(text1,text2,0,0,dp);
    }
    public int helper(String text1, String text2, int i, int j, int[][] dp){
    // base case 
    if(i==text1.length() || j==text2.length()){
        return 0;
    }
    if(dp[i][j]!=-1){
        return dp[i][j];
    }
    if(text1.charAt(i)==text2.charAt(j)){
        return 1 + helper(text1,text2,i+1,j+1,dp);
    }
    else{
        int x = helper(text1,text2,i,j+1,dp);
        int y = helper(text1,text2,i+1,j,dp);
        return dp[i][j] = Math.max(x,y);
    }
    }
}
