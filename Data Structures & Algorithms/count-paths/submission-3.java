class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return helper(grid,0,0,dp);
    }
    public int helper(int[][] grid, int r, int c, int[][] dp ){
        // base case 
        if(r>=grid.length || c>=grid[0].length){
            return 0;
        }
        if(r==grid.length-1 && c==grid[0].length-1){
            return 1;
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        int x = helper(grid, r, c+1,dp);
        int y = helper(grid, r+1, c,dp);
        return dp[r][c]=x + y;
    }
}
