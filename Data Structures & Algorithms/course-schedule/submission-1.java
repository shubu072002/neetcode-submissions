class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            int n = pre[0];
            int m =pre[1];

            list.get(m).add(n);
            inDegree[n]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        int count =0;
        while(!queue.isEmpty()){

            int curr= queue.poll();
            count++;
            for(int element: list.get(curr)){
                inDegree[element]--;
                if(inDegree[element]==0){
                    queue.offer(element);
                }
            }
        }
        return count==numCourses;
    }
}
