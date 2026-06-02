class Solution {
    public int longestConsecutive(int[] nums) {
       if(nums==null || nums.length<1){
        return 0;
       }
       HashSet<Integer> set = new HashSet<>();
       for(int element: nums){
        set.add(element);
       }
       int maxCount = Integer.MIN_VALUE;
       for(int element: set){
        int count = 1;
        int prev = element-1;
        while(set.contains(prev)){
            count++;
            prev = prev -1 ;
        }
        maxCount= Math.max(count,maxCount);
       } 
       return maxCount;
    }
}
