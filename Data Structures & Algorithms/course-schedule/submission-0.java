class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] dep  = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            graph.get(pre[1]).add(pre[0]);
            dep[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(dep[i]==0){
                queue.offer(i);
            }
        }

        int count = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            count++;
            for(int element : graph.get(curr)){
                dep[element]--;
                if(dep[element]==0){
                    queue.offer(element);
                }
            }
        }
        return count==numCourses;
    }
}
