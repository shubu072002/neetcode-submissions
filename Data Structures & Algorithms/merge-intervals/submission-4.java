class Solution {
    public int[][] merge(int[][] intervals) {
       Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> list = new ArrayList<>(); 
       int[] newInterval = intervals[0];
       list.add(newInterval);
       for(int i=1;i<intervals.length;i++){
        if(intervals[i][0]<=newInterval[1]){
            newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
        }
        else{
            list.add(intervals[i]);
            newInterval=intervals[i];
        }
       }
     return list.toArray(new int[list.size()][2]);
    }
}
