class Solution {
    int n ;
    int m ;
    int[][] directions={{-1,0},{0,1},{1,0},{0,-1}};

    public void dfs(int i , int j, boolean[][] visited, int[][] heights, int prev){
        if(i<0 || j<0 || i>=n || j>=m || visited[i][j]==true || prev>heights[i][j]){
            return;
        }
        visited[i][j]=true;

        for(int[] dir: directions){
            int nr = i+dir[0];
            int nc= j + dir[1];
            dfs(nr,nc,visited,heights,heights[i][j]);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n=heights.length;
        m=heights[0].length;
        
        boolean[][] pacificVisited = new boolean[n][m];
        boolean[][] atlanticVisited = new boolean[n][m];
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0;i<m;i++){
            dfs(0,i,pacificVisited,heights, Integer.MIN_VALUE);
            dfs(n-1,i,atlanticVisited,heights, Integer.MIN_VALUE);
        }
        for(int i=0;i<n;i++){
            dfs(i,0,pacificVisited,heights, Integer.MIN_VALUE);
            dfs(i,m-1,atlanticVisited,heights, Integer.MIN_VALUE);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacificVisited[i][j]==true && atlanticVisited[i][j]==true){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    
}
