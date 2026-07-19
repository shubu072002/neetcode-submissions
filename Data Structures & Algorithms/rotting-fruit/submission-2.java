class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshcount=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    freshcount++;
                }
                else if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        if(freshcount==0){
            return 0;
        }
        int time =0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] rottenloc = queue.poll();
                int r=rottenloc[0];
                int c=rottenloc[1];
                int[][] neighbours = {{r-1,c},{r,c+1},{r+1,c},{r,c-1}};
                for(int[] neighbour: neighbours){
                    int nr = neighbour[0];
                    int nc = neighbour[1];
                    if(nr<0 || nr>=n || nc<0 || nc>=m ||
                    grid[nr][nc]==2 || grid[nr][nc]==0){
                        continue;
                    }
                    grid[nr][nc]=2;
                    queue.offer(new int[]{nr,nc});
                }
            }
            time++;
            freshcount -= queue.size();
            if(freshcount==0){
                break;
            }
        }
        return freshcount==0?time:-1;
    }
}
