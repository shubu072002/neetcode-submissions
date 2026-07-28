class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       int currgas=0;
       int currcost=0;
       for(int i=0;i<gas.length;i++){
        currgas+=gas[i];
        currcost+=cost[i];
       } 
       if(currgas<currcost){
        return -1;
       }
       int result = 0;
       int total =0;
       for(int i=0;i<gas.length;i++){
        total+=gas[i]-cost[i];
        if(total<0){
            total=0;
            result=i+1;
        }
       } 
       return result;
    }
}
