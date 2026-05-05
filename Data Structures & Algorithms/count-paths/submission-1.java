class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        int[][] grid = new int[m][n];
        return helper(0,0,grid,dp);
    }
    public int helper(int row, int col, int[][]grid, int[][] dp){
        //base 
        if(row>=grid.length || col>=grid[0].length){
            return 0;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        // base case for valid case 
        if(row==grid.length-1 && col==grid[0].length-1){
            return 1 ;
        }
        int right = helper(row, col+1, grid, dp);
        int down =  helper(row+1 ,col,grid, dp);
        dp[row][col] = right + down;
        return dp[row][col];
    }
}
