class Solution {
    int n;
    int m;
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int max = 0;
        for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
            if(grid[i][j]==1){
              int area = dfs(grid,i,j);
              max= Math.max(area, max);
            }
        } 
        }
        return max;
    }
     public int dfs(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>=n || j>=m){
            return 0;
        }
        if(grid[i][j]==0 || grid[i][j]==2 ){
            return 0;
        }
        int area = 1;
        grid[i][j]=2;
        area+=dfs(grid, i+1,j);
        area+=dfs(grid, i,j+1);
        area+=dfs(grid, i-1,j);
        area+=dfs(grid, i,j-1);

        return area;
    }
}
