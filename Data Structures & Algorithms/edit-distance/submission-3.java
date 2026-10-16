class Solution {
    int n;
    int m;
    int[][] dp ;
    public int minDistance(String word1, String word2) {
        n = word1.length();
        m = word2.length();
        dp= new int[n+2][m+2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return helper(0,0,word1,word2);
    }
    public int helper(int i, int j, String word1, String word2){
        if(i==n && j==m){
            return 0;
        }
        if(j==m){
            return n-i;
        }
        if(i==n){
            return m-j;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int x =0;
        int y =0;
        int z = 0;
        if(word1.charAt(i)!=word2.charAt(j)){
             x = 1+helper(i,j+1,word1,word2);
             y = 1+ helper(i+1,j,word1,word2);
             z = 1+ helper(i+1,j+1,word1,word2);
             return dp[i][j]=Math.min(x,Math.min(y,z));
        }
        else
        {
           return dp[i][j]=helper(i+1,j+1,word1,word2);
        }
    }
}
