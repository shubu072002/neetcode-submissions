class Solution {
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    int[][] dp ;
    int n;
    int m;
    public int longestIncreasingPath(int[][] matrix) {
         n = matrix.length;
         m = matrix[0].length;
         dp= new int[n+2][m+2];
         for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
         }
        int maxLength = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            int curr = helper(i,j,matrix);
            maxLength = Math.max(maxLength,curr);
            }
        }
        return maxLength;
    }
    public int helper(int i, int j, int[][] matrix){
        int curr = 1;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        for(int[] direction: directions){
            int x= i+direction[0];
            int y= j+direction[1];

            if(x<0 || x>=n || y<0 || y>=m){
                continue;
            }
            if(matrix[x][y]<=matrix[i][j]){
                continue;
            }
            curr = Math.max(curr, 1+helper(x,y,matrix));
        }
        return dp[i][j] = curr;
    }
}
