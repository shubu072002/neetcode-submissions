class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            int x = pre[0];
            int y = pre[1];

            graph.get(y).add(x);
            inDegree[pre[0]]++;
        }
        
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int count = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            res[count]=curr;
            count++;
            
            for(int ele : graph.get(curr)){
                inDegree[ele]--;
                if(inDegree[ele]==0){
                    queue.offer(ele);
                }
            }

        }
        if(count==numCourses){
            return res;
        }
         return new int[]{};
    }
}
