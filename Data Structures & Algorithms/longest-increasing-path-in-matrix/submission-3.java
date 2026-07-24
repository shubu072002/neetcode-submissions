class Solution {
    public int longestIncreasingPath(int[][] matrix) {
       int n = matrix.length;
       int m = matrix[0].length;
       int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
       int[][] dp =new int[n+2][m+2];
       int maxLength = 1;
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            int curr = dfs(matrix,i,j,n,m,dp,directions);
            maxLength=Math.max(curr,maxLength);
        }
       } 
       return maxLength;
    }
    public int dfs(int[][] matrix, int i , int j , int n, int m, int[][] dp, int[][] directions ){
        int curr =1;
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        for(int[] dir: directions){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x<0 || x>=n || y<0 || y>=m){
                continue;
            }
            if(matrix[x][y]<=matrix[i][j]){
                continue;
            }
            curr = Math.max(curr, 1 + dfs(matrix,x,y,n,m,dp,directions));
        }
        dp[i][j]=curr;
        return curr;
    }
}
