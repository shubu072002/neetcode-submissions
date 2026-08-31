/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
      int n = intervals.size();
      if(n==0){
        return 0;
      }
      Collections.sort(intervals,(a,b)->Integer.compare(a.start,b.start));
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      pq.offer(intervals.get(0).end);
      for(int i=1;i<n;i++){
        Interval current = intervals.get(i);
        if(pq.peek()<=current.start){
            pq.poll();
        }
        pq.offer(current.end);
      }
      return pq.size();
    }
}
