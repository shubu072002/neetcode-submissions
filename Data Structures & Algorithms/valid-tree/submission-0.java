class Solution {
    public boolean validTree(int n, int[][] edges) {
       if(edges.length!=n-1){
         return false;
       }
       boolean[] visited = new boolean[n];
       List<List<Integer>> graph = new ArrayList<>();

       for(int i=0;i<n;i++){
         graph.add(new ArrayList<>());
       }

       for(int[] edge: edges){
          int x = edge[0];
          int y = edge[1];

          graph.get(x).add(y);
          graph.get(y).add(x);
       }

       dfs(0,graph, visited);

       for(int i=0;i<n;i++){
         if(!visited[i]){
            return false;
         }
       }
       return true;
    }

    public void dfs(int node, List<List<Integer>> graph,  boolean[] visited){
        visited[node] = true;

        for(int neighbor : graph.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, graph, visited);
            }
        }
    }
}
