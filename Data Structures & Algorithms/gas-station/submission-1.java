class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int currgas = 0;
        int currcost =0;
        for(int i=0;i<n;i++){
            currgas+=gas[i];
            currcost+=cost[i];
        }
        if(currgas<currcost){
            return -1;
        }
        int total = 0;
        int startIdx = 0;
        for(int i=0;i<n;i++){
            total+=gas[i]-cost[i];
            if(total<0){
                total=0;
                startIdx=i+1;
            }
        }
         return startIdx;
    }
}
