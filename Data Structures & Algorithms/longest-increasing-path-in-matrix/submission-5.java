class Solution {
    int[][] directions={{-1,0},{0,1},{1,0},{0,-1}};
    int n ;
    int m ;
    int[][] dp ;
    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        int max = Integer.MIN_VALUE;
        dp = new int[n+2][m+2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int curr = helper(i,j,matrix);
                max = Math.max(max, curr);
            }
        }
        return max;
    }
    public int helper(int i, int j , int[][] matrix){
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int curr =1;
        for(int[] dir: directions){
            int x = i+dir[0];
            int y = j+dir[1];

            if(x<0 || y<0 || x>=n || y>=m){
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
