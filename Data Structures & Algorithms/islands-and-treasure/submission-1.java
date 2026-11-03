class Solution {
    private final int INF = 2147483647;
    int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
    int n ;
    int m ;
    public void islandsAndTreasure(int[][] grid) {
        n=grid.length;
        m=grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            for(int[] dir :directions){
                int nr = r+dir[0];
                int nc = c+dir[1];

                if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==INF){
                    grid[nr][nc]=grid[r][c]+1;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
    }
}
