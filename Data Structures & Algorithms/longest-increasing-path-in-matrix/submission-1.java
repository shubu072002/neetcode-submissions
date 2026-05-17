class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if(n==0 || m==0){
            return 0;
        }
        if(matrix==null){
            return 0;
        }
        int[][] dp = new int[n+2][m+2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        int maxLength =1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int curr = helper(matrix,i,j,directions,dp);
                maxLength = Math.max(maxLength,curr);
            }
        }
        return maxLength;
    }
    public int helper(int[][] matrix, int i, int j, int[][] directions,int[][] dp){
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int curr = 1;
            for(int[] dir: directions){
            int x = i + dir[0];
            int y = j + dir[1];

            if(x<0 || y<0 || x==matrix.length || y==matrix[0].length){
                continue;
            }
            if(matrix[x][y]<=matrix[i][j]){
                continue;
            }
            curr = Math.max(curr, 1+helper(matrix,x,y,directions,dp));
        }
        dp[i][j] = curr;
        return curr;
    }
}
