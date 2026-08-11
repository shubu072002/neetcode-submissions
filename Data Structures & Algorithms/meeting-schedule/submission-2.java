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
    public boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size();
        if(n<1){
            return true;
        }
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        Interval newInterval=intervals.get(0);
        for(int i=1;i<n;i++){
            if(newInterval.end>intervals.get(i).start){
                return false;
            }
            newInterval.end = intervals.get(i).end;
        }
        return true;
    }
}
