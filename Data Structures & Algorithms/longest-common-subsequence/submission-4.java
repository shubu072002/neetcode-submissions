class Solution {
    int n;
    int m;
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        n=text1.length();
        m = text2.length();
        dp=new int[n+2][m+2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return helper(0,0,text1,text2);
    }
    public int helper(int i, int j, String text1, String text2){
        if(i==n || j==m){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(i<n && j<m && text1.charAt(i)==text2.charAt(j)){
            return dp[i][j] = 1+helper(i+1,j+1,text1, text2);
        }
        else{
            int x = helper(i+1,j,text1,text2);
            int y = helper(i,j+1,text1,text2);
            return dp[i][j] = Math.max(x,y);
        }
    }
}
